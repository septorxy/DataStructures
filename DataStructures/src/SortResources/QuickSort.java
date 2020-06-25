package SortResources;
public class QuickSort {
    private static int partition(int[] Array, int left, int right) {
        //Explanation for quick sort was taken from http://www.algolist.net/Algorithms/Sorting/Quicksort
        int pivot = Array[(left + right) / 2];
        int i = left, j = right;
        while (i <= j) {
            while (Array[i] < pivot) {
                i++;
            }
            while (Array[j] > pivot) {
                j--;
            }
            if (i <= j) {
                swap(Array, i, j);
                i++;
                j--;
            }
        }
        return i;
    }

    public static void quickS(int[] ToSort, int left, int right) {
        int index = partition(ToSort, left, right);
        if (left < index - 1) {
            quickS(ToSort, left, index - 1);
        }
        if (right > index) {
            quickS(ToSort, index, right);
        }
    }

    public static void swap(int[] Array, int A, int B) {
        int temp = Array[A];
        Array[A] = Array[B];
        Array[B] = temp;
    }
}