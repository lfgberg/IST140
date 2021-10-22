package app;

/*
* Liam Geyer
* lfg5289@psu.edu
* IST140 - MinMax Exercise
 */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        double[] numbers = new double[5];

        //  Prompts the user to enter an integer for each value in the array
        for (int i = 0; i < numbers.length; i++){
            do {
                System.out.println("Enter a double between -100, and 100: ");
                numbers[i] = scan.nextDouble();
                if (numbers[i] > 100 || numbers[i] < -100){
                    System.out.println("Double must be between -100, and 100.");
                }
            } while (numbers[i] > 100 || numbers[i] < -100);
        }

        double min = numbers[0];
        double max = numbers[0];
        double average = 0;

        for (double number : numbers){
            //  Keep a total
            average = average + number;

            if (min > number){
                min = number;
            }
            if (max < number){
                max = number;
            }
        }

        //  turn the total into an average
        average = average / numbers.length;

        //  Output the values with the doubles formatted to 2 decimals
        System.out.printf("The user entered: %.2f, %.2f, %.2f %.2f %.2f\n", numbers[0], numbers[1], numbers[2], numbers[3], numbers[4]);
        System.out.printf("The min is %.2f, max is %.2f, and the average is %.2f\n", min, max, average);

    }
}
