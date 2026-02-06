/**
 * @author Kevin XIong
 */

public class Assignment0 {

    public static void main(String[] args) {

        int[] arr = { 4, 4, 4, 1, 1, 2 };

        int[][] compressed = compressArr(arr);
        int[] decompressed = decompressRuns(compressed);

        printCompressed(compressed);
        printArray(decompressed);

        double[][] matrixA = {
                { 1, 2, 3 },
                { 4, 5, 6 }
        };

        double[][] matrixB = {
                { 7, 8 },
                { 9, 10 },
                { 11, 12 }
        };

        printMatrix(matrixA);
        printMatrix(matrixB);

        double[][] matrixC = matrixMultiply(matrixA, matrixB);
        printMatrix(matrixC);
    }

    /**
     * 
     * @param arr Original input array
     * @return he full array and compresses it
     */
    public static int[][] compressArr(int[] arr) {
        int nums = countRuns(arr);
        int[][] compressed = new int[nums][2];

        int index = 0;
        int count = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                count++;
            } else {
                storeRun(compressed, index++, arr[i - 1], count);
                count = 1;
            }
        }

        storeRun(compressed, index, arr[arr.length - 1], count);
        return compressed;
    }

    /**
     * 
     * @param arr Input array
     * @return the number of changed value
     */
    public static int countRuns(int[] arr) {
        int num = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                num++;
            }
        }
        return num;
    }

    /**
     * 
     * @param compressed the compressed array
     * @param index      the index to store the run
     * @param value      the value of the run
     * @param count      the number of occurrences
     */
    public static void storeRun(int[][] compressed, int index, int value, int count) {
        compressed[index][0] = value;
        compressed[index][1] = count;
    }

    /**
     * 
     * @param compressedArr the compressed array
     * @return the decompressed array
     */
    public static int[] decompressRuns(int[][] compressedArr) {
        int size = totalSize(compressedArr);
        int[] result = new int[size];

        int index = 0;
        for (int[] num : compressedArr) {
            for (int i = 0; i < num[1]; i++) {
                result[index++] = num[0];
            }
        }
        return result;
    }

    /**
     * 
     * @param compressedArr the compressed array
     * @return total number of elements after decompression
     */
    public static int totalSize(int[][] compressedArr) {
        int size = 0;
        for (int[] run : compressedArr) {
            size += run[1];
        }
        return size;
    }

    /**
     * 
     * @param arr the input array
     * @return an array of local maxima
     */
    public static int[] localMaxima(int[] arr) {
        int count = countLocalMaxima(arr);
        int[] result = new int[count];

        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (isLocalMax(arr, i)) {
                result[index++] = arr[i];
            }
        }
        return result;
    }

    /**
     * 
     * @param arr the input array
     * @return number of local maxima
     */
    public static int countLocalMaxima(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (isLocalMax(arr, i)) {
                count++;
            }
        }
        return count;
    }

    /**
     * 
     * @param arr the input array
     * @param i   the index to check
     * @return true if the element is a local maximum
     */
    public static boolean isLocalMax(int[] arr, int i) {
        if (i == 0) {
            return arr.length > 1 && arr[i] > arr[i + 1];
        } else if (i == arr.length - 1) {
            return arr[i] > arr[i - 1];
        }
        return arr[i] > arr[i - 1] && arr[i] > arr[i + 1];
    }

    /**
     * 
     * @param A the left matrix
     * @param B the right matrix
     * @return Returns matrix
     */
    public static double[][] matrixMultiply(double[][] A, double[][] B) {
        if (!canMultiply(A, B)) {
            throw new IllegalArgumentException("Invalid matrix dimensions");
        }

        double[][] result = new double[A.length][B[0].length];

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B[0].length; j++) {
                result[i][j] = multiplyCell(A, B, i, j);
            }
        }
        return result;
    }

    /**
     * 
     * @param A the left matrix
     * @param B the right matrix
     * @return true if multiplication is valid
     */
    public static boolean canMultiply(double[][] A, double[][] B) {
        return A[0].length == B.length;
    }

    /**
     * 
     * @param A   the left matrix
     * @param B   the right matrix
     * @param row the row index
     * @param col the column index
     * @return the computed cell value
     */
    public static double multiplyCell(double[][] A, double[][] B, int row, int col) {
        double sum = 0;
        for (int k = 0; k < A[0].length; k++) {
            sum += A[row][k] * B[k][col];
        }
        return sum;
    }

    /**
     * 
     * @param matrix the matrix to print
     */
    public static void printMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double value : row) {
                System.out.printf("%8.2f", value);
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * 
     * @param compressed the compressed array
     */
    public static void printCompressed(int[][] compressed) {
        for (int[] run : compressed) {
            System.out.println(run[0] + ", " + run[1]);
        }
    }

    /**
     * 
     * @param arr the array to print
     */
    public static void printArray(int[] arr) {
        for (int n : arr) {
            System.out.print(n + " ");
        }
        System.out.println();
    }
}