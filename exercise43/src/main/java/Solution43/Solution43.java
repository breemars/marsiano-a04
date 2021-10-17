package Solution43;
/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Breanna Marsiano
 */
import java.io.*;
import java.util.*;

public class Solution43 {
    /*
    Website Generator
    - get website info from user
    - create website and main directories
    - create index.html and write name and author of site
    - if wanted, create js folder
    - if wanted, create css folder
    */
    public static void main(String[] args) throws IOException {

        //Get user input
        Scanner input = new Scanner(System.in);
        System.out.print("Site name: ");
        String name = input.next();
        input.nextLine();
        System.out.print("Author: ");
        String author = input.nextLine();
        System.out.print("Do you want a folder for JavaScript? ");
        String js = input.next();
        System.out.print("Do you want a folder for CSS? ");
        String css = input.next();

        //Create index.html
        createHTML(name, author);

        //Create js and css folders
        if(js.equalsIgnoreCase("y"))
            createDirectory(name, "js");
        if(css.equalsIgnoreCase("y"))
            createDirectory(name, "css");
    }

    //Create Directories
    public static void createDirectory(String dirName, String folderName) {
        boolean file = new File("data//website//" + dirName + "//" + folderName).mkdir();
        if(file)
            System.out.println("Created ./website/" + dirName + "/" + folderName);
        else
            System.out.println("ERROR Creating " + "./website/" + dirName + "/" + folderName);
    }

    //Create index.html folder and call function to create necessary folders
    public static void createHTML(String name, String author) throws IOException {
        //Create directories
        new File("data//website").mkdir();
        createDirectory(name, "");

        //Create index.html
        try (FileWriter writer = new FileWriter("data//website//" + name + "//index.html")) {
            writer.write("<title>" + name + "</title>\n");
            writer.write("<meta>" + author + "</meta>");
            System.out.println("Created ./website/" + name + "/index.html");
        }
    }

}
