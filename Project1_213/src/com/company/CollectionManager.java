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

    /**
     * The main method in this class, calls helper methods to handle user input/output.
     * Uses Scanner imported class to take user input adn then calls helper method to tokenize
     * Will check for valid date before checking command or making an album
     * Exits when key input "Q" is entered.
     */
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

    /**
     * Creates a genre enum from the string
     * @param genreString String input by user
     */
    private void makeGenre(String genreString) {
        if (genreString == null)
            return;
        genre = Genre.valueOf(genreString.toLowerCase());
    }

    /**
     * Creates date object from string
     * @param date String input by user
     */
    private void makeDate(String date) {
        if (date == null)
            return;
        newDate = new Date(date);
        if (!newDate.isValid()) {
            System.out.println("Invalid Date!");
            validDate = false;
        }
    }

    /**
     * Separate input string into different strings
     * @param inputString The whole line of input from user
     */
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

    /**
     * Determine what action to take with the given command, Checks printCommand method if nothing matches
     * "A" adds an album to the Collection
     * "D" deletes an album to the Collection
     * "L" lend an album out to a friend
     * "R" returns an album to a friend
     * @param command String entered by user
     */
    private void handleCommand(String command) {
        boolean error;
        switch (command) {
            default:
                printCommand(command);
                break;
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
                            + " >> deleted.");
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

    /**
     * Determines the order to print Collection from the given command, "Invalid command" is output if nothing matches
     * "P" prints album in current order
     * "PD" prints album in order based on date
     * "PG" prints album in order based on genre
     * @param command String entered by user
     */
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
