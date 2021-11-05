package app;

/*
* Liam Geyer
* lfg5289@psu.edu
* IST140 - ATMSimulatorMK3 Exercise
 */

import java.util.Scanner;

public class Main {

    public static void printMenu(){
        //  Print the menu
        System.out.println("Enter the number of your desired transaction type: ");
        System.out.println("1. Balance\n2. Deposit\n3. Withdrawal\n4. Quit");
    }

    public static void printBalance(double balance){
        //  Display current balance formatted to 2 decimals
        System.out.printf("Your current balance is $%.2f\n", balance);
    }

    public static double getDollars(Scanner scan){
        double dollars;
        do {
            //  Prompt for input
            System.out.println("Enter a dollar amount: ");
            dollars = scan.nextDouble();

            //  Provide feedback on unacceptable input
            if (dollars <= 0){
                System.out.println("Dollar amount must be greater than 0.");
            }
        } while (dollars <= 0);

        //  Return validated amount
        return dollars;
    }

    public static void main(String[] args) {
	    Scanner scan = new Scanner(System.in);

	    //  Set initial account balance
	    double balance = 1293.67;
	    int input;

	    do {
	        //  Print the menu and prompt for input
            printMenu();
            input = scan.nextInt();

            switch (input) {
                case 1 ->
                        //  Print the balance
                        printBalance(balance);
                case 2 -> {
                    //  Get a value to deposit, and add it to the balance
                    double deposit = getDollars(scan);
                    balance = balance + deposit;
                    printBalance(balance);
                }
                case 3 -> {
                    //  Get a value to withdraw
                    double withdrawal = getDollars(scan);

                    //  Display insufficient funds if there isn't enough in the account
                    if (withdrawal > balance) {
                        System.out.print("Insufficient funds. ");
                        printBalance(balance);
                    } else {
                        //  Withdraw given amount and print balance
                        balance = balance - withdrawal;
                        printBalance(balance);
                    }
                }
                case 4 -> System.out.println("Good-bye.");
                default -> System.out.println("Invalid input, try again.");
            }
        } while (input != 4); //  <-- Stop running when the quit option is picked
    }
}
