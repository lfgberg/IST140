package app;

/*
* Liam Geyer
* lfg5289@psu.edu
* PasswordCheckerMK2 - IST140
 */

import java.util.Scanner;

public class Main {

    public static String getPassword(Scanner scan){
        //  Prompt the user for input
        System.out.println("Enter a strong password that's 3-12 characters in length: ");

        //  Return the passwd
        return scan.nextLine();
    }

    public static boolean validatePasswd(String passwd){
        boolean[] valid = new boolean[3];

        //  Check for length
        if (passwd.length() > 12 || passwd.length() < 3){
            //  Provide feedback on bad input
            System.out.println("ERROR: Password must be between 3-12 characters in length.");
        } else {
            valid[0] = true;
        }

        //  Loop through each character of the string
        for (int i = 0; i < passwd.length(); i++){
            //  Pickout a specific character
            char temp = passwd.charAt(i);

            //  Set the second condition to true if a digit is found
            if (Character.isDigit(temp)){
                valid[1] = true;
            }

            //  Set the last condition to true if an uppercase char is found
            if (Character.isUpperCase(temp)){
               valid[2] = true;
            }
        }

        //  Provide feedback on input
        if (!valid[1]){
            System.out.println("ERROR: Password must contain at least one number.");
        }
        if (!valid[2]){
            System.out.println("ERROR: Password must contain at least one uppercase letter.");
        }

        //  Pass true if all of the validation conditions have been met
        if (valid[0] && valid[1] && valid[2]){
            System.out.println("The password is valid!");
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String passwd;
        boolean valid = false;

        //  Loop until a valid password is found
        do {
            passwd = getPassword(scan);
            valid = validatePasswd(passwd);
        } while (!valid);
    }
}
