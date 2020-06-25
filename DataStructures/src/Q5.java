import java.util.*;

public class Q5 {
    public static void main(String[] args) {
        //Code Explanation & inspiration came from https://stackoverflow.com/questions/14100522/reverse-polish-notation-java
        //Declarations
        double num1, num2, toPush;
        String s, x;
        boolean error, first;
        StringTokenizer str;
        Stack<Double> stk = new Stack<>();
        Scanner inp = new Scanner(System.in);
        StringBuilder display;
        int counter, operation;
        do {
            try {
                //Case Error Reset
                display = new StringBuilder();
                first = true;
                error = false;
                stk.clear();
                counter = 0;
                operation = 0;
                //Input
                System.out.println("Enter RPN Expression: ");
                x = inp.nextLine();
                //Tokenize x into readable format
                str = new StringTokenizer(x);
                //Breaking down the expression
                while (str.hasMoreElements()) {

                    s = (String) str.nextElement();

                    if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                        counter = 1;
                        num2 = stk.pop();
                        System.out.println("\nOperation " + ++operation + " begins\nStack Element 2 now has been popped and has been transferred to temp storage: " + num2);
                        num1 = stk.pop();
                        System.out.println("Stack Element 1 now has been popped and has been transferred to temp storage: " + num1);
                        switch (s) {
                            case "+":
                                System.out.println("+ Operator detected. Calculation process begins....");
                                stk.push(num1 + num2);
                                System.out.println("Complete! Current Stack has element 1 as; " + (num1+num2) + "\n");
                                if(first){
                                    display = new StringBuilder(num1 + " + " + num2);
                                    first = false;
                                }else {
                                    display = new StringBuilder("(" + display + ") + " + num2);
                                }

                                break;
                            case "-":
                                System.out.println("- Operator detected. Calculation process begins....");
                                stk.push(num1 - num2);
                                System.out.println("Complete! Current Stack has element 1 as; " + (num1-num2)+ "\n");
                                if(first){
                                    display = new StringBuilder(num1 + " - " + num2);
                                    first = false;
                                }else {
                                    display = new StringBuilder("(" + display + ") - " + num2);
                                }
                                break;
                            case "/":
                                System.out.println("/ Operator detected. Calculation process begins....");
                                stk.push(num1 / num2);
                                System.out.println("Complete! Current Stack has element 1 as; " + (num1/num2)+ "\n");
                                if(first){
                                    display = new StringBuilder(num1 + " / " + num2);
                                    first = false;
                                }else {
                                    display = new StringBuilder("(" + display + ") / " + num2);
                                }
                                break;
                            case "*":
                                System.out.println("* Operator detected. Calculation process begins....");
                                stk.push(num1 * num2);
                                System.out.println("Complete! Current Stack has element 1 as; " + (num1*num2)+ "\n");
                                if(first){
                                    display = new StringBuilder(num1 + " * " + num2);
                                    first = false;
                                }else {
                                    display = new StringBuilder("(" + display + ") * " + num2);
                                }
                                break;
                        }
                    } else {
                        toPush = Double.parseDouble(s);
                        stk.push(toPush);
                        System.out.println("Current Stack has element " + ++counter + " as; " + toPush);
                    }
                }
                System.out.println(display);
                System.out.println("The result of your RPN expression is " + stk.pop());

            } catch (Exception E) {
                //Case Error
                System.out.println("There was a problem in your input which caused error " + E + ".\nPlease re-enter your equation with adequate spacing and correct syntax");
                error = true;
            }
        } while (error);
    }
}