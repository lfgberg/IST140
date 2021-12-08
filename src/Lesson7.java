package app;

/*
* Liam Geyer
* lfg5289@psu.edu
* IST140 - Lesson 7 Notes
 */

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static Object PrintWriter;

    /*
        This method is meant to print each element in an array.
        it'll throw an exception due to an out of bounds error
         */
    public static void printStringArray(String[] deez){
        for (int i = 0; i <= deez.length; i++){
            System.out.println(deez[i]);
        }
    }

    public static ArrayList<String> learningToReadFromAFile(){
        //  Path - relative to your src folder, location of the text file
        String path = "src/names.txt";

        //  Creating a fileName set to the path of the file
        File namesList = new File(path);

        //  .getAbsolutePath() can be useful to get information on what/why something is going wrong
        System.out.println(namesList.getAbsolutePath());

        //  Create an arraylist to populate with all the names from the file
        ArrayList<String> data = new ArrayList<>();

        Scanner input = null;
        try {
            //  Start reading from the file, create a scanner which reads from the file as opposed to the CLI
            input = new Scanner(namesList);

            //  Read each entire line of the file, and add it to the arraylist
            while (input.hasNext()){
                String temp = input.nextLine();
                data.add(temp);
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        } finally {
            /*  Close the file
                You don't have to worry about this with the scanner method used
                this is only required with the filereader method from zybooks
             */
            if (input != null){
                input.close();
            }
        }

        return data;
    }

    //  Returning a populated array when passing the path of the file to read from
    public static ArrayList<String> readFile(String path) throws Exception{
        ArrayList<String> data = new ArrayList<>();
        File fileName = new File(path);

        try {
            Scanner input = new Scanner(fileName);

            while (input.hasNext()){
                String temp = input.next();
                data.add(temp);
            }
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }

        return data;
    }

    //  Writes each line of an arraylist to a file
    public static void writeFile(String path, ArrayList<String> data) {
        PrintWriter pw = null;

        try {
            //  create a new printwriter with the file
            pw = new PrintWriter(path);

            // populate each line with the arraylist data
            for (String x : data){
                pw.println(x);
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        } finally {
            //  close the file
            if (pw != null){
                pw.close();
            }
        }
    }

    public static void main(String[] args) {
	    String[] deez = {"Moe", "Larry", "Curly"};

	    // Try/catch statements are usually used with i/o or asynchronous API communication
	    try {
	        //  Utilizes a try/catch statement to protect the code, anticipating errors
	        printStringArray(deez);
        } catch (Exception e) {
	        //  If there's an exception, run the following code
            System.out.println("Oopsie poopsie you did a whoopsie:\n" + e.getMessage());
            //  e.printStackTrace(); <-- Can be used to store/log/trace errors for later
            //  e.getMessage();
        } finally {
	        /*
	        This code block will run regardless of whether there's an exception
	        This can be used with API streams, can be used to always close a connection stream
	        Or can be used to always close a file when we're done reading from it
	         */
            System.out.println("The end");
        }

	    int nuts[] = new int[2];
	    int sum = 0;

	    try {
	     nuts[0] = 10;
	     nuts[1] = 20;
	     nuts[2] = 30;
	     sum = 50; // this line is never run; out of bounds
        } catch (ArrayIndexOutOfBoundsException e){
	        System.out.println(e);
        } finally {
	        sum = 50;
	        System.out.println(sum);
        }

	    //  populate the arraylist with the list of names
        ArrayList<String> names = new ArrayList<>();
	    try {
	        names = readFile("src/names.txt");
        } catch (Exception e){
	        System.out.println(e.getMessage());
        }

	    //  add some more name
        names.add("Carson Wentz");
	    names.add("Aaron Rodgers");
	    names.add("Ben Rothlkalkalkdlksdmflkslvm");

	    //  output the revised array to a file
        writeFile("src/out.txt", names);
    }
}
