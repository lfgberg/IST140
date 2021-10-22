package app;

/*
* Liam Geyer
* lfg5289@psu.edu
* IST140 - DistanceCalc Exercise
 */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        //  Capture 2 doubles as gallonsRemaining and mpg
        System.out.println("Enter remaining fuel in gallons:");
        double gallonsRemaining = scnr.nextDouble();

        System.out.println("Enter your vehicle's fuel efficiency in miles per gallon:");
        double mpg = scnr.nextDouble();

        //  Calculate the distance that can be traveled
        double distance = gallonsRemaining * mpg;

        //  Output the distance that can be traveled
        System.out.printf("You are able to travel %.2f miles on remaining fuel.\n", distance);
    }
}
