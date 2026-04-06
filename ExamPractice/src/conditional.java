public class conditional {

    public static void main(String[] args) {
        // System.out.println(isPositive(0));
        // System.out.println(isDivisible(3));

    }

    public static boolean isPositive(int i) {
        if (i > 0) {
            return true;
        } else if (i < 0) {
            return false;
        } else if (i == 0) {
            return false;
        } else {
        }
        ;
        return false;
    }

    public static boolean isDivisible(int i) {

        if (i % 3 == 0 && i % 5 == 0) {
            return true;
        } else {
            return false;
        }
    }
}
