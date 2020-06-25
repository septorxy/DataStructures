import SortResources.*;

public class Q1andQ2 {

    private static int[] merge(int[] A, int[] B) {
        int[] finalArray = new int[256];
        int j = 0, k = 0;
        for (int i = 0; i < 256; i++) {
            if (j <= A.length - 1 && A[j] <= B[k]) {
                finalArray[i] = A[j];
                j++;
            } else if (k != B.length - 1 || j == A.length) {
                finalArray[i] = B[k];
                k++;
            }
        }
        return finalArray;
    }

    private static void shell(int[] ToSort) {
        //Explanation for shell sort was taken from https://www.geeksforgeeks.org/shellsort/
        int j;
        int temp;
        for (int g = ToSort.length / 2; g > 0; g /= 2) {
            for (int i = g; i < ToSort.length; i++) {
                temp = ToSort[i];
                for (j = i; j >= g && ToSort[j - g] > temp; j -= g)
                    ToSort[j] = ToSort[j - g];
                ToSort[j] = temp;
            }
        }
    }

    private static void generateArray(int[] Array) {
        for (int i = 0; i != Array.length; i++) {
            Array[i] = (int) (Math.random() * (1024));
        }
        displayArray(Array);
    }

    private static void displayArray(int[] Array) {
        for (int i = 0; i != Array.length; i++) {
            if (i != (Array.length - 1)) {
                System.out.print(Array[i] + ", ");
            } else {
                System.out.print(Array[i] + "\n");
            }
        }
    }

    public static void main(String[] args) {
        //Declaration
        int[] A = new int[106];
        int[] B = new int[150];
        //Initialisation
        System.out.println("Unsorted Arrays:");
        System.out.print("A: ");
        generateArray(A);
        System.out.print("B: ");
        generateArray(B);

        //Shell Sort in Main
        System.out.println("Shell Sorted Array A: ");
        shell(A);
        displayArray(A);

        //Quick Sort in Main
        System.out.println("Quick Sorted Array B:");
        QuickSort.quickS(B, 0, B.length - 1);
        displayArray(B);
        //Question 2
        System.out.println("The merged arrays make: ");
        int[] C = merge(A, B);
        displayArray(C);
    }
}