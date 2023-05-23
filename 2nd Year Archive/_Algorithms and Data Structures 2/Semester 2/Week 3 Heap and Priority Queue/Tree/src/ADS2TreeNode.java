public class ADS2TreeNode {
    private String data;
    public ADS2TreeNode Lchild;
    public ADS2TreeNode Rchild;


    ADS2TreeNode(){
        this.data = null;
        this.Lchild = null;
        this.Rchild = null;
    }

    ADS2TreeNode(String inputData){
        this.data = inputData;
        this.Lchild = null;
        this.Rchild = null;
    }

    ADS2TreeNode(String inputData, ADS2TreeNode ref1, ADS2TreeNode ref2, ADS2TreeNode ref3){
        this.data = inputData;
        this.Lchild = ref1;
        this.Rchild = ref2;
    }

    public String GetData(){
        return this.data;
    }

    public void PrintSubtree(){
        System.out.println(this.data);//Do something about this node
        if (this.Lchild!=null) this.Lchild.PrintSubtree();//Visit left child
        if (this.Rchild!=null) this.Rchild.PrintSubtree();//Visit right child
    }

    public ADS2TreeNode SearchNodes(String value) {
        ADS2TreeNode found = null;
        if(this.data.equals(value)) return this;
        else{
            if (this.Lchild!=null) found = this.Lchild.SearchNodes(value);
            if (found != null) return found;
            if (this.Rchild!=null) found = this.Rchild.SearchNodes(value);
            if (found != null) return found;
            return null;
        }

    }

    public int GetHeight_R() {
        if (this==null) return 0;

        int left=0, right=0;
        if (this.Lchild!=null) left = this.Lchild.GetHeight_R();
        if (this.Rchild!=null) right = this.Rchild.GetHeight_R();

        if (left>=right) return left+1;
        else return right+1;

    }
}
