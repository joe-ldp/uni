using System;

namespace Queues
{
    class Program
    {
        static void Main(string[] args)
        {
            Queue q = new Queue();
            q.addQ(2);
            q.addQ(3);
            q.addQ(1);
            q.deleteQ(3);
        }
    }

    class Queue
    {
        private int front, rear;
        private int[] queue;
        private int n;

        public Queue()
        {
            queue = new int[50];
            n = 20;
            front = 0;
            rear = 0;
        }

        public void addQ(int item)
        {
            // insert item in the circular queue stored in QUEUE(0:n - 1);
            // rear points to the last item and front is one position
            // counterclockwise from the first item in QUEUE
            if (front == (rear+1) % n) queueFull();
            else
            {
                rear = (rear + 1) % n;
                queue[rear] = item;
            }
        }

        public int deleteQ(int item)
        {
            // removes the front element of the queue QUEUE(0:n - 1)
            if (front == rear) queueEmpty();
            else
            {
                front = (front + 1) % n;
                queue[front] = item;
            }
            return -1;
        }

        public int getFront()
        {
            if (isEmpty()) queueEmpty();
            else return queue[front];
            return -1;
        }

        public int getRear()
        {
            if (isEmpty()) queueEmpty();
            else return queue[rear];
            return -1;
        }

        private bool isEmpty()
        {
            return front == rear;
        }

        private bool isFull()
        {
            return rear == n;
        }

        private void queueFull()
        {
            Console.WriteLine("Queue is full!");
        }

        private void queueEmpty()
        {
            Console.WriteLine("Queue is empty!");
        }
    }
}
