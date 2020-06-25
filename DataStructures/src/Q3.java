import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        int j = 0, size = 0;
        String sizeS;
        boolean again;
        Scanner inp = new Scanner(System.in);
        do {
            try{
                again = false;
                System.out.println("How big do you want the array to be?");
                sizeS = inp.next();
                if(Integer.parseInt(sizeS)<=0){
                    sizeS = "Invalid";
                }
                size = Integer.parseInt(sizeS);
            }catch(Exception E){
                System.out.println("Invalid Input. Input must be an integer larger than 0");
                again = true;
            }
        } while (again);
        int[] extreme = new int[size];
        int[] A = new int[size];
        System.out.println("Array: ");
        for (int i = 0; i < size; i++) {
            A[i] = (int) (Math.random() * 100);
            System.out.print(A[i] + " ");
        }
        for (int i = 1; i < size - 1; i++) {
            if ((A[i - 1] < A[i] && A[i] > A[i + 1]) || (A[i - 1] > A[i] && A[i] < A[i + 1])) {
                extreme[j++] = A[i];
            }
        }
        if (j == 0) {
            System.out.print("\nSOLVED!");
        } else {

            System.out.println("\nExtreme Points:");
            for (int i = 0; i < j; i++) {
                System.out.print(extreme[i] + " ");
            }
        }
    }
}