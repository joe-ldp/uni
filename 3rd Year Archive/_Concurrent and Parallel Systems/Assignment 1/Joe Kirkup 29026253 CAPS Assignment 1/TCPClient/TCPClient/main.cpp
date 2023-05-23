#include <iostream>
#include <vector>
#include <thread>
#include <map>
#include <shared_mutex>
#include <iterator>
#include <random>

#include "TCPClient.h"
#include "barrier.hpp"

#define DEFAULT_PORT 12345

#if _DEBUG
#define DEBUG_OUTPUT 1
#endif

using namespace std;

void clientThreadFunction(int threadID, char* ip, char job, barrier& barr, string& output);
void generateRequest(char job, string& request, double modifier);
double GetElapsedMs(LARGE_INTEGER& startTime);
bool topicExists(string topicID);
string truncateTo140(string str);

map<string, vector<string>> topics;
map<string, shared_mutex> locks;
LARGE_INTEGER startTime;
unsigned int runtime;

int main(int argc, char **argv)
{
	// Validate the parameters
	if (argc != 6) {
		printf("usage: %s server-name|IP-address number-of-poster-threads number-of-reader-threads runtime throttling\n", argv[0]);
		return 1;
	}

	char* IP = argv[1];
	const int POSTER_THREADS = atoi(argv[2]);
	const int READER_THREADS = atoi(argv[3]);
	runtime = atoi(argv[4]) * 1000;
	const int THROTTLING = atoi(argv[5]);
	const int NUM_THREADS = POSTER_THREADS + READER_THREADS;

	vector<thread> clientThreads;
	barrier barr(NUM_THREADS + 1);
	string* outputs = new string[NUM_THREADS];

	for (int i = 0; i < NUM_THREADS; i++)
	{
		char job;
		if (i < POSTER_THREADS)
			job = 'p';
		else
			job = 'r';
		//int threadID, char* ip, char job, barrier & barr, string & output)
		clientThreads.emplace_back(clientThreadFunction, i, ref(IP), job, ref(barr), ref(outputs[i]));
	}

	barr.count_down_and_wait();

	QueryPerformanceCounter(&startTime);

	for (auto& th : clientThreads)
		th.join();

	auto elapsed = GetElapsedMs(startTime);
	cout << elapsed << "ms elapsed\n";
	for (int i = 0; i < NUM_THREADS; i++)
	{
		cout << outputs[i];
	}
	cout << "Press any key to continue...";
	cin;

 	return 0;
}

void clientThreadFunction(int threadID, char* ip, char job, barrier& barr, string& output)
{
	TCPClient client(ip, DEFAULT_PORT);
	string request;
	double elapsed = GetElapsedMs(startTime);
	unsigned int actions = 0;
	cout << job + "\n";

	client.OpenConnection();

	barr.count_down_and_wait();

	cout << elapsed << runtime << endl;
	while (elapsed < runtime)
	{
		elapsed = GetElapsedMs(startTime);
		generateRequest(job, request, elapsed);

		if (request != "")
		{
#ifdef DEBUG_OUTPUT
		std::cout << "String sent: " + request + "\n";
		std::cout << "Bytes sent: " + to_string(request.size()) + "\n";
#endif

			string response = client.send(request);
			actions++;

#ifdef DEBUG_OUTPUT
		std::cout << "String returned: " + response + "\n";
		std::cout << "Bytes received: " + to_string(response.size()) + "\n";
#endif
		}
	}

	client.CloseConnection();

	const string jobDesc = job == 'p' ? "poster" : "reader";
	output = "Thread ID " + to_string(threadID) + " with job " + jobDesc + " completed " + to_string(actions) + " requests in " + to_string(elapsed / 1000) + " seconds.\n";
}

void generateRequest(char job, string &request, double modifier)
{
	string topic, content, post;
	switch (job)
	{
	case 'p':
		topic = truncateTo140(to_string(( (int) (modifier * 10) % 26) + 64));
		content = truncateTo140(to_string(( (int) (modifier) % 26) + 64));

		if (topicExists(topic))
		{
			lock_guard<shared_mutex> lock(locks[topic]);
			topics[topic].push_back(content);
		}
		else
		{
			lock_guard<shared_mutex> lock(locks[topic]);
			topics[topic] = vector<string>({ content });
		}
		request = "POST@#" + topic + "#" + content;
		break;
	case 'r':
		if (topics.size() > 1)
		{
			auto it = topics.begin();
			std::advance(it, (rand() % (topics.size() - 1)));
			topic = it->first;
			post = to_string(rand() % topics[topic].size());
			request = "READ@" + topic + "#" + post;
		}
		else {
			cout << "No topics to read yet\n";
		}
		break;
	}
}

double GetElapsedMs(LARGE_INTEGER& startTime)
{
	LARGE_INTEGER endTime, elapsed, frequency;

	QueryPerformanceCounter(&endTime);

	if (!QueryPerformanceFrequency(&frequency))
		cout << "QueryPerformanceFrequency failed!\n";
	frequency.QuadPart;

	elapsed.QuadPart = endTime.QuadPart - startTime.QuadPart;
	elapsed.QuadPart /= frequency.QuadPart;
	return elapsed.QuadPart;
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