public class BSTNode {

    private BSTNode rightChild;
    private BSTNode leftChild;
    private String data;

    /**
     * Creates a node that stores the given string.
     *
     * @param data the string stored in the node
     */
    public BSTNode(String data) {
        this.data = data;
    }

    /**
     *
     * @return the right child
     */
    public BSTNode getRightChild() {
        return rightChild;
    }

    /**
     * Sets the right child of this node.
     *
     * @param rightChild the node to store as the right child
     */
    public void setRightChild(BSTNode rightChild) {
        this.rightChild = rightChild;
    }

    /**
     *
     * @return the left child
     */
    public BSTNode getLeftChild() {
        return leftChild;
    }

    /**
     * Sets the left child of this node.
     *
     * @param leftChild the node to store as the left child
     */
    public void setLeftChild(BSTNode leftChild) {
        this.leftChild = leftChild;
    }

    /**
     *
     * @return the node data
     */
    public String getData() {
        return data;
    }

    /**
     * Updates the string stored in this node.
     *
     * @param data the new string value
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     *
     * @return the subtree height
     */
    public int height() {
        int leftHeight = (leftChild == null) ? 0 : leftChild.height();
        int rightHeight = (rightChild == null) ? 0 : rightChild.height();
        return Math.max(leftHeight, rightHeight) + 1;
    }

    /**
     * Inserts a string into the subtree at this node.
     *
     * @param s the string to insert
     */
    public void insert(String s) {
        if (s.compareTo(data) < 0) {
            if (leftChild == null) {
                leftChild = new BSTNode(s);
            } else {
                leftChild.insert(s);
            }
        } else {
            if (rightChild == null) {
                rightChild = new BSTNode(s);
            } else {
                rightChild.insert(s);
            }
        }
    }

    /**
     * Prints the subtree at this node in depth-first order.
     */
    public void printDepthFirstSearch() {
        System.out.println(data);
        if (leftChild != null) {
            leftChild.printDepthFirstSearch();
        }
        if (rightChild != null) {
            rightChild.printDepthFirstSearch();
        }
    }
}
