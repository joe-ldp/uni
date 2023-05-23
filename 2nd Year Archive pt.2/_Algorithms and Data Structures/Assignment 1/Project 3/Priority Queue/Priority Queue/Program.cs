using System;

namespace Priority_Queue
{
    class Program
    {
        static void Main(string[] args)
        {
            Node head = new Node("a", 1);
            Queue q = new Queue(head);
            q.AddNode("b", 1);
            q.AddNode("c", 1);
            q.AddNode("d", 1);
            q.AddNode("e", 1);
            q.AddNode("f", 2);
            q.AddNode("g", 1);
            q.AddNode("h", 2);
            q.AddNode("i", 4);
            q.AddNode("j", 1);
            q.AddNode("k", 2);
            q.AddNode("l", 6);
            q.AddNode("m", 3);
            q.DisplayQueue();

            q.RemoveNode("a");
            q.DisplayQueue();
            q.RemoveNode("l");
            q.DisplayQueue();
            q.RemoveNode("j");
            q.DisplayQueue();

            Console.WriteLine(q.FindPriority("i"));
        }
    }

    class Queue
    {
        private Node head;
        private int length;

        public Queue() { length = 0; }

        public Queue(Node head)
        {
            this.head = head;
            length = 1;
        }

        public Node GetLastNode() // navigate through the list until the next node is null (we are at the end) and return
        {
            Node n = head;
            while (head.Next != null) {
                n = n.Next;
            }
            return n;
        }

        public void AddNode(string description, int priority) {
            Node newNode = new Node(description, priority); // allocate new node
            if (priority > head.Priority) // if the new node has a higher priority than the head, this is the only case we overwrite the head
            {
                newNode.Next = head;
                head.Prev = newNode;
                head = newNode;
            }
            else
            {
                Node n = head;
                while (n.Next != null && priority <= n.Next.Priority) { // navigate to the last node of equal or less priority
                    n = n.Next;
                }
                if (n.Next == null) // if we are at the end of the linked list
                {
                    n.Next = newNode;
                    newNode.Prev = n;
                }
                else
                {
                    newNode.Next = n.Next;
                    newNode.Prev = n;
                    n.Next.Prev = newNode;
                    n.Next = newNode;
                }
            }
            
            length++;
        }

        public void RemoveNode(string description)
        {
            Node n = head;
            while (n.Description != description) {
                n = n.Next;
            }
            if (n.Prev == null) { // if we are at the head of the list, a special operation is required
                n.Next.Prev = null;
                head = n.Next;
            }
            else if (n.Next == null) { // if we are at the end of the list, a special operation is required
                n.Prev.Next = null;
            }
            else {
                n.Prev.Next = n.Next;
                n.Next.Prev = n.Prev;
            }
            length--;
        }

        public Node GetNextJob()
        {
            Node n = head;

            n.Next.Prev = null;
            head = n.Next;

            return n;
        }

        public int FindPriority(string description)
        {
            Node n = head;
            while (n.Description != description)
            {
                n = n.Next;
            }
            return n.Priority;
        }

        public void DisplayQueue()
        {
            Node n = head;
            for (int i = 0; i < length; i++)
            {
                Console.WriteLine("Node #{0}: Description {1} | Priority {2}", i, n.Description, n.Priority);
                n = n.Next;
            }
            Console.Write("\n");
        }
    }

    class Node
    {
        private string description;
        private int priority;
        private Node prev;
        private Node next;

        public Node() { }

        public Node(string description, int priority)
        {
            this.description = description;
            this.priority = priority;
        }

        public Node(string description, int priority, Node prev)
        {
            this.description = description;
            this.priority = priority;
            this.prev = prev;
        }

        public int Priority { get => priority; set => priority = value; }
        public string Description { get => description; set => description = value; }
        public Node Next { get => next; set => next = value; }
        public Node Prev { get => prev; set => prev = value; }
    }
}