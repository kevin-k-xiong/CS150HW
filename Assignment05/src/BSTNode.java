public class BSTNode {

    private int rightChild;
    private int leftChild;
    private String data;

    public BSTNode(String data) {
        this.data = data;
    }

    public int getRightChild() {
        return rightChild;
    }

    public void setRightChild(int rightChild) {
        this.rightChild = rightChild;
    }

    public int getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(int leftChild) {
        this.leftChild = leftChild;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int height() {
        if (this.getLeftChild() == null && this.getRightChild() == null) {
            return 1;
        }
        if (this.getLeftChild() == null) {
            return 1 + this.getRightChild().height() + 1;
        }
        if (this.getRightChild() == null) {
            return 1 + this.getLeftChild().height() + 1;
        }
        return Math.max(this.getLeftChild().height(), this.getRightChild().height()) + 1;
    }

    public void insert(BSTNode node) {
        // figure out if lef tor tight
        // if BStNode data is less than this.data, then go left, else go right
        // if left/right tempty put bst node there
        //

        // If there already exists a node there, then call exisitngNode.insert(bstNide)

    }

    public void printdepthFirstSearch() {
        System.out.println(this.getData());
        if (this.getLeftChild() != null) {
            this.getLeftChild().printdepthFirstSearch();
        }
        if (this.getRightChild() != null) {
            this.getRightChild().printdepthFirstSearch();
        }
    }
}
