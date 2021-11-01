package app;

/*
* Liam Geyer
* lfg5289@psu.edu
* IST140 - Lesson 5 Notes
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Lesson 5 - Arrays

        Scanner scan = new Scanner(System.in);

        //  Multidimensional array
        int[][] deez = new int[2][4]; //  <-- type[rows][cols]

        //  you can either initialize by specifying rowsXcols or by populating it with data
        int[][] deeznuts = {{1,2}, {3,4}, {5,6}};


        //  Array lists do not work with primitive variables
        ArrayList<Integer> nuts = new ArrayList<>(); //  <-- you can put a number to initialize capacity

        //  size and position doesn't matter
        nuts.add(202);
        nuts.add(52);
        nuts.add(80085);

        //  you can specify an index to insert out of order
        nuts.add(0, 2);

        //  change a number
        nuts.set(1, 306);

        //  traditional for loop rendition of printing every entry in an arraylist
        for (int i = 0; i < nuts.size(); i++){
            System.out.println(nuts.get(i));
        }

        //  pass an index to .remove() to remove
        nuts.remove(0);

        //  my nuts are empty
        nuts.clear();

        //  .isEmpty() does what you'd think
        if (nuts.isEmpty()) {
            System.out.println("My nuts are empty :(");
        } else {
            System.out.println("Deez nuts");
        }

        //  size of an array list is found with .size()
        int size = nuts.size();

        //  (type)[] (name) = {(value), (value)};
        int[] numbers = {5, 10, 15, 20, 25, 30, 35, 40};

        //  Prints out each number in the array
        for (int i = 0; i < numbers.length; i++){
            System.out.println("Number " + (i + 1) + " is " + numbers[i] + ".");
        }

        //  (type)[] (name) = new (type)[(length)];
        int[] userNumbers = new int[5];

        //  Prompts the user to enter an integer for each value in the array
        for (int i = 0; i < userNumbers.length; i++){
            do {
                System.out.println("Enter an integer between -10, and 10: ");
                userNumbers[i] = scan.nextInt();
                if (userNumbers[i] > 10 || userNumbers[i] < -10){
                    System.out.println("Integer must be between -10, and 10.");
                }
            } while (userNumbers[i] > 10 || userNumbers[i] < -10);
        }

        //  Prints out each number in the array
        for (int i = 0; i < userNumbers.length; i++){
            System.out.println("Number " + (i + 1) + " is " + userNumbers[i] + ".");
        }

        //  Array of Strings
        String[] days = {
                "Sunday",
                "Monday",
                "Tuesday",
                "Wednesday",
                "Thursday",
                "Friday",
                "Saturday"
        };

        //  Prints out each day of the week - using a foreach loop
        for (String day : days){
            System.out.println(day);
        }

        // iterates over numbers repopulating it
        for (int i = 0; i < numbers.length; i++){
            numbers[i] = i * 100;
        }

        //  prints out each changed number
        for (int num : numbers){
            System.out.println(num);
        }
    }
}
