import java.util.LinkedList;

public class BST {

    private BSTNode root;

    /**
     *
     * @param s the string to insert
     */
    public void insert(String s) {
        if (root == null) {
            root = new BSTNode(s);
        } else {
            root.insert(s);
        }
    }

    /**
     * .
     *
     * @return the height of the tree
     */
    public int height() {
        return height(root);
    }

    /**
     *
     * @param root the subtree root
     * @return the height of the subtree
     */
    private int height(BSTNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = height(root.getLeftChild());
        int rightHeight = height(root.getRightChild());
        return Math.max(leftHeight, rightHeight) + 1;
    }

    /**
     * Prints the tree in depth-first order on one line.
     */
    public void printDepthFirst() {
        StringBuilder depthOutput = new StringBuilder();
        printDepthHelper(root, depthOutput);
        System.out.println(depthOutput.toString().trim());
    }

    /**
     *
     * @param root   the subtree root
     * @param output the traversal output being built
     */
    private void printDepthHelper(BSTNode root, StringBuilder depthOutput) {
        if (root == null) {
            return;
        }

        depthOutput.append(root.getData()).append(" ");
        printDepthHelper(root.getLeftChild(), depthOutput);
        printDepthHelper(root.getRightChild(), depthOutput);
    }

    /**
     * Prints the tree in breadth-first order on one line.
     */
    public void printBreadthFirst() {
        if (root == null) {
            System.out.println();
            return;
        }

        LinkedList<BSTNode> list = new LinkedList<>();
        StringBuilder breadthOutput = new StringBuilder();
        list.add(root);

        while (!list.isEmpty()) {
            BSTNode current = list.removeFirst();
            breadthOutput.append(current.getData()).append(" ");

            if (current.getLeftChild() != null) {
                list.add(current.getLeftChild());
            }
            if (current.getRightChild() != null) {
                list.add(current.getRightChild());
            }
        }

        System.out.println(breadthOutput.toString().trim());
    }
}
