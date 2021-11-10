package app;

/*
* Liam Geyer
* lfg5289@psu.edu
* IST140 - PasswordGeneratorMK2 PA
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static String getKeyPhrase(Scanner scan){
        String key;

        do {
            //  Prompt for input
            System.out.println("Enter a key phrase: ");
            key = scan.nextLine();

            //  Provide feedback on improper input
            if (key.length() < 3){
                System.out.println("Key phrase must be 3 or more characters.");
            }
        }while (key.length() < 3); //  <-- Loop until the length requirement is met

        return key;
    }

    public static String caseVariation(String key){
        //  Loop over each character in keyphrase
        for (int i = 0; i < key.length(); i++){
            char temp = key.charAt(i);
            int rand = (int)((Math.random() * 2) + 1);

            //  Ensure char is alphabetic before trying to edit case
            if (Character.isAlphabetic(temp)){
                //  Change case based off random number
                if (rand == 1){
                    temp = Character.toUpperCase(temp);
                } else {
                    temp = Character.toLowerCase(temp);
                }

                //  re-assemble string
                key = key.substring(0, i) + temp + key.substring(i + 1);
            }
        }

        return key;
    }

    public static String yearVariation(String key){
        //  Find the middle of the string
        int mid = key.length() / 2;

        //  Insert 2021
        return key.substring(0 , mid) + 2021 + key.substring(mid);
    }

    public static String leetSpeak(String key){
        //  Replace letters with numbers
        key = key.replace('e', '3');
        key = key.replace('E', '3');
        key = key.replace('t', '7');
        key = key.replace('T', '7');
        key = key.replace('a', '4');
        key = key.replace('A', '4');

        return key;
    }

    public static String reverse(String key){
        String reversed = "";

        //  Iterate through the string backwards
        for (int i = key.length(); i > 0; i--){
            char temp = key.charAt(i - 1);
            reversed = reversed + temp;
        }

        //  Return reversed string
        return reversed;
    }

    public static ArrayList<String> generatePassword(String key){
        ArrayList<String> passwords = new ArrayList<>();

        //  Call variation methods
        passwords.add(caseVariation(key));
        passwords.add(yearVariation(key));
        passwords.add(leetSpeak(key));
        passwords.add(reverse(key));

        return passwords;
    }

    public static void printPasswords(ArrayList<String> passwords){
        for (String password : passwords){
            System.out.println(password);
        }
    }

    public static void main(String[] args) {
	    Scanner scan = new Scanner(System.in);

	    //  Generate passwords
	    String key = getKeyPhrase(scan);
	    ArrayList<String> passwords = generatePassword(key);

	    //  Print passwords
	    System.out.println("Generated Passwords: ");
	    printPasswords(passwords);
    }
}
