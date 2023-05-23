public class ADS2QueueNode {
    public ADS2TreeNode data;
    public ADS2QueueNode prevNode;
    public ADS2QueueNode nextNode;

    ADS2QueueNode(){
        data = null;
        prevNode = null;
        nextNode = null;
    }

    ADS2QueueNode(ADS2TreeNode data){
        this.data = data;
        prevNode = null;
        nextNode = null;
    }

    ADS2QueueNode(ADS2TreeNode data, ADS2QueueNode prev, ADS2QueueNode next){
        this.data = data;
        prevNode = prev;
        nextNode = next;
    }
}
