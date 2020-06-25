public class Q10 {
    //Swap method
    private static void swap(int[] Array, int index) {
        int temp = Array[index];
        Array[index] = Array[index + 1];
        Array[index + 1] = temp;
    }
    //Recursive Method
    private static int biggest(int[] Array, int i) {
        if (i == Array.length - 1) {
            return Array[i];
        } else if (Array[i] > Array[i + 1]) {
            swap(Array, i);
            return biggest(Array, ++i);
        } else {
            return biggest(Array, ++i);
        }
    }

    public static void main(String[] args) {
        int[] Array = new int[100];
        //Generation of Array
        for (int i = 0; i < Array.length; i++) {
            Array[i] = (int) (Math.random() * 1000);
            System.out.print(Array[i] + " ");
        }
        //Call of function
        int big = biggest(Array, 0);
        //Display
        System.out.println("\nThe biggest num in the array is: " + big);
    }
}