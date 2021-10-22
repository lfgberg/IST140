package app;

/*
* Liam Geyer
* lfg5289@psu.edu
* IST140 - PasswordChecker PA
 */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //  Prompt the user for input
        Scanner scan = new Scanner(System.in);
        System.out.println("Our strong password policy requires passwords to be 3 characters long, and contain at least one uppercase letter and number.");
        System.out.println("Please enter a strong password: ");
        String inputPassword = scan.nextLine();

        //  Check the length of inputPassword, using a nested if statement
        if (inputPassword.length() == 3){

            //  Check whether or not each character is uppercase
            Boolean[] isUpperCase = new Boolean[3];
            isUpperCase[0] = Character.isUpperCase(inputPassword.charAt(0));
            isUpperCase[1] = Character.isUpperCase(inputPassword.charAt(1));
            isUpperCase[2] = Character.isUpperCase(inputPassword.charAt(2));

            if (isUpperCase[0] || isUpperCase[1] || isUpperCase[2]){

                //  Now that we know the input is both 3 char long and has an uppercase character, check for a digit
                Boolean[] isDigit = new Boolean[3];
                isDigit[0] = Character.isDigit(inputPassword.charAt(0));
                isDigit[1] = Character.isDigit(inputPassword.charAt(1));
                isDigit[2] = Character.isDigit(inputPassword.charAt(2));

                if (isDigit[0] || isDigit[1] || isDigit[2]){

                    // inputPassword must have passed all three checks to reach this level of the nested if statement, password is valid
                    System.out.println("The provided password is valid.");
                } else {
                    System.out.println("The provided password is invalid. Please try again.");
                }
            } else {
                System.out.println("The provided password is invalid. Please try again.");
            }
        } else {
            System.out.println("The provided password is invalid. Please try again.");
        }
    }
}
