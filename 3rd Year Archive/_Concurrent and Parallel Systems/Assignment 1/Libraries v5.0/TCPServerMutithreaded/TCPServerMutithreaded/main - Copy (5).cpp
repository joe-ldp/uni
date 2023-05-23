#include <iostream>
#include <algorithm>
#include <string>
#include <thread>
#include <vector>
#include <regex>
#include <map>
#include <unordered_set>
#include <unordered_map>
#include <mutex>
#include <shared_mutex>

#include "config.h"
#include "TCPServer.h"
#include "TCPClient.h"

#define DEFAULT_PORT 12345
#if _DEBUG
//#define DEBUG_OUTPUT 0
#endif

struct Topic
{
	std::vector<std::string> posts;
	unsigned int numPosts;
	std::shared_mutex lock;
};

bool terminateServer = false;
std::unordered_map<std::string, Topic*> topics;
static const std::regex countRX("^COUNT(@[^@#]*)$"); // should these be static?
static const std::regex postRX("^POST(@[^@#]*)#(.+)$");
static const std::regex readRX("^READ(@[^@#]*)#([0-9]+)$");

void serverThreadFunction(TCPServer* server, ReceivedSocketData && data);

int main()
{
	TCPServer server(DEFAULT_PORT);

	ReceivedSocketData receivedData;

	std::vector<std::thread> serverThreads;

	std::cout << "Starting server. Send \"exit\" (without quotes) to terminate." << std::endl;

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

	std::cout << "Server terminated." << std::endl;

	return 0;
}

void serverThreadFunction(TCPServer* server, ReceivedSocketData && data)
{
	unsigned int socketIndex = (unsigned int) data.ClientSocket;

	do {
		server->receiveData(data, 0);

		if (data.request != "")
		{
#if DEBUG_OUTPUT
			std::cout << "[" << socketIndex << "] Bytes received: " << data.request.size() << std::endl;
			std::cout << "[" << socketIndex << "] Data received: " << data.request << std::endl;
#endif

			std::smatch matches;

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
			else if (std::regex_search(data.request, matches, postRX))
			{
				//std::string topicName = matches[1];
				//std::string content = matches[2];

				Topic *topic = topics[matches[1]];
				topic->lock.lock();
				topic->posts.emplace_back(matches[2]);
				topic->numPosts++;
				topic->lock.unlock();
				unsigned int postID = topic->numPosts - 1;

				data.reply = std::to_string(postID);
			}
			else if (std::regex_search(data.request, matches, readRX))
			{
				//std::string topicName = matches[1];
				Topic *topic = topics[matches[1]];
				unsigned int postID = std::stoi(matches[2]);
				std::string content;
				if (topics.find(matches[1]) != topics.end() && postID < (topic->numPosts - 1))
				{
					topic->lock.lock_shared();
					content = topics[matches[1]][postID];
					topic->lock.unlock_shared();
				}

				data.reply = content;
			}
			else if (std::regex_search(data.request, matches, countRX))
			{
				std::string id = matches[1];
				Topic *topic = topics[id];
				data.reply = std::to_string(topic->numPosts - 1);
			}
			else if (data.request == "exit" || data.request == "EXIT")
			{
#if DEBUG_OUTPUT
				std::cout << "[" << socketIndex << "] Data received: " << data.request << std::endl;
				std::cout << "[" << socketIndex << "] Exiting... Bye bye!" << std::endl;
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

		TCPClient tempClient(std::string("127.0.0.1"), DEFAULT_PORT);
		tempClient.OpenConnection();
		tempClient.CloseConnection();
	}

	server->closeClientSocket(data);
}