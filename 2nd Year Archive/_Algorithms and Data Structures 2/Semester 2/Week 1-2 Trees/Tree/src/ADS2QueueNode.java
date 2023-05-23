public class ADS2QueueNode
{
    private ADS2QueueNode nextQueueItem;
    private String data;

    public ADS2QueueNode()
    {
        this.nextQueueItem = null;
    }

    public ADS2QueueNode(String data)
    {
        this.nextQueueItem = null;
        this.data = data;
    }

    public ADS2QueueNode GetNext()
    {
        return this.nextQueueItem;
    }

    public void Add(ADS2QueueNode node)
    {
        this.nextQueueItem = node;
    }

    public void SetNext(ADS2QueueNode next)
    {
        this.nextQueueItem = next;
    }

    public String getData()
    {
        return this.data;
    }

    @Override
    public String toString()
    {
        return this.data;
    }
}