public class Main
{
    public static void main(String[] args)
    {
        ADS2Tree tree = new ADS2Tree("A");

        ADS2TreeNode Node1 = new ADS2TreeNode("B");
        ADS2TreeNode Node2 = new ADS2TreeNode("C");
        ADS2TreeNode Node3 = new ADS2TreeNode("D");
        ADS2TreeNode Node4 = new ADS2TreeNode("E");

        tree.AddChild(tree.root, Node1);
        tree.AddChild(tree.root, Node2);
        tree.AddChild(Node1, Node3);
        tree.AddChild(Node2, Node4);

        tree.PrintTree_DFT();

        Node4.PrintValue();

        System.out.println("");

    }
}