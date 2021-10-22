package app;

/*
* Liam Geyer
* lfg5289@psu.edu
* IST140 - IncomeTax PA
 */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        double taxRate;

        //  Prompt the user for their marital status
        System.out.println("Please provide your marital status: ");
        String maritalStatus = scan.nextLine();
        while (!maritalStatus.toLowerCase().equals("single") && !maritalStatus.toLowerCase().equals("married")){
            System.out.println("Invalid input; please enter single or married");
            System.out.println("Please provide your marital status: ");
            maritalStatus = scan.nextLine();
        }

        //  Prompt the user for their annual income
        System.out.println("Please enter your annual income as a non-comma separated value: ");
        double annualIncome = scan.nextDouble();

        // Use nested if statements to determine tax rates
        if (annualIncome <= 30000){ // individuals making 30k or less
            if (maritalStatus.equalsIgnoreCase("single")) {
                taxRate = .15;
            } else {
                taxRate = .12;
            }
        } else {
            //  Determine the tax rate for individuals making more than 30k
            if (maritalStatus.equalsIgnoreCase("single")) {
                taxRate = .25;
            } else {
                taxRate = .20;
            }
        }

        //  Calculate tax based off annualIncome and taxRate
        Double incomeTax = annualIncome * taxRate;

        //  I'm sure I can format this more efficiently with printf but idrk how, comment appreciated :)
        taxRate = taxRate * 100;

        //  Output all calculated information
        System.out.printf("Based on a status of \"" + maritalStatus.toLowerCase() + "\" and an annual income of $%.2f,\n", annualIncome);
        System.out.printf("the income tax is %.2f percent of $%.2f, which equals %.2f. \n", taxRate, annualIncome, incomeTax);

    }
}
