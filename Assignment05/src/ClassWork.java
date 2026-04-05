import java.util.LinkedList;

public class ClassWork {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        for (int i = 0; i < list.size(); i++) {
            BSTNode node = new BSTNode(list.get(i));
        }
    }

    public void listHelper(LinkedList<String> list) {

        if(this.getRightChild() != null){

        }

    }

    public void printdepthFirstSearch() {
        System.out.println(this.getData());
        if (this.getLeftChild() != null) {
            this.getLeftChild().printdepthFirstSearch();
        }
        if (this.getRightChild() != null) {
            this.getRightChild().printdepthFirstSearch();
        }
    }

}
