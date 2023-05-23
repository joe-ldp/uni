/**
 * This data structure represents a queue.
 * You should hold the underlying data using doubly linked list.
 * You need to build a QueueNode Class for the implementation
 * The data stored in the QueueNode Class is "Customer" type
 */

public class Queue
{
    //Define member variables of Queue class
    //You should define some trackers to locate the heads and tails of underlying doubly linked list.

    // Default Constructor
    public Queue()
    {

    }

    //Optional: Create some helper methods below for your implementation.


    /**
     * Adds value to the queue  (remember First-in, First-out).
     * You should renew your trackers inside this method
     * @param newCustomer the new customer join the queue
     */
    public void Push(Customer newCustomer)
    {

    }

    /**
     * Gets the next item from the queue (remember First-in, First-out)
     * or null if there are no more items.
     * You should renew your trackers inside this method
     * @return the virtual customer
     */
    public Customer Pop()
    {
        return null;
    }

    /**
     * @return the length of the Queue
     * if you used the dummy head, the length should reflect the real data's length.
     */
    public int LengthOfQueue()
    {
        return 0;
    }

    /**
     * Print all the queueing customer data one by one
     * You can use PrintInfo() method of Customer class
     */
    public void PrintQueue()
    {

    }
}
