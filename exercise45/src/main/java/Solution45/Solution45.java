package Solution45;
/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Breanna Marsiano
 */

import java.io.*;
import java.util.*;

public class Solution45 {
    /*
    Word Finder
    - get the name out output file from user
    - import the input file line by line
    - search for the search word in each line
    - replace with the new word if found
    - store the new line in a list of strings
    - output the finished list of strings to a new file named by the user
    */
    public static void main(String[] args) throws IOException {

        //Get output file name
        Scanner input = new Scanner(System.in);
        System.out.print("What is the name of the output file? ");
        String output = input.next();

        //Create new file
        List<String> data = readData("utilize", "use");
        writeData(data, output);
        
    }

    //Switch the words and read data from file into list
    public static List<String> readData(String search, String replace) throws IOException {
        List<String> names = new ArrayList<>();
        File file = new File("data//exercise45_input.txt");
        Scanner reader = new Scanner(file);

        while (reader.hasNextLine()) {
            String data = reader.nextLine();

            //If word found, replace in the line
            for(int x = 0; x < data.length() - search.length(); x++) {
                if (data.startsWith(search, x))
                   data = data.substring(0, x) + replace + data.substring(x + search.length());
            }
            names.add(data);
        }
        reader.close();
        return names;
    }

    //Write new data from list to file
    public static void writeData(List<String> data, String output) throws IOException {

        try (FileWriter writer = new FileWriter("data//" + output + ".txt")) {
            for (String x : data)
                writer.write(x + "\n");
        }
    }

}
