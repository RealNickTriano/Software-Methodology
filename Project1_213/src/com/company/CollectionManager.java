/**
 * Handles user input/output to provide fluid interaction between user and program.
 * Provides feedback on user input and interacts with other classes to perform user requested actions.
 * Tokenizes user input to process the information, then makes a decision based on the tokens.
 * Various helper methods included.
 *
 * @author Nicholas Triano, Antonio Ignarra
 */
package com.company;

import java.util.Scanner;
import java.util.StringTokenizer;

public class CollectionManager {

    private String command, albumName, artistName, genreString, date;
    private Genre genre;
    private Date newDate;
    private boolean validDate = true;
    private Album newAlbum;
    private Album[] albums;
    private Collection collection = new Collection(albums, 0);

    public void run() {
        String inputString;
        System.out.println("Collection Manager starts running.");
        do {
            Scanner input = new Scanner(System.in);

            inputString = input.nextLine();
            tokenize(inputString);
            makeDate(date);
            if (validDate) {
                makeGenre(genreString);
                newAlbum = new Album(albumName, artistName, genre, newDate, true);
                handleCommand(command);
            } else
                validDate = true;
        } while (!(inputString.equals("Q"))); // exits if input is Q

    }

    private void makeGenre(String genreString) {
        if (genreString == null)
            return;
        genre = Genre.valueOf(genreString);
        //System.out.println("Made genre");
    }

    private void makeDate(String date) {
        if (date == null)
            return;
        newDate = new Date(date);
        if (!newDate.isValid()) {
            System.out.println("Invalid Date!");
            validDate = false;
        }
    }

    // seperate input string into different strings
    private void tokenize(String inputString) {
        StringTokenizer st1 = new StringTokenizer(inputString, ",");
        int count = st1.countTokens();

        if (count == 1) {
            command = st1.nextToken();
        } else if (count == 3) {
            command = st1.nextToken();
            albumName = st1.nextToken();
            artistName = st1.nextToken();
        } else {
            command = st1.nextToken();
            albumName = st1.nextToken();
            artistName = st1.nextToken();
            genreString = st1.nextToken();
            date = st1.nextToken();
        }

    }

    //  determine what action to take with the given command
    private void handleCommand(String command) {
        boolean error;
        switch (command) {
            default:
                printCommand(command);
            case "A":
                // add an album to collection
                error = collection.add(newAlbum);
                if (!error)
                    System.out.println(newAlbum + " >> is already in the collection.");
                else
                    System.out.println(newAlbum + " >> added.");
                break;
            case "D":
                // remove an album from collection
                error = collection.remove(newAlbum);
                if (!error)
                    System.out.println(newAlbum.getTitle() + newAlbum.getArtist()
                            + ">> is not in the collection");
                else
                    System.out.println(newAlbum.getTitle() + newAlbum.getArtist()
                            + ">> deleted.");
                break;
            case "L":
                // lend out an album
                error = collection.lendingOut(newAlbum);
                if (!error)
                    System.out.println(newAlbum.getTitle() + newAlbum.getArtist()
                            + ">> is not available");
                else
                    System.out.println(newAlbum.getTitle() + newAlbum.getArtist()
                            + ">> lending out and set to not available");
                break;
            case "R":
                // return an album
                error = collection.returnAlbum(newAlbum);
                if (!error)
                    System.out.println(newAlbum.getTitle() + newAlbum.getArtist()
                            + ">> return cannot be completed.");
                else
                    System.out.println(newAlbum.getTitle() + newAlbum.getArtist()
                            + ">> returning and set to available.");
                break;


        }

    }

    private void printCommand(String command) {
        switch (command) {
            default:
                System.out.println("Invalid Command!");
                break;
            case "P":
                // display list of albums in collection no order
                if (collection.getNumAlbums() == 0) {
                    System.out.println("The collection is empty!");
                    break;
                } else
                    System.out.println("*List of albums in the collection.");
                collection.print();
                System.out.println("*End of list");
                break;
            case "PD":
                // display list of albums in collection sort by release dates
                if (collection.getNumAlbums() == 0) {
                    System.out.println("The collection is empty!");
                    break;
                } else
                    System.out.println("*Album collection by the release dates.");
                collection.printByReleaseDate();
                System.out.println("*End of list");
                break;
            case "PG":
                // display list of albums in collection sort by the genre
                if (collection.getNumAlbums() == 0) {
                    System.out.println("The collection is empty!");
                    break;
                } else
                    System.out.println("*Album collection by genre.");
                collection.printByGenre();
                System.out.println("*End of list");
                break;
        }
    }
}
