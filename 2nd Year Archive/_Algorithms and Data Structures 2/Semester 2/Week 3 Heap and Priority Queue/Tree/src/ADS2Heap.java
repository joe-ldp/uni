public class ADS2Heap {
    private String[] heapArray;

    ADS2Heap(){
        this.heapArray = new String[1];
    }

    //This constructor will be equivalent to Tree2Heap
    ADS2Heap(ADS2Tree tree){
        this.heapArray = new String[this.GetHeapCapacity(tree)];
    }

    //Get current tree's (linked list version) capacity
    private int GetHeapCapacity(ADS2Tree tree){
        //Optional: Check if the tree is a max/min heap

        return 0;
    }

    //A Heap Grow function which increase the capacity based on the height of the tree
    private void Grow(){

    }

    //Heap Insert
    public void Push(String HeapNode){

    }

    //Heap root removal
    public String Pop(){
        return null;
    }

}
