package app;

/*
* Liam Geyer
* lfg5289@psu.edu
* IST140 - PassRush PA
 */

import java.util.Scanner;

public class Main {

    public static int[][] populateTable(Scanner scan){
        //  Create an array to store the yards
        int[][] yards = new int[4][2];

        //  Iterate through each row
        for (int i = 0; i < yards.length; i++){
            System.out.println("Enter data for quarter " + (i + 1));

            do {
                //  Prompt user for input
                System.out.println("Enter passing yards: ");
                yards[i][0] = scan.nextInt();
                System.out.println("Enter rushing yards: ");
                yards[i][1] = scan.nextInt();

                //  You can't run negative yards
                if (yards[i][0] <= 0 || yards[i][1] <= 0){
                    System.out.println("Please enter a value greater than 0.");
                }
            } while (yards[i][0] <= 0 || yards[i][1] <= 0);
        }

        return yards;
    }

    public static int[] getTotalYards(int[][] yards){
        //  Create an array to store the totals
        int[] totalYards = new int[2];

        //  Iterate through each quarter
        for (int i = 0; i < yards.length; i++){
            //  Add each column to the appropriate total
            totalYards[0] = totalYards[0] + yards[i][0];
            totalYards[1] = totalYards[1] + yards[i][1];
        }

        return totalYards;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //  Populate 2D array with yards from each quarter
        int[][] yards = populateTable(scan);

        //  Get total values
        int[] totalYards = getTotalYards(yards);

        //  Output the final values
        System.out.println("At the end of the game the total passing yards was " + totalYards[0] + " and the total rushing yards was " + totalYards[1] + ".");

    }
}
