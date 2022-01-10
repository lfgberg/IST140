package app;

/*
* Liam Geyer
* IST140 - Final Exam
* lfg5289@psu.edu
 */

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static ArrayList<Double> loadTransactionHistory() throws Exception{
        //  Create the arraylist; and the file
        ArrayList<Double> data = new ArrayList<>();
        File fileName = new File("src/transactions.txt");

        try {
            //  Attempt to read from the file
            Scanner input = new Scanner(fileName);

            //  Read each line of the file into the arraylist; parse each line as a double
            while (input.hasNextLine()){
                String temp = input.nextLine();
                data.add(Double.parseDouble(temp));
            }
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }

        return data;
    }

    public static void printMenu(){
        //  Print the menu.
        System.out.println("1. Print Transaction History\n" +
                "2. Print Current Balance\n" +
                "3. Deposit\n" +
                "4. Withdrawal\n" +
                "5. Quit\n" +
                "\n" +
                "Select a menu option 1 through 5:");
    }

    public static void printTransactionHistory(ArrayList<Double> transactionHistory){
        //  Loop through each entry in transaction history, and print it w/formatting
        for (Double transaction : transactionHistory){
            System.out.printf("\n$%.2f", transaction);
        }
        System.out.println();
    }

    public static void printBalance(ArrayList<Double> transactionHistory){
        //  get the last entry; this is the current balance
        double balance = transactionHistory.get(transactionHistory.size() - 1);

        //  print the current balance w/formatting
        System.out.printf("Your current balance is $%.2f\n", balance);
    }

    public static ArrayList<Double> getDeposit(ArrayList<Double> transactionHistory, Scanner scan) throws Exception{
        //  Prompt the user for input
        System.out.println("Enter a dollar amount:");
        Double deposit = null;

        //  attempt to read input from the user
        try {
            deposit = scan.nextDouble();
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }

        //  deposits must be positive
        if (deposit <= 0){
            throw new Exception("Problem with user input.");
        }

        //  update the transaction history and return
        double balance = transactionHistory.get(transactionHistory.size() - 1) + deposit;
        transactionHistory.add(balance);
        return transactionHistory;
    }

    public static ArrayList<Double> getWithdrawal(ArrayList<Double> transactionHistory, Scanner scan) throws Exception{
        //  Prompt the user for input
        System.out.println("Enter a dollar amount:");
        Double withdrawal = null;

        //  attempt to read input from the user
        try {
            withdrawal = scan.nextDouble();
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }

        //  Value to withdraw must be positive
        if (withdrawal <= 0){
            throw new Exception("Problem with user input.");
        }

        //  get current balance
        double balance = transactionHistory.get(transactionHistory.size() - 1);

        //  withdrawal cannot be more than the current balance
        if (withdrawal > balance){
            throw new Exception("Insufficient funds.");
        }

        //  update the transaction history and return
        balance = balance - withdrawal;
        transactionHistory.add(balance);
        return transactionHistory;
    }

    public static void exportTransactionHistory(ArrayList<Double> transactionHistory) throws Exception{
        PrintWriter out = null;

        try {
            //  Attempt to write each line of the array to a file
            out = new PrintWriter("transaction_final.txt");
            for (Double x : transactionHistory){
                out.println(x);
            }
        } catch (Exception e){
            throw new Exception(e.getMessage());
        } finally {
            //  close the file
            if (out != null) {
                out.close();
            }
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //  Attempt to read transaction history from the file
        ArrayList<Double> transactionHistory = null;
        try {
            transactionHistory = loadTransactionHistory();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        //  Loop through the menu until the quit option is picked, and keepLooping changes
        boolean keepLooping = true;
        int input = 0;
        do {
            printMenu();

            //  attempt to get input from the user
            try {
                input = scan.nextInt();
            } catch (Exception e){
                System.out.println(e.getMessage());
                input = 0;
            }

            //  pick the appropriate action based off user input
            switch (input){
                case 1:
                    printTransactionHistory(transactionHistory);
                    break;
                case 2:
                    printBalance(transactionHistory);
                    break;
                case 3:
                    try {
                        getDeposit(transactionHistory, scan);
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        getWithdrawal(transactionHistory, scan);
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    //  stop looping; attempt to export transactionhistory to a file
                    System.out.println("Goodbye!");
                    try {
                        exportTransactionHistory(transactionHistory);
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    keepLooping = false;
                    break;
                default:
                    System.out.println("No valid choice selected.");
                    break;
            }
        } while (keepLooping);
    }
}
