#include <thread>
#include <mutex>
#include <iostream>

#include <mutex>
#include <condition_variable>

#include "barrier.hpp"

#define TIME_SECS 5

int mailbox;
bool mailboxFull;

std::mutex mailboxMutex;
std::condition_variable cvMailBox;

barrier bar(3);
unsigned int terminatee;
unsigned int counterPut;
unsigned int counterTake;

void producerFunction();
void consumerFunction();

void put(int value);
int take();

int main ()
{
    std::thread *producer;
    std::thread *consumer;

    terminatee = 0;
    mailboxFull = 0;

    producer = new std::thread(producerFunction);
    consumer = new std::thread(consumerFunction);

    std::cout << "main ready\n";
    bar.count_down_and_wait();
    std::this_thread::sleep_for(std::chrono::seconds(TIME_SECS));
    terminatee = 1;

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

    while (!terminatee)
    {
        int value = 1;

        put(value);
        counterPut ++;
    }
}

void consumerFunction()
{
    counterTake = 0;

    std::cout << "Consumer ready\n";
    bar.count_down_and_wait();

    while (!terminatee)
    {
        int received;

        received = take();
        counterTake ++;
    }
}


void put(int value)
{
    // Lock mutex
    std::unique_lock<std::mutex> lock(mailboxMutex);

    // Check condition on mailbox busy, including condition variable on mutex
    while (mailboxFull)
        cvMailBox.wait(lock);

    // Push data in mailbox and signal that the mailbox is busy
    mailbox = value;
    mailboxFull = true;

    // Notify condition variable
    cvMailBox.notify_all();
}

int take()
{
    int value;

    // Lock mutex for popping
    std::unique_lock<std::mutex> lock(mailboxMutex);

    // Check if mailbox is busy and wait on condition variable cvMailBox
    while(!mailboxFull)
        cvMailBox.wait(lock);

    // Take elements from mailbox and signal that the mailbox is empty
    value = mailbox;
    mailboxFull = false;

    // Notify condition variable for pushing
    cvMailBox.notify_all();

    return value;
}
