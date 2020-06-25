import java.util.*;

public class Q6 {
    private static boolean isPrime(int max) {
        //https://www.khanacademy.org/computing/computer-science/cryptography/comp-number-theory/v/sieve-of-eratosthenes-prime-adventure-part-4
        //Declarations
        if (max != 1) {
            boolean[] mark = new boolean[max + 1];
            int[] Array = new int[max + 1];
            List<Integer> primes = new ArrayList<>();
            //Populating arrays
            for (int i = 0; i < max + 1; i++) {
                Array[i] = i;
                mark[i] = i == 0 || i == 1;
            }
            //Marking non-primes
            for (int i = 0; i < Math.sqrt(max) + 1; i++) {
                if (!mark[i]) {
                    primes.add(Array[i]);
                    mark[i] = true;
                    for (int j = i * i; j < max + 1; j += i) {
                        mark[j] = true;
                    }
                }
            }
            //Adding the non-marked numbers as primes
            for (int i = (int) (Math.sqrt(max) + 1); i < mark.length; i++) {
                if (!mark[i]) {
                    primes.add(Array[i]);
                }
            }

            //Printing all the primes
            for (int primesV : primes) {
                System.out.print(primesV + " ");
            }
            return primes.get(primes.size() - 1) == max;
        }else{
            System.out.println("No before");
            return false;
        }
    }

    public static void main(String[] args) {
        //Input
        int num = 0;
        String numS;
        boolean again;
        Scanner inp = new Scanner(System.in);
        System.out.println("Enter a number to display the primes before it and to see if it is a prime: ");
        do {
            again = false;
            numS = inp.nextLine();
            try {
                if (Integer.parseInt(numS) < 1) {
                    numS = "Invalid";
                }
                num = Integer.parseInt(numS);
            } catch (Exception E) {
                System.out.println("Invalid. Please re-enter an integer above 0");
                again = true;
            }
        } while (again);
        //Output
        if (isPrime(num)) {
            System.out.println("\nIt's prime");
        } else {
            System.out.println("\nIt's not prime");
        }
    }
}