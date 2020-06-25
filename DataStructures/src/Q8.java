import java.text.DecimalFormat;
import java.util.Scanner;

public class Q8 {
    private static double findXNot(double num) {
        //Explanation on how to use Newton-Raphson: https://www.youtube.com/watch?v=SPlAHHJbbz0
        double curr;
        double x = -1.0;
        DecimalFormat value = new DecimalFormat("#.#");
        do {
            x++;//This is before as x needs to be saved for later and cannot be changed after calculation
            curr = Math.pow(x, 2) - num;
        } while (curr < 0);
        //Find midpoint of when signs change and determine whether we should increase or decrease valu  e of x0
        x = x - 0.5;
        curr = Math.pow(x, 2) - num;
        if (curr > 0) {
            do {
                x -= 0.1;
                curr = Math.pow(x, 2) - num;
            } while (curr > 0);
            x += 0.1;
        } else if (curr < 0) {
            do {
                x += 0.1;
                curr = Math.pow(x, 2) - num;
            } while (curr < 0);
            x -= 0.1;
        }
        return Double.parseDouble(value.format(x));
    }

    private static double findAns(double x0, double num) {
        double xNext = 0, xPrev;
        //Format for number to display to 2 d.p.
        DecimalFormat value = new DecimalFormat("#.###");
        //Setting first x value to XNot
        xPrev = x0;
        //Perform twice due to accuracy of xNot does not need to happen much
        for(int i = 0; i<2; i++) {
            xNext = xPrev - ((Math.pow(xPrev, 2) - num) / (2 * xPrev));
        }
        return Double.parseDouble(value.format(xNext));
    }

    public static void main(String[] args) {
        //Declarations
        Scanner inp = new Scanner(System.in);
        double n;
        String nS;
        double finalAnswer;
        //Input
        do {
            try {
                System.out.println("Enter num");
                nS = inp.next();
                n = Double.parseDouble(nS);
                if (n <= 0) {
                    System.out.println("Invalid range. Number must be bigger than 0");
                }
            }catch(Exception E){
                System.out.println("Invalid Input");
                n = 0;
            }
        } while (n <= 0);
        //Calculation in main method
        finalAnswer = findAns(findXNot(n), n);
        //Display
        System.out.println("Newton-Raphson Method Answer: " + finalAnswer);
        //System.out.println(Math.sqrt(num)); This line was used for testing purposes
    }
}   