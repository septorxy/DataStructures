import java.util.Scanner;

public class Q11 {

    private static int factorial(int num) {
        if (num == 1) {
            return num;
        } else {
            return num * factorial(num - 1);
        }
    }

    private static double sine(double num, int n) {
        double ans = 0;
        for (int i = 1; i < n + 1; i++) {
            ans += Math.pow(-1, i) * (Math.pow(num, (2 * i) + 1) / factorial((2 * i) + 1));
        }
        return ans;
    }

    private static double cosine(double num, int n) {
        double ans = 1;
        for (int i = 1; i < n + 1; i++) {
            ans += Math.pow(-1, i) * (Math.pow(num, 2 * i) / factorial(2 * i));
        }
        return ans;
    }


    public static void main(String[] args) {
        double calc = 0, temp = 0;
        int choice, n = 0;
        String choiceS, calcS, nS, choice2 = null;
        Scanner inp = new Scanner(System.in);
        do {
            try {
                System.out.println("Would you like to calculate cos(x) or sin(x)?\n1. cos(x)\n2. sin(x)\n3. Exit\nPlease enter your choice:");
                choiceS = inp.nextLine();
                choice = Integer.parseInt(choiceS);
                if (choice == 1 || choice == 2) {
                    System.out.println("1. Degrees or 2. Radians");
                    choice2 = inp.nextLine();
                    System.out.println("Enter x");
                    calcS = inp.nextLine();
                    calc = Double.parseDouble(calcS);
                    temp = calc;
                    if (choice2.equals("1")) {
                        calc = calc * (Math.PI / 180);
                    } else if (!choice2.equals("2")) {
                        choice = 4;
                    }
                    if (calc > Math.PI * 2 || calc < -2 * Math.PI) {
                        System.out.println("While this program will still run please be advised that due to the limited number of terms the answer may not be accurate. For best results please keep x values within the +/-2π or +/- 360 range");
                    }
                    System.out.println("Enter how many terms you would like");
                    nS = inp.nextLine();
                    n = Integer.parseInt(nS);
                    if (n < 1) {
                        System.out.println("The number of terms must be higher than 0");
                        choice = 4;
                    } else if (n > 16) {
                        System.out.println("Due to a system limitation the highest number of terms can only be 16");
                        choice = 4;
                    }
                }
                switch (choice) {
                    case 1:
                        System.out.println("The answer of cos(" + temp + ") = " + cosine(calc, n));
                        break;
                    case 2:
                        System.out.println("The answer of cos( " + temp + ") = " + sine(calc, n));
                        break;
                    case 3:
                        System.out.println("Goodbye");
                        break;
                    default:
                        System.out.println("Invalid Entry");
                        break;
                }
            } catch (Exception E) {
                choice = 4;
                System.out.println("Error. An unexpected input has occurred");
            }
        } while (choice != 3);
    }
}