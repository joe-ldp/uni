public class ADS2Queue
{
    private ADS2QueueNode head;

    public ADS2Queue()
    {
        this.head = null;
    }

    public ADS2Queue(ADS2QueueNode first)
    {
        this.head = first;
    }

    public void Push(ADS2QueueNode node)
    {
        if (this.head == null) this.head = node;

        ADS2QueueNode temp = this.head;
        {
            temp = temp.GetNext();
        }
        temp.Add(node);
    }

    public ADS2QueueNode Pop()
    {
        ADS2QueueNode temp = this.head;
        this.head = this.head.GetNext();
        return temp;
    }

    public void Remove(String custIDToRemove)
    {
        ADS2QueueNode temp = this.head;

        while (temp.GetNext() != null)
        {
            if (temp.GetNext().getData().equals(custIDToRemove))
            {
                temp.SetNext(temp.GetNext().GetNext());
                break;
            }
            temp = temp.GetNext();
        }
    }

    public boolean isEmpty()
    {
        if (this.head == null) return true;
        else return false;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("\nCurrently queued nodes:\n");
        ADS2QueueNode temp = this.head;

        while (temp != null)
        {
            sb.append(temp.toString());
            sb.append("\n");
            temp = temp.GetNext();
        }
        return sb.toString();
    }
}