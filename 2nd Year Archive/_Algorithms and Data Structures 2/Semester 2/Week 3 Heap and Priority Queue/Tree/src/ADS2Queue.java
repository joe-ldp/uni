public class ADS2Queue {
    ADS2QueueNode head, tail;

    ADS2Queue(){
        head = new ADS2QueueNode();
        tail = head;
    }

    public boolean IsEmpty(){
        return head.data==null;
    }

    public void Push(ADS2TreeNode data){
        if (this.IsEmpty()){
            head.data = data;
        }
        else{
            tail.nextNode = new ADS2QueueNode(data,tail,null);
            tail = tail.nextNode;
        }
    }

    public ADS2TreeNode Pop(){
        ADS2TreeNode poppedData = head.data;

        if (head.nextNode != null) {
            head = head.nextNode;
            head.prevNode = null;
        }
        else head.data = null;

        return poppedData;
    }
}
