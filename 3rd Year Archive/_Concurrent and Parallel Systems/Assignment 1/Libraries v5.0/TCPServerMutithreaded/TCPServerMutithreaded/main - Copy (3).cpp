#include <iostream>
#include <algorithm>
#include <string>
#include <thread>
#include <vector>
#include <regex>
#include <map>
#include <unordered_set>
#include <unordered_map>

#include "config.h"
#include "TCPServer.h"
#include "TCPClient.h"

#define DEFAULT_PORT 12345

using namespace std;

bool terminateServer = false;
unordered_map<string, vector<string>> topics;
static const regex postRX("^POST(@[^@#]*)#(.+)$"); // should these be static?
static const regex countRX("^COUNT(@[^@#]*)$");
static const regex readRX("^READ(@[^@#]*)#([0-9]+)$");

void serverThreadFunction(TCPServer* server, ReceivedSocketData&& data);

int main()
{
	TCPServer server(DEFAULT_PORT);

	ReceivedSocketData receivedData;

	vector<thread> serverThreads;

	cout << "Starting server. Send \"exit\" (without quotes) to terminate." << endl;

	while (!terminateServer)
	{
		receivedData = server.accept();

		if (!terminateServer)
		{
			serverThreads.emplace_back(serverThreadFunction, &server, receivedData);
		}
	}

	for (auto& th : serverThreads)
		th.join();

	cout << "Server terminated." << endl;

	return 0;
}

void serverThreadFunction(TCPServer* server, ReceivedSocketData&& data)
{
	unsigned int socketIndex = (unsigned int)data.ClientSocket;

	do {
		server->receiveData(data, 0);

		if (data.request != "")
		{
#if DEBUG
			cout << "[" << socketIndex << "] Bytes received: " << data.request.size() << endl;
			cout << "[" << socketIndex << "] Data received: " << data.request << endl;
#endif

			data.reply = data.request;
			smatch matches;

			if (data.request == "list" || data.request == "LIST")
			{
				data.reply = "";
				for (auto t : topics)
				{
					data.reply.append(t.first + "#");
				}
				if (topics.size() > 0)
					data.reply.pop_back();
			}
			else if (regex_search(data.request, matches, postRX))
			{
				//if (matches.size() < 3) // invalid request; etc. for other request types
				string topicName = matches[1];
				string content = matches[2];

				vector<string>* topic = &topics[topicName];
				topic->emplace_back(content);

				data.reply = to_string(topic->size() - 1);
			}
			else if (regex_search(data.request, matches, readRX))
			{
				string topicID = matches[1];
				unsigned int postID = stoi(matches[2]);
				string content;
				if (topics.find(topicID) != topics.end())
					content = topics[topicID][postID];

				data.reply = content;
			}
			else if (regex_search(data.request, matches, countRX))
			{
				data.reply = to_string(topics[matches[1]].size());
			}
			if (data.request == "exit" || data.request == "EXIT")
			{
#if DEBUG
				cout << "[" << socketIndex << "] Data received: " << data.request << endl;
				cout << "[" << socketIndex << "] Exiting... Bye bye!" << endl;
#endif

				terminateServer = true;
				data.reply = data.request;
				server->sendReply(data);
			}
			else // invalid request
			{
				data.reply = "";
			}

			server->sendReply(data);
		}

	} while (data.request != "exit" && data.request != "EXIT" && !terminateServer);

	if (!terminateServer && (data.request == "exit" || data.request == "EXIT"))
	{
		terminateServer = true;

		TCPClient tempClient(string("127.0.0.1"), DEFAULT_PORT);
		tempClient.OpenConnection();
		tempClient.CloseConnection();
	}

	server->closeClientSocket(data);
}