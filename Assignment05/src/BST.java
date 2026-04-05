public class BST {

    private BSTNode root;

    public void insert(String s) {
        if (this.root == null) {
            this.root = new BSTNode(s);
        } else {
            this.root.insert(this.root, s);
        }
    }

    public int height() {
        if (root == null) {
            return 0;
        } else {
            return heightHelper(root);
        }
    }
}