public class ADS2Tree
{
    public ADS2TreeNode root;

    ADS2Tree()
    {
        root = new ADS2TreeNode();
    }

    ADS2Tree(String rootData)
    {
        root = new ADS2TreeNode(rootData);
    }

    public void AddChild(ADS2TreeNode parent, ADS2TreeNode newChild)
    {
        if (parent.child1 == null)
        {
            parent.child1 = newChild;
        }
        else if (parent.child2 == null)
        {
            parent.child2 = newChild;
        }
        else
        {
            return;
        }
    }

    public void PrintTree_DFT()
    {
        this.root.PrintSubtree();
    }

    public void PrintTree_BFT()
    {
        ADS2Queue treeQueue = new ADS2Queue();
        ADS2TreeNode tracker = this.root;

        while (tracker == this.root || !treeQueue.isEmpty())
        {
            System.out.println(tracker.data);
            if (tracker.child1 != null) treeQueue.Push(tracker.child1);
            if (tracker.child2 != null) treeQueue.Push(tracker.child2);

            tracker = treeQueue.Pop();
        }
        System.out.println(tracker.data);
    }

    public ADS2TreeNode Search(String searchForData)
    {
        return this.root.Search(searchForData);
    }
}