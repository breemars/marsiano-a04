package Solution42;
/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Breanna Marsiano
 */
import java.io.*;
import java.util.*;

public class Solution42 {
    /*
    Parsing a Data File
    - Read data from the input file
    - Break data apart by commas
    - store all the data in an arraylist
    - print out the arraylist into a table
    */
    public static void main(String[] args) throws IOException {
        //Read data into a list of strings
        List<String> data = readData();

        //Print the data out for the user
        printData(data);
    }

    //Read data from file into list, separating by commas and next line
    public static List<String> readData() throws IOException {
        List<String> data = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("data//exercise42_input.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                data.addAll(Arrays.asList(values));
            }
        }

        return data;
    }

    //Print out data in a table
    private static void printData(List<String> data) {
        System.out.printf("%-10s %-10s %-10s %n-----------------------------%n", "Last", "First", "Salary");
        for (int x = 0; x < data.size(); x += 3)
            System.out.printf("%-10s %-10s %-10s%n", data.get(x), data.get(x + 1), data.get(x + 2));
    }

}
