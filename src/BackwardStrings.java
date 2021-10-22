package app;

/*
* Liam Geyer
* lfg5289@psu.edu
* IST140 - BackwardsStrings Exercise
 */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //  Prompt the user for input
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter two 3 character strings:");

        //  Assign the next 2 inputs to strings
        String[] input = new String[2];
        input[0] = scan.nextLine();
        input[1] = scan.nextLine();

        //  Ensure the strings are 3 char long - if not re prompt
        while (input[0].length() != 3 || input[1].length() != 3){
            System.out.println("Invalid string length for one or both inputs");
            System.out.println("Enter two 3 character strings:");
            input[0] = scan.nextLine();
            input[1] = scan.nextLine();
        }

        //  Ensure the strings contain 1 uppercase char - if not re prompt
        //  This is like horribly ugly I know sorry :/
        //  It works though albeit poorly. Didn't loop through characters as suggested.
        while ((!Character.isUpperCase(input[0].charAt(0)) && !Character.isUpperCase(input[0].charAt(1)) && !Character.isUpperCase(input[0].charAt(2))) || (!Character.isUpperCase(input[1].charAt(0)) && !Character.isUpperCase(input[1].charAt(1)) && !Character.isUpperCase(input[1].charAt(2)))){
            System.out.println("String must contain at least 1 uppercase character");
            System.out.println("Enter two 3 character strings:");
            input[0] = scan.nextLine();
            input[1] = scan.nextLine();
        }

        //  Reverse the Strings
        String reversedInputA = String.valueOf(input[0].charAt(2)) + String.valueOf(input[0].charAt(1)) + String.valueOf(input[0].charAt(0));
        String reversedInputB = String.valueOf(input[1].charAt(2)) + String.valueOf(input[1].charAt(1)) + String.valueOf(input[1].charAt(0));

        //  Print both the original and reversed Strings
        System.out.println("The two strings you entered are: " + input[0] + " " + input[1] + ".");
        System.out.println("The two strings in reverse are: " + reversedInputA + " " + reversedInputB + ".");

        /*
        obviously this isn't great but another thing wrong with it, is if you initially enter 2x 3 length strings initially-
        and then you're asked to reenter by the 2nd while loop, you'll always get the warning regarding case and not length, even if you enter a string of the improper length
         */

    }
}
