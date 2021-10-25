package app;

/*
* Liam Geyer
* lfg5289@psu.edu
* IST140 - FootballSlicer Exercise
 */

import java.util.ArrayList;

public class Main {

    //  Method to print out the arrayList
    public static void printRanking(ArrayList<String> topTen){
        for (int i = 0; i < topTen.size(); i++){
            System.out.println((i + 1) + ". " + topTen.get(i));
        }
    }

    public static void main(String[] args) {

        //  Create an arrayList and populate it with teams
        ArrayList<String> topTen = new ArrayList<String>(10);
        topTen.add("Georgia");
        topTen.add("Cincinnati");
        topTen.add("Oklahoma");
        topTen.add("Alabama");
        topTen.add("Ohio State");
        topTen.add("Michigan");
        topTen.add("Penn State");
        topTen.add("Oklahoma State");
        topTen.add("Michigan State");
        topTen.add("Oregon");

        System.out.println("Week 8 Top 10:");
        printRanking(topTen);

        topTen.set(2, "Alabama");
        topTen.set(3, "Oklahoma");

        topTen.remove(6);
        topTen.set(6, "Oregon");

        topTen.remove(7);
        topTen.set(7, "Michigan State");

        topTen.add(8, "Iowa");

        topTen.add("Ole Miss");

        System.out.println("\nWeek 9 Top 10:");
        printRanking(topTen);

    }
}
