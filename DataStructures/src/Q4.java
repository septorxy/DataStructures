import java.util.*;

public class Q4 {

    private static boolean check(ArrayList<Integer> pair1, ArrayList<Integer> pair2, int a, int b) {
        for (int i = 0; i < pair1.size(); i++) {
            if ((pair1.get(i) == a && pair2.get(i) == b) || (pair2.get(i) == a && pair1.get(i) == b)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        //Declarations
        int a, b, c, d, size, temp;
        String sizeS;
        boolean found = false, again = false;
        List<Integer> l = new ArrayList<>();
        ArrayList<Integer> pair1 = new ArrayList<>();
        ArrayList<Integer> pair2 = new ArrayList<>();
        Scanner inp = new Scanner(System.in);
        //Input of List Size
        do {
            if (!again) {
                System.out.println("How big would you like the list to be?");
                again = true;
            } else {
                System.out.println("Invalid.");
            }
            try{
                sizeS = inp.nextLine();
                size = Integer.parseInt(sizeS);
            }catch(Exception E){
                size = 0;
            }
        } while (size < 1);
        //List Generation
        System.out.println("List: ");
        for (int i = 0; i < size; i++) {
            temp = (int) (Math.random() * (1024) + 1);
            l.add(temp);
            System.out.println((i + 1) + ". " + temp);

        }
        //Pair Detection
        for (int i = 0; i < size; i++) {
            for (int j = i; j < size; j++) {
                if ((i != j) && !l.get(j).equals(l.get(i)) && check(pair1, pair2, l.get(i), l.get(j))) {
                    pair1.add(l.get(i));
                    pair2.add(l.get(j));
                }
            }
        }
        //Products calculated of pairs
        int[] products = new int[pair1.size()];
        for (int i = 0; i < pair1.size(); i++) {
            products[i] = pair1.get(i) * pair2.get(i);
        }
        //Products are checked with each other to see which matches.
        //If they match they are checked to make sure they are all unique to each other.
        //If a 2-pair is detected it is displayed
        int k = 0;
        System.out.println("2-Pairs Found; ");
        for (int i = 0; i < pair1.size(); i++) {
            for (int j = i + 1; j < pair1.size(); j++) {
                if (products[i] == products[j]) {
                    a = pair1.get(i);
                    b = pair2.get(i);
                    c = pair1.get(j);
                    d = pair2.get(j);
                    if (a != b && b != c && c != d && a != c && b != d) {
                        k++;
                        System.out.print("((" + a + "," + b + "),(" + c + "," + d + "))  \t");
                        if (k % 5 == 0) {
                            System.out.print("\n");
                        }
                        found = true;
                    }
                }
            }
        }
        //Case if no 2-pairs found
        if (!found) {
            System.out.println("No 2-pairs found");
        }
    }
}