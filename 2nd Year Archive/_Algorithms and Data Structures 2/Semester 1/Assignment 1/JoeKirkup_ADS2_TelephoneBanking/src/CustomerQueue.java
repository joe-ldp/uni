public class CustomerQueue
{
    private QueueItem head;

    public CustomerQueue()
    {

    }

    public CustomerQueue(Customer firstCust)
    {
        Push(firstCust);
    }

    public void Push(Customer newCust)
    {
        if (this.head == null) this.head = new QueueItem(newCust);

        QueueItem temp = this.head;
        while (temp.GetNext() != null)
        {
            temp = temp.GetNext();
        }
        temp.Add(newCust);
    }

    public QueueItem Pop()
    {
        QueueItem temp = this.head;
        this.head = this.head.GetNext();
        return temp;
    }

    public void Remove(String custIDToRemove)
    {
        QueueItem temp = this.head;

        while (temp.GetNext() != null)
        {
            if (temp.GetNext().GetCust().getID().equals(custIDToRemove))
            {
                temp.SetNext(temp.GetNext().GetNext());
                break;
            }
            temp = temp.GetNext();
        }
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("\nCurrently queued customers:\n");
        QueueItem temp = this.head;

        while (temp != null)
        {
            sb.append(temp.GetCust().toString());
            sb.append("\n");
            temp = temp.GetNext();
        }
        return sb.toString();
    }

    boolean validID(String id)
    {
        // check all existing IDs for dupes
        QueueItem temp = this.head;
        while (temp.GetNext() != null)
        {
            if (temp.GetCust().getID() == id) return false;
        }

        return true;
    }
}