package app;

/*
* Liam Geyer
* lfg5289@psu.edu
* IST 140 - AverageCalculator Exercise
 */

public class Main {

    public static void main(String[] args) {
    	//  Declare and Initialize 3 variables to average
	    double a = 2.3893;
	    double b = 4.9202;
	    double c = 6.4847;

	    //  Average the numbers
	    double avg = (a + b + c) / 3;

	    //  Print the average, formatted to 2 decimals
		System.out.printf("The average of numbers %.2f, %.2f, and %.2f is %.2f", a, b, c, avg);
    }
}
