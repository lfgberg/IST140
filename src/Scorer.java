package app;

/*
* Liam Geyer
* lfg5289@psu.edu
* IST140 - Scorer PA
 */

import java.util.Scanner;

public class Main {

    public static double[][] getDoubles(Scanner scan){
        //  Create a 2 dimensional array for input
        double[][] input = new double[3][3];

        //  Iterate through each row/col
        for (int i = 0; i < input.length; i++){
            for (int j = 0; j < input[i].length; j++){

                //  Prompt user for input
                do {
                    System.out.println("Enter a double between -100, and 100: ");
                    input[i][j] = scan.nextDouble();
                    if (input[i][j] > 100 || input[i][j] < -100){
                        System.out.println("Double must be between -100, and 100.");
                    }
                } while (input[i][j] > 100 || input[i][j] < -100);
            }
        }

        //  Return populated 2D array
        return input;
    }

    public static double[] getAverage(double[][] input){
        //  Create an array to store the averages
        double[] averages = new double[3];

        //  Iterate through each row/col
        for (int i = 0; i < input.length; i++){
            for (int j = 0; j < input[i].length; j++){
                //  add each entry to the averages[] entry for its row
                averages[i] = averages[i] + input[i][j];
            }
        }

        //  Divide each total by 3 to make it an average
        for (int i = 0; i < averages.length; i++){
            averages[i] = averages[i] / 3;
        }

        //  Return averages
        return averages;
    }

    public static void printAverages(double[] averages){
        //  Iterate through each entry
        for (int i = 0; i < averages.length; i++){

            //  Print the averages formatted to .2
            System.out.printf("The average of row %d is %.2f\n", (i + 1), averages[i]);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //  go go power rangers
        printAverages(getAverage(getDoubles(scan)));
    }
}
