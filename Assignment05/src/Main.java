public class Main {
    public static void main(String[] args) {
        System.out.println("Tasks 1, 2, and 6 are running");
        BST tree = new BST();
        tree.insert("U");
        tree.insert("W");
        tree.insert("E");
        tree.insert("A");
        tree.insert("U");
        tree.insert("C");
        tree.insert("L");
        tree.insert("A");
        tree.insert("I");
        tree.insert("R");
        tree.insert("E");
        System.out.println("==========");
        System.out.println("Task 3 output:");
        int height = tree.height();
        System.out.print("Tree Height: ");
        System.out.println(height);
        System.out.println("==========");
        System.out.println("Task 4 output:");
        tree.printDepthFirst();
        System.out.println("==========");
        System.out.println("Task 5 output:");
        tree.printBreadthFirst();
    }
}
