#ifndef __FIFO_HPP
#define __FIFO_HPP

#include "LimitedDeque.hpp"

template <class T, std::size_t MaxSize = 10>
class singleFifo
{
private:
    typedef std::chrono::duration<int,std::milli> milliseconds_type;
    LimitedDeque<T, MaxSize> fifo1;
    std::mutex queueAccess;
    std::condition_variable cvPush;
    std::condition_variable cvPop;

public:
    typedef T value_type;
    typedef std::size_t size_type;

    singleFifo() : fifo1(), queueAccess(), cvPush(), cvPop() { }
    ~singleFifo() { }

    void clear()
    {
        fifo1.clear();
    }

    void put(value_type obj)
    {
        std::unique_lock< std::mutex > lock(queueAccess);

        while (fifo1.size() + 1 > MaxSize)
            cvPush.wait(lock);

        fifo1.push_back(obj);
        cvPop.notify_all();
    }

    bool offer(value_type obj, long unsigned int timeout = 0) //timeout in msec
    {
        std::unique_lock< std::mutex > lock(queueAccess);

        auto now = std::chrono::high_resolution_clock::now(); //take the current time
        milliseconds_type timeout_ms(timeout);
        auto futureTimeout = now + timeout_ms; //add the timeout to obtain the future timeout time

        while (fifo1.size() + 1 > MaxSize && std::chrono::high_resolution_clock::now() < futureTimeout)
            cvPush.wait_until(lock, futureTimeout);  //wait until timeout

        if (fifo1.size() + 1 > MaxSize) //if queue is still full, return false to indicate that the operation was not completed successfully
        {
            cvPop.notify_all(); //make sure that the consumer is awake
            return false;
        }

        fifo1.push_back(obj); //otherwise push the new value
        cvPop.notify_all(); //and notify consumer threads that there is a new value in the queue
        return true;
    }

    bool add(value_type obj)
    {
        std::unique_lock< std::mutex > lock(queueAccess);
        fifo1.push_back(obj);
        cvPop.notify_all();
        return true;
    }

    value_type take()
    {
        value_type val;

        std::unique_lock< std::mutex > lock(queueAccess);

        while (fifo1.size() == 0)
            cvPop.wait(lock);

        val = fifo1.front();
        fifo1.pop_front();
        cvPush.notify_all();
        return val;
    }

    value_type poll (unsigned long int timeout = 0)
    {
        value_type val;

        std::unique_lock< std::mutex > lock(queueAccess);

        auto now = std::chrono::system_clock::now(); //take the current time
        milliseconds_type timeout_ms(timeout);
        auto futureTimeout = now + timeout_ms; //add the timeout to obtain the future timeout time

        while (fifo1.size() == 0 && futureTimeout > std::chrono::system_clock::now())
            cvPop.wait_until(lock, futureTimeout); //wait until timeout

        if (fifo1.size() == 0) //if queue is still empty, return false to indicate that the operation was not completed successfully
        {
            cvPush.notify_all(); //make sure the producer is awake
            return value_type();
        }

        val = fifo1.front(); //otherwise pop the last value
        fifo1.pop_front();
        cvPush.notify_all(); //and notify consumer threads that there is a new value in the queue
        return val;
    }

    value_type remove ()
    {
        value_type val;

        if (fifo1.size() > 0)
        {
            val = fifo1.front();
            fifo1.pop_front();
            cvPush.notify_all();
            return val;
        }
        else
        {
            std::runtime_error re("Unable to remove item from empty FIFO");
            throw re;
        }
    }

    bool isSpaceAvailable()
    {
        return (fifo1.size() >= MaxSize);
    }

    bool isDataAvailable()
    {
        return (fifo1.size() > 0);
    }

};

#endif // __FIFO_HPP
