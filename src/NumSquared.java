package app;

/*
* Liam Geyer
* lfg5289@psu.edu
* IST140 - NumSquared Programming Assignment
 */

public class Main {

    public static void main(String[] args) {
        int num = 5; // <-- num was not initialized
        int numSquared;

        numSquared = num * num; // <-- changed "+" to "*"

        System.out.print(numSquared); // <-- userNumSquared is not a declared variable, changed to numSquared
    }
}
