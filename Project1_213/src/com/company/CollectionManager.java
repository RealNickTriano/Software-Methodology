/**
 * @author Nicholas Triano
 * @author Antonio Ignarra
 */
package com.company;
import  java.util.Scanner;
import java.util.StringTokenizer;

public class CollectionManager {

    private String command, albumName, artistName, genreString, date;
    private Genre genre;
    private Date newDate;

    public void run() {
        String inputString;
        do
        {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter Info");

            inputString = input.nextLine();
            tokenize(inputString);
            makeDate(date);
            makeGenre(genreString);
            makeAlbum(albumName, artistName, genre, newDate);
            handleCommand(command);

        } while (inputString.equals("Q")); // exits if input is Q

    }

    private void makeGenre(String genreString) 
    {
        genre = Genre.valueOf(genreString);
        System.out.println("Made genre");
    }

    private void makeDate(String date)
    {
        newDate = new Date(date);
        System.out.println("Made Date");
    }

    // seperate input string into different strings
    public void tokenize(String inputString)
    {
        StringTokenizer st1 = new StringTokenizer(inputString, ",");

        command = st1.nextToken();
        albumName = st1.nextToken();
        artistName = st1.nextToken();
        genreString = st1.nextToken();
        date = st1.nextToken();

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
        System.out.println(newAlbum);

        return newAlbum;
    }

}
