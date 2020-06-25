import SortResources.QuickSort;

public class Q9 {
    public static void main(String[] args) {
        //Declaration & Initialisation
        int[] Array = new int[50];
        int prev = -1;
        boolean found = false;
        //Populate Array
        System.out.println("Original Array");
        for (int i = 0; i < 50; i++) {
            Array[i] = (int) (Math.random() * (100));
            System.out.print(Array[i] + " ");
        }
        //Sort Array
        QuickSort.quickS(Array, 0, Array.length - 1);
        System.out.println("\nSorted Array:");
        for (int i = 0; i < 50; i++) {
            System.out.print(Array[i] + " ");
        }
        //Find all repetitions and set all non-repetitions to -1
        for (int i = 1; i < Array.length + 1; i++) {
            if (i == Array.length) {
                Array[i - 1] = -1;
            } else {
                if (Array[i - 1] == Array[i]) {
                    i++;
                } else {
                    Array[i - 1] = -1;
                }
            }
        }
        //Repetitions Display
        System.out.println("\nNumbers repeated: ");
        for (int i = 0; i < Array.length; i++) {
            if (Array[i] != -1 && prev != Array[i]) {
                //To make sure if there are 4 of a kind they only display once
                prev = Array[i];
                System.out.print(Array[i] + " ");
                i++;
                found = true;
            }
        }
        //Case none found
        if (!found) {
            System.out.println("None Found");
        }
    }
}