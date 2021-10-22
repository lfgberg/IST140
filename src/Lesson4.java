package app;

/*
* Liam Geyer
* lfg5289@psu.edu
* IST140 - In Class Code-Along
 */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //  Lesson 4 - Loops

        //  Example while loop
        int counter = 0;
        while (counter < 5){
            System.out.println("This loop has ran " + counter + " times!");
            counter++;
        }

        //  Reset counter
        counter = 0;
        while (true){
            System.out.println("This loop has ran " + counter + " times!");
            counter++;

            //  Use a break statement to break out of the loop
            if (counter == 10){
                break;
            }
        }

        //  Reset counter
        counter = 0;
        //  Example do while loop
        do {
            //  Will run through whatever is in the brackets, and then check the condition
            //  The condition is checked AT THE END OF THE LOOP
            System.out.println("This loop has ran " + counter + " times!");
            counter++;
        } while (counter != 10);

        //  Do-while loops are useful for things like menus where you want things to run at least one
        int choice;
        boolean x = true;
        do {
            //  Display a menu
            System.out.println("1. Appetizers");
            System.out.println("2. Sandwiches");
            System.out.println("3. Entrees");
            System.out.println("4. Quit");
            System.out.println("Enter a menu option: ");

            choice = scan.nextInt();
            switch (choice){
                case 1:
                    System.out.println("You chose Appetizers");
                    break;
                case 2:
                    System.out.println("You chose Sandwiches");
                    break;
                case 3:
                    System.out.println("You chose Entrees");
                case 4:
                    System.out.println("Goodbye!");
                    x = false;
                    break;
                default:
                    System.out.println("Invalid menu option, try again.");
                    break;
            }
        } while (x);

        // Password checker example, looping through a string
        counter = 0;
        String input;

        //  Method of prompting for user input that will loop until a condition is met
        do {
            //  Prompt for user input
            System.out.println("Enter a strong 3 character password: ");
            input = scan.nextLine();
        } while(input.length() != 3);

        //  Looping through each character in a string by assigning it to temp
        while (counter < input.length()){
            char temp = input.charAt(counter);
            //  Checks if each char is a digit or uppercase
            if (Character.isDigit(temp)){
                System.out.println("Character " + counter + " is a digit.");
            }
            if (Character.isUpperCase(temp)){
                System.out.println("Character " + counter + " is uppercase.");
            }
            counter++;
        }

        //  For loop example
        for (int i = 0; i < input.length() - 1; i++){
            char temp = input.charAt(i);
            //  Checks if each char is a digit or uppercase
            if (Character.isDigit(temp)){
                System.out.println("Character " + i + " is a digit.");
            }
            if (Character.isUpperCase(temp)){
                System.out.print("Character " + i + " is uppercase.");
            }
        }

        //  Nested loop example
        for (int i = 0; i < 10; i++) { // <-- outer loop
            System.out.println(i);
            for (int j = 0; j < 10; j++){ //  <--  inner loop
                System.out.print(j);
            } //  <--  end of j loop
        } //  <-- end of i loop

    }
}
