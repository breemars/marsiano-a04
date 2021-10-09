package Solution41;
/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Breanna Marsiano
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution41 {
    /*
    Sorting Names from a File
    - Read names from the input file
    - store all the names in an arraylist
    - sort the array list alphabetically
    - print the arraylist into a new output file
    */
    public static void main(String[] args) throws IOException {
        //Read data into a list of strings
        List<String> names = readData();

        //Sort data by last name
        Collections.sort(names);

        //Write new list to file
        writeData(names);
    }

    //Read data from file into list
    public static List<String> readData() throws FileNotFoundException {
        List<String> names = new ArrayList<>();
        File file = new File("data//exercise41_input.txt");
        Scanner reader = new Scanner(file);

        while (reader.hasNextLine()) {
            String data = reader.nextLine();
            names.add(data);
        }

        reader.close();
        return names;
    }

    //Write new data from list to file
    private static void writeData(List<String> names) throws IOException {

        try (FileWriter writer = new FileWriter("data//exercise41_output.txt")) {
            writer.write("Total of " + names.size() + " names\n-----------------\n");
            for (String x : names)
                writer.write(x + "\n");
        }
    }

}
