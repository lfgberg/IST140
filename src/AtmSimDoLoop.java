package app;

/*
* Liam Geyer
* lfg5289@psu.edu
* IST140 - AtmSim Mk.2
 */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

	    int input;
	    double balance = 202;
	    Scanner scan = new Scanner(System.in);

	    do {
	        //  Prompt user for input
            System.out.println("Enter the number of your desired transaction type: ");
            System.out.println("1. Balance\n2. Deposit\n3. Withdrawal\n4. Quit");
            input = scan.nextInt();

            switch (input){
                case 1:
                    //  Display the current balance
                    System.out.printf("Your current balance is $%.2f\n", balance);
                    break;
                case 2:
                    //  Prompt for the amount of the deposit
                    System.out.println("Enter the amount of your deposit: ");
                    double temp = scan.nextDouble();

                    // Add the deposit to the current balance
                    balance = balance + temp;

                    //  Display the current balance
                    System.out.printf("Your current balance is $%.2f\n", balance);
                    break;
                case 3:
                    //  Prompt for the amount of the withdrawal
                    System.out.println("Enter the amount of your withdrawal: ");
                    temp = scan.nextDouble();

                    if (temp <= balance){
                        //  Complete the withdrawal if there's sufficient funds
                        balance = balance - temp;
                        System.out.printf("Your current balance is $%.2f\n", balance);
                    } else {
                        System.out.printf("Insufficient funds. Your current balance is $%.2f\n", balance);
                    }
                    break;
                case 4:
                    System.out.println("Good-bye.");
                    break;

            }
        } while (input != 4); // <-- Run unless option 4 is picked
    }
}
