public class Test {
    public static void main(String[] args) {
        int[] arr = { 4, 4, 4, 1, 1, 2 };

        int num = 1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                num++;
            } else {
                num = 1;
            }
        }
    }
}
