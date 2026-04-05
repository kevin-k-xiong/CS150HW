public class pracs {
    public static void main(String[] args) {

        int[][] arr = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        int[] array = { 1, 2, 3, 4, 5 };

        for (int i = 0; i < array.length - 1; i++) {
            int first = array[i];
            array[i] = array[i++];
            System.out.println(array[i]);
        }

    }
}
