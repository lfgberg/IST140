package app;

/*
* Liam Geyer
* lfg5289@psu.edu
* IST140 - Parser PA
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static ArrayList<Integer> getInput(Scanner scan){
        String input;
        ArrayList<Integer> output = new ArrayList<>();

        //  Prompt the user for input
        System.out.println("Enter a comma delineated list of integers: ");
        input = scan.nextLine();

        //  Convert the input into an array, splitting by ","
        String[] splitInput = input.split(",");

        //  Add each element from the array into an ArrayList
        for (String x : splitInput){
            output.add(Integer.valueOf(x));
        }

        //  Return the newly populated ArrayList
        return output;
    }

    public static void printArrayList(ArrayList<Integer> ints){
        //  Print each entry on a newline
        for (Integer anInt : ints) {
            System.out.println(anInt);
        }
    }

    public static void main(String[] args) {
	    Scanner scan = new Scanner(System.in);

	    //  Call our methods
	    ArrayList<Integer> ints = getInput(scan);
	    printArrayList(ints);
    }
}
