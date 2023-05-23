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
#include <deque>
#include <string.h>

#include "config.h"
#include "TCPServer.h"
#include "TCPClient.h"
#include "barrier.hpp"

#define DEFAULT_PORT 12345
#if _DEBUG
#define DEBUG_OUTPUT 1
#endif

bool terminateServer = false;
std::unordered_map<std::string, std::vector<std::string>> topics;
std::unordered_map<std::string, std::shared_mutex> topicLocks;
static const std::regex countRX("^COUNT(@[^@#]*)$"); // should these be static?
static const std::regex postRX("^POST(@[^@#]*)#(.+)$");
static const std::regex readRX("^READ(@[^@#]*)#([0-9]+)$");

void serverThreadFunction(TCPServer* server, ReceivedSocketData&& data);

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

void serverThreadFunction(TCPServer* server, ReceivedSocketData&& data)
{
	unsigned int socketIndex = (unsigned int)data.ClientSocket;

	do {
		server->receiveData(data, 0);

		if (data.request != "")
		{
#if DEBUG_OUTPUT
			std::cout << "[" << socketIndex << "] Bytes received: " << data.request.size() << std::endl;
			std::cout << "[" << socketIndex << "] Data received: " << data.request << std::endl;
#endif

			std::smatch matches;
			data.reply = "";

			if (std::regex_search(data.request, matches, postRX))
			{
				std::string topicID = ((std::string)matches[1]).substr(0, 140);
				std::string content = ((std::string)matches[2]).substr(0, 140);

				topicLocks[topicID].lock();
				topics[topicID].emplace_back(content);
				topicLocks[topicID].unlock();

				data.reply = std::to_string(topics[matches[1]].size() - 1);
			}
			else if (std::regex_search(data.request, matches, readRX))
			{
				std::string topicID = ((std::string)matches[1]).substr(0, 140);
				unsigned int postID = std::stoi(matches[2]);
				if (topics.find(topicID) != topics.end() && postID < topics[topicID].size())
				{
					topicLocks[topicID].lock();
					data.reply = topics[topicID][postID];
					topicLocks[topicID].unlock();
				}

			}
			else if (std::regex_search(data.request, matches, countRX))
			{
				std::string topicID = ((std::string)matches[1]).substr(0, 140);
				data.reply = std::to_string(topics[topicID].size());
			}
			else if (data.request == "list" || data.request == "LIST")
			{
				for (auto t : topics)
				{
					data.reply.append(t.first + "#");
				}
				if (topics.size() > 0)
					data.reply.pop_back();
			}
			else if (data.request == "exit" || data.request == "EXIT")
			{
				std::cout << "[" << socketIndex << "] Data received: " << data.request << std::endl;
				std::cout << "[" << socketIndex << "] Exiting... Bye bye!" << std::endl;

				terminateServer = true;
				data.reply = data.request;
				server->sendReply(data);
			}
			else
			{
				data.reply = "";
			}

			server->sendReply(data);
		}

	} while (!terminateServer);

	if (!terminateServer && (data.request == "exit" || data.request == "EXIT"))
	{
		terminateServer = true;

		TCPClient tempClient(std::string("127.0.0.1"), DEFAULT_PORT);
		tempClient.OpenConnection();
		tempClient.CloseConnection();
	}

	server->closeClientSocket(data);
}