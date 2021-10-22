package app;

/*
* Liam Geyer
* lfg5289@psu.edu
* IST140 - Rooter Exercise
 */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int input;

        do {
            //  Prompt the user for input
            System.out.println("Enter a positive integer: ");
            input = scan.nextInt();

            //  Provide feedback
            if (input <= 0){
                System.out.println("Invalid input, must be a positive integer. Please try again.");
            }
        } while (input <= 0);

        //  Count down from input to 0
        for (int i = input; i > 0; i--){
            //  Take the sqrt and print
            double root = Math.sqrt(i);
            System.out.printf("Square root of %d is %.4f \n", i, root);
        }

    }
}
