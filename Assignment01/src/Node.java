
public class Node {
    private int value;
    private Node next;

    /**
     * Creates a node with the given value and next reference.
     *
     * @param value the integer value stored in the node
     * @param next  reference to the next node (may be null)
     */
    public Node(int value, Node next) {
        this.value = value;

        // this.next is a reference to another node
        this.next = next;
    }

    /**
     * Returns the value stored in this node.
     *
     * @return the node's value
     */
    public int getValue() {
        return value;
    }

    /**
     * Updates the value stored in this node.
     *
     * @param value the new value to store
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * Returns the next node reference.
     *
     * @return the next node, or null if none
     */
    public Node getNext() {
        return next;
    }

    /**
     * Updates the next node reference.
     *
     * @param next the new next node (may be null)
     */
    public void setNext(Node next) {
        this.next = next;
    }

}
