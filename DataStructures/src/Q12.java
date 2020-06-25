import java.util.Scanner;

public class Q12 {
    private static void Fibonacci(int iterator) {
        //Fibonacci Sequence explanation https://en.wikipedia.org/wiki/Fibonacci_number
        int[] Array = new int[3];
        int ans;
        Array[0] = 1;
        Array[1] = 1;
        System.out.print("Sequence:");
        if (iterator > 2) {
            ans = 2;
            System.out.print("1 1 ");
            for (int i = 0; i < iterator - 2; i++) {
                Array[2] = Array[1] + Array[0];
                ans += Array[2];
                System.out.print(Array[2] + " ");
                Array[0] = Array[1];
                Array[1] = Array[2];
            }
        } else {
            ans = iterator;
            if (iterator == 1) {
                System.out.print("1");
            } else {
                System.out.print("1 1");
            }
        }
        System.out.println("\nSum: " + ans);
    }

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int num = 0;
        String numS;
        boolean again;
        do {
            try {
                again = false;
                System.out.println("Fibonacci Sequence Calculator. Please enter how many terms of the fibonacci sequence should be summed up");
                numS = inp.next();
                if (Integer.parseInt(numS) < 0) {
                    numS = "Invalid";
                }
                num = Integer.parseInt(numS);
            } catch (Exception E) {
                System.out.println("Invalid Input. Input must bigger or equal to 0");
                again = true;
            }
        } while (again);
        Fibonacci(num);
    }
}