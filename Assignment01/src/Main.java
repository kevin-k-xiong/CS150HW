/**
 * @author K.Xiong
 */
public class Main {
    /**
     * Runs the demo showing basic list operations.
     *
     * @param args
     */
    public static void main(String[] args) {
        IntSinglyLinkedList linkList = new IntSinglyLinkedList();

        addValues(linkList);
        getSize(linkList);
        removeValues(linkList);
        checkEmpty(linkList);

    }

    /**
     * Prints the list contents and its size on one line.
     *
     * @param linkList the list to displ ay
     */
    public static void printHelper(IntSinglyLinkedList linkList) {
        System.out.println(linkList + " size: " + linkList.size());
    }

    /**
     * Adds a few sample values and prints the list.
     *
     * @param linkList the list to modify
     */
    public static void addValues(IntSinglyLinkedList linkList) {
        System.out.println("----Adding Values----");
        linkList.addFirst(24);
        linkList.addFirst(236);
        linkList.addLast(5);
        printHelper(linkList);
    }

    /**
     * Demonstrates reading values from the list.
     *
     * @param linkList the list to read from
     */
    public static void getSize(IntSinglyLinkedList linkList) {
        System.out.println("----Getting Values----");
        System.out.println(linkList.get(1));
        System.out.println(linkList.get(linkList.size() - 1));
    }

    /**
     * Demonstrates removing a value and prints the list.
     *
     * @param linkList the list to modify
     */
    public static void removeValues(IntSinglyLinkedList linkList) {
        System.out.println("----Removing Values----");
        linkList.removeFirst();
        printHelper(linkList);
    }

    /**
     * Prints whether the list is empty.
     *
     * @param linkList the list to check
     */
    public static void checkEmpty(IntSinglyLinkedList linkList) {
        System.out.println("----Is Empty----");
        System.out.println(linkList.isEmpty());
    }

}
