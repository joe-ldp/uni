public class ADS2Tree {
    public ADS2TreeNode root;

    ADS2Tree(String rootData){
        this.root = new ADS2TreeNode(rootData);
    }

    public void AddChild(ADS2TreeNode parent,ADS2TreeNode newChild){
        if (parent.Lchild==null){
            parent.Lchild=newChild;
        }
        else if (parent.Rchild==null){
            parent.Rchild=newChild;
        }
        else{
            System.err.println("The maximum children number is 2");
        }

    }

    public void PrintAll_DFT(){
        root.PrintSubtree();
    }

    public void PrintAll_BFT(){
        //Create an empty queue
        ADS2Queue treeQueue = new ADS2Queue();

        //create a tracker and the first location is the root
        ADS2TreeNode tracker = root;

        //while the queue is not empty
        while (tracker==root || !treeQueue.IsEmpty()) {
            //Do something about the tracker
            System.out.println(tracker.GetData());
            //Push all the children of the tracker to the queue
            if (tracker.Lchild!=null) treeQueue.Push(tracker.Lchild);
            if (tracker.Rchild!=null) treeQueue.Push(tracker.Rchild);
            //Pop just ONE child from the queue and update the tracker
            tracker = treeQueue.Pop();
        }
        System.out.println(tracker.GetData());
    }

    public ADS2TreeNode Search_BFS(String value){
        ADS2Queue treeQueue = new ADS2Queue();
        ADS2TreeNode tracker = root;

        while (tracker==root || !treeQueue.IsEmpty()) {
            if (tracker.GetData().equals(value)) return tracker;

            if (tracker.Lchild!=null) treeQueue.Push(tracker.Lchild);
            if (tracker.Rchild!=null) treeQueue.Push(tracker.Rchild);
            tracker = treeQueue.Pop();
        }
        if (tracker.GetData().equals(value)) return tracker;
        else return null;
    }

    public ADS2TreeNode Search_DFS(String value){
        return root.SearchNodes(value);
    }

    public int GetHeight(){
        return root.GetHeight_R();
    }

}
