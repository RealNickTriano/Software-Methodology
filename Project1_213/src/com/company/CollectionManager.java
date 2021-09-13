/**
 * @author Nicholas Triano
 * @author Antonio Ignarra
 */
package com.company;
import  java.util.Scanner;
import java.util.StringTokenizer;

public class CollectionManager {

    private String command, albumName, artistName, genre, date;

    public void run() {
        String inputString;
        do
        {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter Info");

            inputString = input.nextLine();
            tokenize(inputString);
            handleCommand(command);

        } while (inputString.equals("Q")); // exits if input is Q

    }

    // seperate input string into different strings
    public void tokenize(String inputString)
    {
        StringTokenizer st1 = new StringTokenizer(inputString, ",");

        command = st1.nextToken();
        albumName = st1.nextToken();
        artistName = st1.nextToken();
        genre = st1.nextToken();
        date = st1.nextToken();
        // System.out.println(command + " " + albumName + " " + artistName + " " + genre + " " + date);

    }

    //  determine what action to take with the given command
    public void handleCommand(String command)
    {
        switch (command)
        {
            case "A":
                // add an album to collection
            case "D":
                // remove an album from collection
            case "L":
                // lend out an album
            case "R":
                // return an album
            case "P":
                // display list of albums in collection no order
            case "PD":
                // display list of albums in collection sort by release dates
            case "PG":
                // display list of albums in collection sort by the genre

        }

    }

    public Album makeAlbum(String albumName, String artistName, Genre genre, Date date)
    {
        Album newAlbum = new Album(albumName, artistName, genre, date, true);

        return newAlbum;
    }

}
