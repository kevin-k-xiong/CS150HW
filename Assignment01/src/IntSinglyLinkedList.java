import java.util.NoSuchElementException;

public class IntSinglyLinkedList {

    // Reference to the head/starting node
    private Node head;
    private int size;

    /**
     * Constructs an empty list.
     */
    public IntSinglyLinkedList() {
        head = null;
        size = 0;
    }

    /**
     * Inserts a value at the front of the list.
     *
     * @param value the value to add
     */
    public void addFirst(int value) {
        // Create the first node
        Node newNode = new Node(value, head);
        head = newNode;
        size++;
    }

    /**
     * Inserts a value at the end of the list.
     *
     * @param value the value to add
     */
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

    /**
     * Returns the value at the given index.
     *
     * @param index the position to read
     * @return the value at the index
     * @throws IndexOutOfBoundsException if index is out of range
     */
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Error: Index out of bounds.");
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

    /**
     * Removes and returns the first value in the list.
     *
     * @return the removed value
     * @throws NoSuchElementException if the list is empty
     */
    public int removeFirst() {
        if (head == null || size == 0) {
            throw new NoSuchElementException("Error: Element does not exist.");
        }
        int temp = head.getValue();
        head = head.getNext();
        size--;
        return temp;
    }

    /**
     * Removes the first node with the given value.
     *
     * @param value the value to remove
     * @return true if a node was removed, false otherwise
     */
    public boolean removeValue(int value) {
        if (head == null || size == 0) {
            return false;
        }

        // If value matches a value in list and its the first node then call removeFirst
        if (value == head.getValue()) {
            removeFirst();
            return true;
        }

        Node previous = head;
        Node current = head.getNext();

        while (current != null) {
            if (current.getValue() == value) {
                previous.setNext(current.getNext());
                size--;
                return true;
            }
            previous = current;
            current = current.getNext();

        }

        return false;
    }

    /**
     * Returns the number of elements in the list.
     *
     * @return the list size
     */
    public int size() {
        return size;
    }

    /**
     * Returns whether the list is empty.
     *
     * @return true if empty, false otherwise
     */
    public boolean isEmpty() {
        if (head == null || size == 0) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * Returns a string representation of the list.
     *
     * @return the list in the form [a,b,c]
     */
    public String toString() {
        StringBuilder sb = new StringBuilder("[");

        if (head == null || size == 0) {
            sb.append("]");
            return sb.toString();
        }

        Node current = head;

        while (current != null) {
            if (current != head) {
                sb.append(",");
            }
            sb.append(current.getValue());
            current = current.getNext();
        }

        sb.append("]");

        return sb.toString();
    }
}
