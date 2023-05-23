#include <thread>
#include <mutex>
#include <iostream>

#include <mutex>
#include <condition_variable>
#include <chrono>

#include "barrier.hpp"

#define TIME_SECS 5

typedef std::chrono::duration<int,std::milli> milliseconds_type;

int mailbox;
bool mailboxFull;

milliseconds_type timeout(100);

std::mutex mailboxMutex;
std::condition_variable cvMailBox;

barrier bar(3);
unsigned int terminatee;
unsigned int counterPut;
unsigned int counterTake;

void producerFunction();
void consumerFunction();

bool offer(int value, milliseconds_type timeout_ms); //timeout in msec
int poll(milliseconds_type timeout_ms); //timeout in msec

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
        bool ans;

        ans = offer(value, timeout);
        if (ans)
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

        received = poll(timeout);
        if (received == 1)
            counterTake ++;
    }
}

bool offer(int value, milliseconds_type timeout_ms) //timeout in msec
{
    std::unique_lock<std::mutex> lock(mailboxMutex);
    std::chrono::time_point<std::chrono::high_resolution_clock> timeout = std::chrono::high_resolution_clock::now() + timeout_ms;

    while (mailboxFull && std::chrono::high_resolution_clock::now() < timeout) {
        cvMailBox.wait_until(lock, timeout);
    }

    if (!mailboxFull) {
        mailbox = value;
        mailboxFull = true;
        cvMailBox.notify_all();
        return true;
    }

    cvMailBox.notify_all();
    return false;
}

int poll(milliseconds_type timeout_ms) //timeout in msec
{
    int value = 0;
    std::unique_lock<std::mutex> lock(mailboxMutex);
    std::chrono::time_point<std::chrono::high_resolution_clock> timeout = std::chrono::high_resolution_clock::now() + timeout_ms;

    while (!mailboxFull && std::chrono::high_resolution_clock::now() < timeout) {
        cvMailBox.wait_until(lock, timeout);
    }

    if (mailboxFull) {
        value = mailbox;
        mailboxFull = false;
        cvMailBox.notify_all();
        return value;
    }

    cvMailBox.notify_all();
    return int();
}
