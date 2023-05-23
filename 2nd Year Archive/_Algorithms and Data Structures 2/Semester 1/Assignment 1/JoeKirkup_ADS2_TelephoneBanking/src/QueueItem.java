public class QueueItem
{
    private Customer cust;
    private QueueItem nextQueueItem;

    public QueueItem(Customer cust)
    {
        this.cust = cust;
        this.nextQueueItem = null;
    }

    public Customer GetCust()
    {
        return this.cust;
    }

    public QueueItem GetNext()
    {
        return this.nextQueueItem;
    }

    public void Add(Customer cust)
    {
        this.nextQueueItem = new QueueItem(cust);
    }

    public void SetNext(QueueItem next)
    {
        this.nextQueueItem = next;
    }
}