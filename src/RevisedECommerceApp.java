package app;

/*
* Liam Geyer
* lfg5289@psu.edu
* IST140 - EcommerceAppMK.1 revised version
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void bannerPrinter(){
        //  Print the banner
        System.out.println("******************************************");
        System.out.println("====== Welcome to my eCommerce app! ======");
        System.out.println("******************************************\n");
    }

    public static ArrayList<String> productsBuilder(){
        ArrayList<String> products = new ArrayList<>();

        //  Add all the products
        products.add("pen");
        products.add("chair");
        products.add("desk");
        products.add("monitor");
        products.add("keyboard");
        products.add("mouse");

        return products;
    }

    public static ArrayList<Double> priceBuilder(ArrayList<String> products){
        ArrayList<Double> prices = new ArrayList<>();

        //  Add a random price for each product
        for (int i = 0; i < products.size(); i++){
            prices.add(Math.random() * 100 + 1);
        }

        return prices;
    }

    public static void productTable(ArrayList<String> products, ArrayList<Double> prices){
        //  Loop through each product
        for (int i = 0; i < products.size(); i++){
            //  Display the product name and formatted price
            System.out.print(products.get(i) + " - ");
            System.out.printf("$%.2f\n", prices.get(i));
        }
    }

    public static int hasOrder(Scanner scan, ArrayList<String> products){
        //  Prompt the user for input
        System.out.println("\nEnter a product name: ");
        String input = scan.nextLine();

        //  Check whether or not the product is in the catalog, return appropriate value
        if (products.contains(input.toLowerCase())){
            return products.indexOf(input.toLowerCase());
        } else return -1;
    }

    public static double getPrice(int index, ArrayList<Double> prices){
        //  fetch price if index isn't -1
        if (index == -1){
            return 0;
        } else return prices.get(index);
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
    public static void printTotal(double total, double price, double tax){
        System.out.printf("The sales total is: $%.2f, or $%.2f with $%.2f in tax.", total, price, tax);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //  Print the banner image
        bannerPrinter();

        //  Generate prices and products
        ArrayList<String> products = productsBuilder();
        ArrayList<Double> prices = priceBuilder(products);

        //  Diplay products
        productTable(products, prices);

        //  Get order
        int order = hasOrder(scan, products);

        //  Give feedback on invalid orders
        if (order == -1){
            System.out.println("I'm sorry, we couldn't find the product you requested.");
        } else {
            //  Calculate pricing information
            double price = getPrice(order, prices);
            double tax = getTax(price);
            double total = getTotal(price, tax);

            //  Display final total
            printTotal(total, price, tax);
        }
    }
}
