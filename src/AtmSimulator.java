package app;

/*
* Liam Geyer
* lfg5289@psu.edu
* IST140 - AtmSimulator Exercise
 */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //  Initialize the account balance
        double balance = 202;

        //  Prompt the user with a menu
        Scanner scan = new Scanner(System.in);
        System.out.println("1. Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdrawal");
        System.out.println("4. Quit");
        System.out.println("Enter the number of your desired transaction type: ");
        int choice = scan.nextInt();

        //  Switch statement with a case for each menu option
        switch (choice) {
            case 1:
                //  Balance - output the initial balance
                System.out.printf("Your current balance is $%.2f", balance);
                break;
            case 2:
                //  Deposit - prompt for an amount to deposit
                System.out.println("Enter the amount you'd like to deposit: ");
                double deposit = scan.nextDouble();
                //  Add the deposit amount to the initial balance
                balance = balance + deposit;
                System.out.printf("Your current balance is $%.2f", balance);
                break;
            case 3:
                //  Withdrawal - prompt for an amount to withdraw
                System.out.println("Enter the amount you'd like to withdraw: ");
                double withdrawal = scan.nextDouble();
                //  Check to ensure there's funds remaining - print insufficient funds if not
                if (balance >= withdrawal) {
                    balance = balance - withdrawal;
                    System.out.printf("Your current balance is $%.2f", balance);
                } else {
                    System.out.println("Insufficient funds");
                }
                break;
            case 4:
                //  Quit
                System.out.println("Good-bye");
                break;
            default:
                System.out.println("Invalid menu choice.");
                break;
        }
    }
}
