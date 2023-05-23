public class Main{
    public static void main(String[] args) {
        ADS2Tree myTree = new ADS2Tree("A");
        System.out.println();

        ADS2TreeNode node1 = new ADS2TreeNode("B");
        ADS2TreeNode node2 = new ADS2TreeNode("C");
        ADS2TreeNode node3 = new ADS2TreeNode("D");
        ADS2TreeNode node4 = new ADS2TreeNode("E");
        ADS2TreeNode node5 = new ADS2TreeNode("F");

        myTree.AddChild(myTree.root, node1);
        myTree.AddChild(myTree.root, node2);
        myTree.AddChild(node1, node3);
        myTree.AddChild(node1, node5);
        myTree.AddChild(node2, node4);

        //myTree.PrintAll_DFT();
        //myTree.PrintAll_BFT();

        //ADS2TreeNode node = myTree.Search_DFS("E");
        //if (node != null)
        //    System.out.println("Found the node: "+node.GetData());
        //else
        //    System.out.println("The node is not in the tree");

        System.out.println("Height of the tree is: "+myTree.GetHeight());

    }
}
