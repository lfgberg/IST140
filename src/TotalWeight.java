package app;

/*
* Liam Geyer
* lfg5289@psu.edu
* IST140 - TotalWeight Exercise
 */

public class Main {

    public static void main(String[] args) {

        int weightOfLoaf = 16; //ounces per loaf
        int numberOfLoaves = 4;

        System.out.print("With a weight of " + weightOfLoaf + " ounces in each loaf, "); // <-- This statement was lacking a semicolon
        System.out.println("and a total of " + numberOfLoaves + " loaves, ");

        // This statement had a logical error, changed "+" to "*", adding the number of loaves to the weight doesn't give you the total weight, you need to multiply
        int totalWeight = weightOfLoaf * numberOfLoaves;

        System.out.println("the total weight of all " + numberOfLoaves + " loaves is " + totalWeight + " ounces.\n");
    }
}
