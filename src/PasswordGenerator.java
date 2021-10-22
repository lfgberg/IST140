package app;

/*
* Liam Geyer
* lfg5289@psu.edu
* IST140 - PasswordGenerator PA
 */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String key;
        String term;
        String output = "";

        do {
            //  Prompt the user for input
            System.out.println("Enter a 3 character string with no spaces: ");
            key = scan.next(); //  <-- use of .next() negates the need to check for whitespace, it'll ignore after any whitespace
            System.out.println("Enter a string that's at least 3 characters long with no spaces: ");
            term = scan.next();

            //  Provide feedback on input
            if (key.length() != 3){
                System.out.println("The first string must be 3 characters long.");
            }
            if (term.length() < 3){
                System.out.println("The second string must be at least 3 characters long.");
            }
            // numbers are fine, but we can't capitalize the first letter later if it isn't a letter
            if (!Character.isAlphabetic(term.charAt(0))){
                System.out.println("The first character of the second string must be a letter.");
            }
        } while (key.length() != 3 || term.length() < 3 || !Character.isAlphabetic(term.charAt(0)));

        //  loop 5 times
        for (int i = 0; i < 5; i++){
            String temp;
            switch (i) {
                case 0 ->
                        output = term.concat(String.valueOf(key.length())); //  <-- append the length of the key to the term
                case 1 -> {
                    temp = String.valueOf(term.charAt(0)).toUpperCase(); //  <-- take the first char, and capitalize it
                    output = temp.concat(output.substring(1, output.length())); //  <-- append the rest of the term
                }
                case 2 -> output = output.concat(key); //  <-- append the key
                case 3 -> output = output.replace("e", "3"); // <-- replace e with 3
                case 4 -> output = output.concat("!"); //  <-- append !
            }

            //  Print the output
            System.out.println(output);
            }
        }

    }
