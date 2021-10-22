package app;

/*
* Liam Geyer
* lfg5289@psu.edu
* IST140 - Hello Mars Exercise
 */

public class Main {

    public static void main(String[] args) {
        // Outputs "Greetings Martians!"
        System.out.print("Greetings ");
        System.out.print("Martians");
        System.out.println("!");

        // Outputs "Take me to your BLANK"
        System.out.print("Take me to your " + args[0]); // <-- BLANK is set via the configuration menu
    }
}
