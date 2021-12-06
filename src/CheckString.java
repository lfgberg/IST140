package app;

/*
* Liam Geyer
* lfg5289@psu.edu
* IST140 - CheckString Exercise
 */

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static ArrayList<String> readFile(String path) throws Exception {
        //  Create an arraylist to populate; create a new file with the passed path
        ArrayList<String> data = new ArrayList<>();
        File fileName = new File(path);

        try {
            //  Attempt to read from the file
            Scanner input = new Scanner(fileName);

            //  Read each line of the file into the arraylist
            while (input.hasNextLine()){
                String temp = input.nextLine();
                data.add(temp);
            }
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }

        //  Return the populated array
        return data;
    }

    public static void printList(ArrayList<String> data){
        //  Print each element of the arraylist to the CLI
        for (String x : data){
            System.out.println(x);
        }
    }

    public static void checkWord(String word) throws Exception{
        //  throw an exception if the first char of the word is not a letter
        if (!Character.isAlphabetic(word.charAt(0))){
            throw new Exception("This is not a word.");
        }
    }

    public static ArrayList<String> addWord(Scanner scan, ArrayList<String> data){
        //  Prompt the user for input
        System.out.println("Enter a word to add:");
        String input = scan.nextLine();

        //  Check whether or not the word is valid; add to the arraylist
        try {
            checkWord(input);
            data.add(input);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return data;
    }

    public static void writeFile(ArrayList<String> data, String path){
        PrintWriter out = null;

        try {
            //  Attempt to write each line of the array to out.txt
            out = new PrintWriter("out.txt");
            for (String x : data){
                out.println(x);
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        } finally {
            //  close the file
            if (out != null) {
                out.close();
            }
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String path = "src/list.txt";

        //  Create an arraylist; attempt to populate it from a file
        ArrayList<String> data = new ArrayList<>();
        try {
            data = readFile(path);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        //  Print the contents of the arraylist to the cli
        printList(data);

        boolean loop = true;
        while (loop){
            //  prompt the user for input
            System.out.println("Would you like to add a new word? (y/n)");
            String input = scan.nextLine();

            if (input.toLowerCase().equals("y")){
                addWord(scan, data);
            } else if (input.toLowerCase().equals("n")){
                System.out.println("Writing to a file.");
                writeFile(data, path);
                loop = false;
            } else {
                System.out.println("Please enter y/n.");
            }
        }
    }
}
