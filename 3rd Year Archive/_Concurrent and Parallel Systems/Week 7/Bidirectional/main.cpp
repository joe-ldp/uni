#include <thread>
#include <mutex>
#include <iostream>

#include "fifo.hpp"
#include "barrier.hpp"

#define TIME_SECS 5

singleFifo <int,100> fifo1;
singleFifo <int,100> fifo2;
barrier bar(3);
unsigned int terminate;
unsigned int counter;
unsigned int maxReceived;

void clientFunction();
void serverFunction();


int main ()
{
    std::thread *client;
    std::thread *server;

    fifo1.clear();
    fifo2.clear();
    terminate = 0;

    client = new std::thread(clientFunction);
    server = new std::thread(serverFunction);

    std::cout << "main ready\n";
    bar.count_down_and_wait();
    std::this_thread::sleep_for(std::chrono::seconds(TIME_SECS));
    terminate = 1;

    client->join();
    std::cout << "client terminated\n";
    server->join();
    std::cout << "server terminated\n";

    std::cout << "Maximum transaction id: " << maxReceived << std::endl << std::endl;

    delete client;
    delete server;

    return 0;
}


void clientFunction()
{
    counter = 1;

    std::cout << "client ready\n";
    bar.count_down_and_wait();

    while (!terminate)
    {
        bool ans;
        int transactionReceived;

        ans = fifo1.offer(counter);
        if (ans)
            counter++;

        transactionReceived = fifo2.poll();
        if (transactionReceived != 0)
            maxReceived = transactionReceived;
    }
}

void serverFunction()
{
    maxReceived = 1;

    std::cout << "server ready\n";
    bar.count_down_and_wait();

    while (!terminate)
    {
        int received;

        received = fifo1.take();
        fifo2.put(received);
    }
}
