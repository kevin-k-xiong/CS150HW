public class Main {
    public static void main(String[] args) {
        IntSinglyLinkedList linkList = new IntSinglyLinkedList();

        addValues(linkList);
        getSize(linkList);
        removeValues(linkList);
        checkEmpty(linkList);

    }

    public static void printHelper(IntSinglyLinkedList linkList) {
        System.out.println(linkList + " size: " + linkList.size());
    }

    public static void addValues(IntSinglyLinkedList linkList) {
        System.out.println("----Adding Values----");
        linkList.addFirst(24);
        linkList.addFirst(236);
        linkList.addLast(5);
        printHelper(linkList);
    }

    public static void getSize(IntSinglyLinkedList linkList) {
        System.out.println("----Getting Values----");
        System.out.println(linkList.get(1));
        System.out.println(linkList.get(linkList.size() - 1));
    }

    public static void removeValues(IntSinglyLinkedList linkList) {
        System.out.println("----Removing Values----");
        linkList.removeFirst();
        printHelper(linkList);
    }

    public static void checkEmpty(IntSinglyLinkedList linkList) {
        System.out.println("----Is Empty----");
        System.out.println(linkList.isEmpty());
    }

}
