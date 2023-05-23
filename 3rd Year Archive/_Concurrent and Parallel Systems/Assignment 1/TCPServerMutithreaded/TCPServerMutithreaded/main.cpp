#include <iostream>
#include <algorithm>
#include <string>
#include <thread>
#include <vector>
#include <regex>
#include <map>
#include <mutex>
#include <shared_mutex>

#include "config.h"
#include "TCPServer.h"
#include "TCPClient.h"
#include "barrier.hpp"

using namespace std;

#define DEFAULT_PORT 12345

#if _DEBUG
#define DEBUG_OUTPUT 0
#endif

bool terminateServer = false;

const regex countRX("^COUNT(@[^@#]*)$");
const regex postRX("^POST(@[^@#]*)#(.+)$");
const regex readRX("^READ(@[^@#]*)#([0-9]+)$");

map<string, vector<string>> topics;
map<string, shared_mutex> locks;

barrier barr(8);

void serverThreadFunction(TCPServer* server, ReceivedSocketData &&data);
void processRequest(ReceivedSocketData& data);
bool topicExists(string topicID);
string truncateTo140(string str);

int main()
{
	TCPServer server(DEFAULT_PORT);

	ReceivedSocketData receivedData;

	vector<std::thread> serverThreads;

	cout << "Starting server. Send \"exit\" (without quotes) to terminate." << endl;

	while (!terminateServer)
	{
		receivedData = server.accept();

		if (!terminateServer)
		{
			serverThreads.emplace_back(serverThreadFunction, &server, receivedData);
			cout << "Client connected on socket " << receivedData.ClientSocket << endl;
		}
	}

	for (auto& th : serverThreads)
		th.join();

	cout << "Server terminated." << endl << "Press any key to continue...";
	cin;

	return 0;
}

void serverThreadFunction(TCPServer* server, ReceivedSocketData &&data)
{
	unsigned int socketIndex = (unsigned int) data.ClientSocket;

	do {
		server->receiveData(data, 0);

#if DEBUG_OUTPUT
		cout << "[" << socketIndex << "] Bytes received: " << data.request.size() << endl;
		cout << "[" << socketIndex << "] Data received: " << data.request << endl;
#endif

		if (data.request != "")
		{
			processRequest(data);
			server->sendReply(data);
		}
	} while (!terminateServer);

	TCPClient tempClient(std::string("127.0.0.1"), DEFAULT_PORT);
	tempClient.OpenConnection();
	tempClient.CloseConnection();

	server->closeClientSocket(data);
	cout << "Client socket " << socketIndex << " disconnected" << endl;
}

void processRequest(ReceivedSocketData &data)
{
	smatch matches;
	
	if (data.request == "list" || data.request == "LIST")
	{
		data.reply = "";

		for (auto i = topics.begin(); i != topics.end(); ++i)
		{
			data.reply += i->first + "#";
		}
		if (topics.size() > 0)
			data.reply.pop_back();

		return;
	}
	else if (data.request == "exit" || data.request == "EXIT")
	{
		data.reply = data.request;
		terminateServer = true;

		return;
	}
	else if (data.request.substr(0, 4) == "POST" && regex_search(data.request, matches, postRX))
	{
		string topic = truncateTo140(matches[1]);
		string content = truncateTo140(matches[2]);
		
		if (topicExists(topic))
		{
			lock_guard<shared_mutex> lock(locks[topic]);
			topics[topic].push_back(content);
		}
		else
		{
			lock_guard<shared_mutex> lock(locks[topic]);
			topics[topic] = vector<string>({content});
		}

		data.reply = to_string(topics[topic].size() - 1);

		return;
	}
	else if (data.request.substr(0, 4) == "READ" && regex_search(data.request, matches, readRX))
	{
		string topic = truncateTo140(matches[1]);
		int postID = stoi(matches[2]);

		if (topicExists(topic) && topics[topic].size() > postID)
		{
			locks[topic].lock_shared();
			data.reply = topics[topic][postID];
			locks[topic].unlock_shared();
		}
		else
		{
			data.reply = "";
		}

		return;
	}
	else if (data.request.substr(0, 5) == "COUNT" && regex_search(data.request, matches, countRX))
	{
		string topic = truncateTo140(matches[1]);

		if (topicExists(topic))
		{
			locks[topic].lock_shared();
			data.reply = to_string(topics[topic].size());
			locks[topic].unlock_shared();
		}
		else
		{
			data.reply = "0";
		}

		return;
	}
	else
	{
		data.reply = "";
		return;
	}
}

bool topicExists(string topicID)
{
	lock_guard<shared_mutex> lock(locks[topicID]);
	return topics.count(topicID);
}

string truncateTo140(string str)
{
	return str.substr(0, 140);
}