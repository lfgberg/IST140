package app;

/*
* Liam Geyer
* lfg5289@psu.edu
* IST 140 - PhoneNumberConversion PA
 */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //  Read the first line from the command line
        Scanner scnr = new Scanner(System.in);
        System.out.println("Enter your phone number:");
        String input = scnr.nextLine();

        //  Ensure the input is 9 digits
        if (input.length() != 10){
            System.out.println("Please enter 9 digits.");
            input = scnr.nextLine();
        }

        //  Format the area code
        String areaCode = ("(" + input.substring(0,3) + ")");

        //  Concatenate the area code with the rest of the number
        String formattedNumber = areaCode.concat(" " + input.substring(3,6) + "-" + input.substring(6,10));
        System.out.println("Your formatted number:\n" + formattedNumber);
    }
}
