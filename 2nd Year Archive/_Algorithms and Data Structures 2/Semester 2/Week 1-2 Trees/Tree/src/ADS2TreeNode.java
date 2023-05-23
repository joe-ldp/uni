public class ADS2TreeNode
{
    public String data;

    public ADS2TreeNode child1;
    public ADS2TreeNode child2;

    public ADS2TreeNode()
    {
        this.data = null;
        this.child1 = null;
        this.child2 = null;
    }

    public ADS2TreeNode(String data)
    {
        this.data = data;
        this.child1 = null;
        this.child2 = null;
    }

    public ADS2TreeNode(String data, ADS2TreeNode child1, ADS2TreeNode child2)
    {
        this.data = data;
        this.child1 = child1;
        this.child2 = child2;
    }

    public void PrintSubtree()
    {
        System.out.println(this.data);
        if (this.child1 != null) this.child1.PrintSubtree();
        if (this.child2 != null) this.child2.PrintSubtree();
    }

    public void PrintValue()
    {
        System.out.println(this.data);
    }

    public ADS2TreeNode Search(String data)
    {
        if (this.data == data) return this;
        else
        {
            if (this.child1 != null) this.child1.Search(data);
            if (this.child2 != null) this.child2.Search(data);
        }
        return null;
    }
}