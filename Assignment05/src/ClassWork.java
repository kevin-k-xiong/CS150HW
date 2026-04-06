import java.util.LinkedList;

public class ClassWork {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("mango");
        list.add("apple");
        list.add("pear");
        list.add("banana");

        BST tree = buildTree(list);
        tree.printDepthFirst();
    }

    public static BST buildTree(LinkedList<String> list) {
        BST tree = new BST();
        for (String value : list) {
            tree.insert(value);
        }
        return tree;
    }
}
