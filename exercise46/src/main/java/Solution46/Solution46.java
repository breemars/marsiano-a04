package Solution46;
/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Breanna Marsiano
 */

import java.io.*;
import java.util.*;

public class Solution46 {
    /*
    Word Frequency Finder
    - go through the input file word by word
    - keep track of how many words there are using a map
    - the key is the word and the value how many there are
    - switch the values and keys into a new TreeMap to sort the data
    - print out the results in a table format for the user
    */
    public static void main(String[] args) throws IOException {

        //Get a map of the count of each word
        Map<String, Integer> map = countWords();

        //Print the results
        printTable(map);
    }

    //Print out results in a table format
    private static void printTable(Map<String, Integer> map) {

        //Convert the map to a TreeMap and switch values and keys to sort descending
        TreeMap<Integer, String> sortedMap = new TreeMap<>(Collections.reverseOrder());
        for (Map.Entry<String, Integer> pair: map.entrySet()){
            sortedMap.put(pair.getValue(), pair.getKey());
        }

        //Print results
        for (Map.Entry<Integer, String> pair: sortedMap.entrySet()) {
            System.out.printf("%n%-10s: ", pair.getValue());
            for(int x = 0; x < pair.getKey(); x++)
                System.out.print("*");
        }
        System.out.println();
    }

    //Read each word of the file and count how many there are
    public static Map<String, Integer> countWords() throws IOException {
        Map<String, Integer> map = new HashMap<>();
        File file = new File("data//exercise46_input.txt");
        Scanner reader = new Scanner(file);

        while (reader.hasNext()) {
            String word = reader.next();

            if(wordInMap(word, map))
                map.replace(word, map.get(word) + 1);
            else
                map.put(word, 1);
        }
        reader.close();
        return map;
    }


    //Return true if the word is already in the map
    public static boolean wordInMap(String word, Map<String, Integer> map) {
        for(String x : map.keySet())
            if(x.equals(word))
                return true;
        return false;
    }


}
