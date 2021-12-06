package app;

/*
* Liam Geyer
* lfg5289@psu.edu
* IST140 - WeightedAverageCalcMk1 PA
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static ArrayList<Double> getNumbers(Scanner scan)  throws Exception {
        ArrayList<Double> nums = new ArrayList<>();

        //  Prompt the user for input
        System.out.println("Enter a space-separated list of 5-10 numbers:");

        try {
            //  Parse the line of input to an array
            String[] input = scan.nextLine().split(" ");

            //  Populate the arraylist with the parsed string
            for (String num : input){
                nums.add(Double.parseDouble(num));
            }
        } catch (Exception e){
            throw new Exception("Error in user input");
        }

        //  Ensure the proper amount of numbers was entered
        if (nums.size() < 5 || nums.size() > 10){
            throw new Exception("Inputted list must be 5-10 numbers long.");
        }

        return nums;
    }

    public static int getLowestN(Scanner scan, ArrayList<Double> nums)  throws Exception {
        int n;

        //  Prompt the user for input
        System.out.println("Enter the number of entries to drop: ");

        //  Attempt to capture input
        try {
            n = scan.nextInt();
        } catch (Exception e){
            throw new Exception("Error in user input.");
        }

        //  Ensure the value is positive, cannot drop all the numbers either.
        if (n < 0){
            throw new Exception("Dropped value must be positive.");
        } else if (n > (nums.size() - 1)){
            throw new Exception("Dropped value is too large.");
        }

        return n;
    }

    public static double getWeight(Scanner scan) throws Exception {
        double weight;

        //  Prompt the user for input
        System.out.println("Enter a nonzero value less than or equal to 1:");

        //  Attempt to capture input
        try {
            weight = scan.nextDouble();
        } catch (Exception e){
            throw new Exception("Error in user input.");
        }

        //  Ensure the value is within an acceptable scope
        if (weight == 0.0 || weight > 1.0){
            throw new Exception("Weight must be greater than 0 and less than or equal to 1.");
        }

        return weight;
    }

    public static double calcWeightedAverage(ArrayList<Double> nums, int dropped, double weight){
        //  sort nums from low to high
        Collections.sort(nums);

        //  drop n lowest numbers
        for (int i = 0; i < dropped; i++){
            nums.remove(0);
        }

        //  Calculate the weighted average
        double average = 0.0;
        for (double num : nums){
            average = average + num;
        }
        average = (average / nums.size()) * weight;

        return average;
    }

    public static void printWA(ArrayList<Double> nums, int dropped, double weight, double average){
        //  Print all the needed info
        System.out.printf("The weighted average of the numbers is %.2f, when using \" ", average);
        for (double num : nums){
            System.out.print(num + " ");
        }
        System.out.printf("\", where %.2f was the weight used, and the average is computed after dropping the lowest %d value(s).\n", weight, dropped);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //  Declare all variables
        ArrayList<Double> nums = new ArrayList<>();
        int dropped = -1;
        double weight = -1.0;

        //  Attempt to populate the arraylist until it's filled
        do {
            try {
                nums = getNumbers(scan);
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        } while (nums.size() == 0);

        //  Attempt to get the value to drop until it's filled
        do {
            try {
                dropped = getLowestN(scan, nums);
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        } while (dropped == -1);

        //  Attempt to get the weight until it's filled
        do {
            try {
                weight = getWeight(scan);
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        } while (weight == -1.0);

        double average = calcWeightedAverage(nums, dropped, weight);
        printWA(nums, dropped, weight, average);
    }
}
