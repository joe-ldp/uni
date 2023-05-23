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
        // lock push mutex

        // check condition on size, including condition variable for pushing

        // push data in fifo

        // notify condition variable for popping
    }

    bool offer(value_type obj, long unsigned int timeout = 0) //timeout in msec
    {
        // lock push mutex

        auto now = std::chrono::high_resolution_clock::now(); //take the current time
        milliseconds_type timeout_ms(timeout);
        auto futureTimeout = now + timeout_ms; //add the timeout to obtain the future timeout time


        // check if there is space in the queue or wait on push condition variable until timeout
        // use wait_until to wait on a condition variable until a certain time
        // use wait_for to wait on a condition variable for a certain amount of time

        // if there is space in the queue, push the element, trigger pop threads, and return true

        // if there is no space, trigger pop threads and return false

        return false;
    }

    bool add(value_type obj)
    {
        // lock push mutex

        // add element to fifo (in case the queue is fulle, it will throw an error)

        // notify all threads waiting on condition variable for popping

        return true;
    }

    value_type take()
    {
        value_type val;

        // Lock access for popping

        // Check if there are elements to pop and wait on condition variable popAccess

        // Take elements from back of the queue

        // Pop value from fifo

        // Notify all push threads, in case queue was full

        return val;
    }

    value_type poll (unsigned long int timeout = 0)
    {
        // Lock access for popping

        auto now = std::chrono::system_clock::now(); //take the current time
        milliseconds_type timeout_ms(timeout);
        auto futureTimeout = now + timeout_ms; //add the timeout to obtain the future timeout time

        value_type val;

        // check if there is something in the queue or wait on pop condition variable until timeout
        // use wait_until to wait on a condition variable until a certain time
        // use wait_for to wait on a condition variable for a certain amount of time

        // check if there is something in the queue to pop

        // if not, trigger all push threads and return an empty object

        // if yes, pop the element, trigger all push threads and return popped element
    }

    value_type remove ()
    {
        value_type val;

        // check if there is something to pop from the queue, otherwise throw an error

        // if there is something to pop

        // remove it from the queue

        // notify all the push threads

        // return popped value
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
