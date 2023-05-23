#include <thread>
#include <mutex>
#include <iostream>

#include "fifo - solution.hpp"
#include "barrier.hpp"

#define TIME_SECS 5

singleFifo <int,100> fifo;

barrier bar(3);
unsigned int terminate;
unsigned int counterPut;
unsigned int counterTake;

void producerFunction();
void consumerFunction();

int main ()
{
    std::thread *producer;
    std::thread *consumer;

    fifo.clear();

    terminate = 0;

    producer = new std::thread(producerFunction);
    consumer = new std::thread(consumerFunction);

    std::cout << "main ready\n";
    bar.count_down_and_wait();
    std::this_thread::sleep_for(std::chrono::seconds(TIME_SECS));
    terminate = 1;

    producer->join();
    std::cout << "producer terminated\n";
    consumer->join();
    std::cout << "consumer terminated\n";

    std::cout << "Number of put operations: " << counterPut << std::endl;
    std::cout << "Number of take operations: " << counterTake << std::endl << std::endl;

    delete producer;
    delete consumer;

    return 0;
}


void producerFunction()
{
    counterPut = 0;
    std::cout << "Producer ready\n";
    bar.count_down_and_wait();

    while (!terminate)
    {
        int value = 1;

        fifo.put(value);
        counterPut ++;
    }
}

void consumerFunction()
{
    counterTake = 0;

    std::cout << "Consumer ready\n";
    bar.count_down_and_wait();

    while (!terminate)
    {
        int received;

        received = fifo.take();
        counterTake ++;
    }
}

