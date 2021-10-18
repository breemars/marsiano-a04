package Solution44;
/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Breanna Marsiano
 */

import com.google.gson.Gson;

import java.io.*;
import java.util.*;

public class Solution44 {
    /*
    Product Search and JSON
    - read product data from JSON file into a list of strings
    - turn list of strings to list of objects using GSON
    - prompt user for a product name
    - search for product in list of objects
    - if found, print product info and exit
    - if not, keep asking for a name until one found
    */
    public static void main(String[] args) throws IOException {

        //Get data from json file into a list of objects
        List<String> data = readData();
        List<Products> productsList = objectList(data);

        //Ask user for product name and search for it
        Scanner input = new Scanner(System.in);
        while(true){
            System.out.print("What is the product name? ");
            String name = input.next();
            if(searchProduct(productsList, name))
                break;
            System.out.println("Sorry, that product was not found in our inventory.");
        }
    }

   //Turn list of strings to list of objects using gson
   public static List<Products> objectList(List<String> data){
       List<Products> productsList = new ArrayList<>();
       Gson gson = new Gson();

       for(String x : data)
           productsList.add(gson.fromJson(x, Products.class));

       return productsList;
   }

   //Search for a product in list of objects, print when found
   public static boolean searchProduct(List<Products> productsList, String name) {
        for (Products x : productsList) {
            if(x.getName().equals(name)) {
                System.out.println("Name: " + x.getName() + "\nPrice: " + x.getPrice() + "\nQuantity: " + x.getQuantity());
                return true;
            }
        }
        return false;
   }

    //Read data from json file into a list of strings
    public static List<String> readData() throws IOException {
        List<String> data = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("data//exercise44_input.json"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if(line.startsWith("    {")) {
                    if(line.charAt(line.length() - 1) == ',')
                        line = line.substring(0, line.length() - 1);
                    data.add(line);
                }
             }
        }
        return data;
    }



}
