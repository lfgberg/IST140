package app;

/*
* Liam Geyer
* lfg5289@psu.edu
* IST140 - StringLength Exercise
 */

public class Main {

    public static void main(String[] args) {

        //  Declare and initialize favorite foods
        String favoriteFoods = "My three favorite foods are ";
        String[] foods = {"Sushi", "Malasadas", "Noodles"};

        //  Concatenate favorite foods, can be done with either method
        //  favoriteFoods = (favoriteFoods + foods[0] + ", " + foods[1] + ", and " + foods[2] + ".");
        favoriteFoods = favoriteFoods.concat(foods[0] + ", " + foods[1] + ", and " + foods[2] + ".");
        System.out.println(favoriteFoods);

        //  Print the length of the string
        System.out.println("The length of the string is " + favoriteFoods.length() + " characters.");
    }
}
