package app;

/*
* Liam Geyer
* lfg5289@psu.edu
* IST140 - ECommerceApp PA
 */

import java.util.Scanner;

public class Main {

    public static void bannerPrinter(){
        //  Print the banner
        System.out.println("******************************************");
        System.out.println("====== Welcome to my eCommerce app! ======");
        System.out.println("******************************************\n");
    }

    public static String productsBuilder(){
        //  return a comma delineated list of products? I don't really get the purpose of this method
        //  I'm assuming that I'm misinterpreting this because it doesn't even display nicely...
        //  Wouldn't it be better to have this as an array and then print it as like a bulleted list?
        return "Keyboard  Monitor   Mouse     ";
    }

    public static boolean getOrder(Scanner scan, String products){
        //  Print the products catalog
        System.out.println(products);

        //  Prompt the user for input
        System.out.println("Enter a product name: ");
        String input = scan.nextLine();

        //  Check whether or not the product is in the catalog, return appropriate value
        return products.toLowerCase().contains(input.toLowerCase());
    }

    public static double getPrice(){
        //  Generate random price
        return (Math.random() * 100 + 1);
    }

    public static double getTax(double price){
        //  Calculate/return tax
        return (price * .1);
    }

    //  I feel like tax and total can prob be combined they're both very light methods
    public static double getTotal(double price, double tax){
        //  Return total
        return price + tax;
    }

    //  I think this should be done in main.
    public static void printTotal(double total){
        System.out.printf("Your total is: $%.2f.", total);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //  Print the banner image
        bannerPrinter();

        //  Get the products catalog string
        String catalog = productsBuilder();

        //  Get the users order and check if it exists
        boolean order = getOrder(scan, catalog);

        if (order){
            //  If the product exists, calculate the total.
            double price = getPrice();
            double tax = getTax(price);
            printTotal(getTotal(price, tax));
        } else {
            //  Provide feedback if the product isn't there
            System.out.println("The product was not found.");
        }
    }
}
