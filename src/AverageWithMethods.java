package app;

/*
* Liam Geyer
* lfg5289@psu.edu
* IST140 - AverageWithMethods Exercise
 */

import java.util.Scanner;

public class Main {

    public static double[] getNumbers(Scanner scan){
        int count;
        do {
            //  Determine the number of doubles to ask for, at least 5
            System.out.println("How many numbers would you like to enter?");
            count = scan.nextInt();

            //  Provide feedback on invalid input
            if (count > 10 || count < 5){
                System.out.println("You must enter a value between 5-10");
            }
        } while (count > 10 || count < 5);

        //  Create an array with the size of the user's number
        double[] numbers = new double[count];

        //  populate the array
        for (int i = 0; i < count; i ++){
            System.out.println("Enter a double: ");
            numbers[i] = scan.nextDouble();
        }

        return numbers;
    }

    public static double calcAverage(double[] numbers){
        //  Create a variable to store the total in
        double average = 0.0;

        //  Add each entry to the total
        for (int i = 0; i < numbers.length; i++){
            average = average + numbers[i];
        }

        //  Divide the total by the length to make it an average
        average = average / numbers.length;
        return average;
    }

    public static void printAverage(double[] numbers, double average){
        //  Print the array
        System.out.print("The average of the numbers ");
        for (int i = 0; i < numbers.length; i++){
            System.out.printf("%.2f, ", numbers[i]);
        }

        //  Print the average
        System.out.printf("is %.2f.\n", average);
    }

    public static void main(String[] args) {
        //  Create a single scanner
        Scanner scan = new Scanner(System.in);

        //  Run it
        double[] numbers = getNumbers(scan);
        double average = calcAverage(numbers);
        printAverage(numbers, average);
    }
}
