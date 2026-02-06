public class IntSinglyLinkedList {

    // Reference to the head/starting node
    private Node head;
    private int size;

    public IntSinglyLinkedList() {
        head = null;
        size = 0;
    }

    /**
     * 
     * @param value
     */
    public void addFirst(int value) {
        // Create the first node
        Node newNode = new Node(value, head);
        head = newNode;
        size++;
    }

    public void addLast(int value) {
        // Create the next node
        Node nextNode = new Node(value, null);
        // If list is empty set the first element to head
        if (head == null || size == 0) {
            head = nextNode;
        } else {
            // Traverse through the list until we reach the last
            Node current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(nextNode);
        }
        size++;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Error Index out of bounds");
        }

        // Set current to head
        Node current = head;
        int counter = 0;

        while (counter < index) {
            current = current.getNext();
            counter++;
        }

        return current.getValue();

    }

    public int removeFirst() {

    }

    public boolean removeValue(int value) {

    }

    public int size() {

    }

    public boolean isEmpty() {

    }

    public String toString() {

    }
}
