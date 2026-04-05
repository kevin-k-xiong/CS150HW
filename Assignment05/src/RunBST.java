public class RunBST {
    public static void main(String[] args) {
        BSTNode one = new BSTNode("1");
        BSTNode two = new BSTNode("2");
        BSTNode three = new BSTNode("3");
        BSTNode four = new BSTNode("4");
        BSTNode five = new BSTNode("5");
        BSTNode six = new BSTNode("6");
        BSTNode seven = new BSTNode("7");

        one.setLeftChild(two);
        one.setRightChild(three);
        two.setLeftChild(four);
        two.setRightChild(five);
        three.setRightChild(six);
        three.setLeftChild(seven);

    }
}
