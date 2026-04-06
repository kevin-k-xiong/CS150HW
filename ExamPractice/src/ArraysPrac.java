public class ArraysPrac {
    public static void main(String[] args) {
        int[] arr = { 2, 3, 8, 5, 6, 3 };
        // System.out.println(getSum(arr));
        // System.out.println(getMax(arr));
        System.out.println(getEvenNum(arr));
    }

    public static int getSum(int[] i) {
        int sum = 0;
        for (int k = 0; k < i.length; k++) {
            sum += i[k];
        }
        return sum;
    }

    public static int getMax(int[] i) {
        int max = 0;
        for (int k = 0; k < i.length; k++) {
            if (max < i[k]) {
                max = i[k];
            }
        }
        return max;
    }

    public static int getEvenNum(int[] i) {
        int count = 0;
        for (int k = 0; k < i.length; k++) {
            if (i[k] % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    // int[] arr = { 2, 3, 8, 5, 6, 3 };
    public static int reverseArr(int[] i) {
        int temp = 0; // stores the value
        int last = i[i.length];
        for (int k = 0; k < i.length; k++) {
            temp = i[k];
        }
    }

}
