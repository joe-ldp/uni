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
unsigned int terminate;
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

    terminate = 0;
    mailboxFull = 0;

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

    while (!terminate)
    {
        int received;

        received = poll(timeout);
        if (received != 0)
            counterTake ++;
    }
}


bool offer(int value, milliseconds_type timeout_ms) //timeout in msec
{
    // lock mailbox mutex
    std::unique_lock< std::mutex > lock(mailboxMutex);


    auto now = std::chrono::high_resolution_clock::now(); //take the current time
    auto futureTimeout = now + timeout_ms; //add the timeout to obtain the future timeout time


    // check if there is space in the queue or wait on condition variable until timeout
    // use wait_until to wait on a condition variable until a certain time
    // use wait_for to wait on a condition variable for a certain amount of time
    while (mailboxFull && std::chrono::high_resolution_clock::now() < futureTimeout)
        cvMailBox.wait_until(lock, futureTimeout);

    // if there is space in the mailbox, push the element, trigger pop threads, and return true
    if (!mailboxFull)
    {
        mailbox = value;
        mailboxFull = true;
        cvMailBox.notify_all();
        return true;
    }

    // if there is no space, trigger pop threads and return false
    cvMailBox.notify_all();
    return false;
}

int poll(milliseconds_type timeout_ms) //timeout in msec
{
    // Lock mailbox access
    std::unique_lock< std::mutex > lock(mailboxMutex);


    auto now = std::chrono::system_clock::now(); //take the current time
    auto futureTimeout = now + timeout_ms; //add the timeout to obtain the future timeout time


    int value;

    // check if there is something in the queue or wait on pop condition variable until timeout
    // use wait_until to wait on a condition variable until a certain time
    // use wait_for to wait on a condition variable for a certain amount of time
    while (!mailboxFull && std::chrono::high_resolution_clock::now() < futureTimeout)
        cvMailBox.wait_until(lock, futureTimeout);

    // check if there is something in the queue to pop
    // if yes, pop the element, trigger all push threads and return popped element
    if (mailboxFull)
    {
        value = mailbox;
        mailboxFull = false;
        cvMailBox.notify_all();
        return value;
    }

    // if not, trigger all push threads and return an empty object
    cvMailBox.notify_all();
    return int ();

}
