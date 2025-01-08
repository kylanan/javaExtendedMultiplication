import java.io.*;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws Exception {
        Scanner scnr = new Scanner(System.in);
        
        DoubleLinkList val1 = new DoubleLinkList();
        DoubleLinkList val2 = new DoubleLinkList();
        DoubleLinkList product = new DoubleLinkList();
        
        boolean validInt = false;
        String str1 = "";
        while(!validInt) {
            System.out.print("Enter first positive integer: ");
            str1 = scnr.nextLine();
            validInt = true;
            for(int i = 0; i < str1.length(); i++) {
                if(!Character.isDigit(str1.charAt(i))) {
                    validInt = false;
                    break;
                }
            }
        }

        validInt = false;
        String str2 = "";
        while(!validInt) {
            System.out.print("Enter second positive integer: ");
            str2 = scnr.nextLine();
            validInt = true;
            for(int i = 0; i < str2.length(); i++) {
                if(!Character.isDigit(str2.charAt(i))) {
                    validInt = false;
                    break;
                }
            }
        }

        for(int i = 0; i < str1.length(); i++) {
            int x = Integer.valueOf(str1.charAt(i)) - 48;
            val1.insertAtEnd(x);
        }

        for(int i = 0; i < str2.length(); i++) {
            int x = Integer.valueOf(str2.charAt(i)) - 48;
            val2.insertAtEnd(x);
        }

        product.multiply(val1, val2);

        val1.printList();
        System.out.print(" * ");
        val2.printList();
        System.out.print(" = ");
        product.printList();

        scnr.close();
    }

}