package app;

/*
* Liam Geyer
* lfg5289@psu.edu
* IST140 - MultiTable Exercise
 */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

	Scanner scan = new Scanner(System.in);
	int min;
	int max;
	String header = "";
	String dashes = "";

	//  Input collection and validation loop
	do {
	    //  Prompt for user input
        System.out.println("Enter an integer greater than 0: ");
        min = scan.nextInt();
        System.out.println("Enter an integer greater than the first, but less than 20: ");
        max = scan.nextInt();

        //  Provide feedback on improper inputs
        if (min <= 0){
            System.out.println("The first integer must be greater than 0.");
        }
        if (max < min){
            System.out.print("The second integer must be larger than the first");
        }
        if (max >= 20){
            System.out.println("The second integer must be less than 20.");
        }
    } while (min <= 0 || max < min || max >= 20);

    //  Create a table header
    for (int i = min; i <= max; i++) {
        header = header.concat("\t" + i + "\t");
        //  One tab is 8 characters, concat 8 dashes per column
        dashes = dashes.concat("========");
    }

    //  Print the table header
    System.out.println(header);
    System.out.println(dashes);

	//  iterate from min to max
	for (int i = min; i <= max; i++){

	    for (int j = min; j <= max; j++){
	        System.out.print("\t" + (i * j) + "\t");
        } //  <-- end of j loop

        //  line break to end each row
        System.out.print("\n");
    } //  <-- end of i loop
    }
}
