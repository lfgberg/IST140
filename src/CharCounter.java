package app;

/*
* Liam Geyer
* lfg5289@psu.edu
* IST140 - CharCounter Exercise
 */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String inputEntry;
        String inputCharacter;
        int x = 0;

	    //  Capture a string of 10 or more characters
        do {
            System.out.println("Enter a string of ten or more characters: ");
            inputEntry = scan.nextLine();

            //  Give feedback if the string is not 10 or more char long
            if (inputEntry.length() < 10){
                System.out.println("Invalid input, string must be 10 or more characters long.");
            }
        } while (inputEntry.length() < 10);

        //  Capture a single character
        do {
            System.out.println("Enter a single character: ");
            inputCharacter = scan.nextLine();

            // Give feedback if the string is not a single letter
            if (inputCharacter.length() != 1 || Character.isDigit(inputCharacter.charAt(0))){
                System.out.println("Invalid input, please enter a single letter.");
            }
        } while (inputCharacter.length() != 1 || Character.isDigit(inputCharacter.charAt(0)));

        //  determine how many times the character is in the string
        for (int i = 0; i < inputEntry.length() - 1; i++){
            char tmp = inputEntry.charAt(i);

            //  iterate counter if characters match
            if (tmp == inputCharacter.charAt(0)){
                x++;
            }
        }

        //  Output the number of instances of the character in the string
        System.out.println("There is " + x + " occurrence(s) of '" + inputCharacter + "' in '" + inputEntry + "'.");
    }
}
