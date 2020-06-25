import java.util.Scanner;

import Q7Resources.*;

public class Q7 {
    public static void main(String[] args){
        //Declarations
        int choice;
        String choiceS;
        Scanner inp = new Scanner(System.in);
        BinSearchTree BST = new BinSearchTree();
        int data;
        String dataS;

        do {
            try {
                //Menu & Input
                System.out.println("Enter choice;\n1. Add New item to BST\n2. Display BST\n3. Exit");
                choiceS = inp.next();
                choice = Integer.parseInt(choiceS);

                switch (choice) {
                    case 1:
                        //Case Add
                        System.out.println("Please enter an integer to input");
                        dataS = inp.next();
                        data = Integer.parseInt(dataS);
                        Node newNode = new Node(data);
                        BST.insert(BST.getRoot(), newNode);
                        System.out.println("Successful Entry");
                        break;
                    case 2:
                        //Case Display
                        System.out.println("Inorder Display:");
                        BST.show(BST.getRoot());
                        break;
                    case 3:
                        //Case Exit
                        System.out.println("Goodbye!");
                        break;
                    default:
                        //Case Invalid
                        System.out.println("Invalid Input");
                        break;
                }
            }catch(Exception E){
                //Case Fatal Error
                System.out.println("Invalid Input");
                choice = 0;
            }
        } while (choice != 3);
    }
}