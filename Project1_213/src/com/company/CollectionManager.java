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
    private Album newAlbum;
    private Album[] albums;
    private Collection collection = new Collection(albums, 0);

    public void run() {
        String inputString;
        System.out.println("Collection Manager starts running.");
        do
        {
            Scanner input = new Scanner(System.in);

            inputString = input.nextLine();
            tokenize(inputString);
            makeDate(date);
            makeGenre(genreString);
            newAlbum = new Album(albumName, artistName, genre, newDate, true);
            handleCommand(command);

        } while (!(inputString.equals("Q"))); // exits if input is Q

    }

    private void makeGenre(String genreString) 
    {
        if(genreString == null)
            return;
        genre = Genre.valueOf(genreString);
        //System.out.println("Made genre");
    }

    private void makeDate(String date)
    {
        if(date == null)
            return;
        newDate = new Date(date);
        //System.out.println("Made Date");
    }

    // seperate input string into different strings
    public void tokenize(String inputString)
    {
        StringTokenizer st1 = new StringTokenizer(inputString, ",");
        int count = st1.countTokens();

        if(count == 1)
        {
            command = st1.nextToken();
        }
        else if(count == 3)
        {
            command = st1.nextToken();
            albumName = st1.nextToken();
            artistName = st1.nextToken();
        }
        else
        {
            command = st1.nextToken();
            albumName = st1.nextToken();
            artistName = st1.nextToken();
            genreString = st1.nextToken();
            date = st1.nextToken();
        }

    }

    //  determine what action to take with the given command
    public void handleCommand(String command)
    {
        switch (command)
        {
            default:
                System.out.println("Invalid Command!");
            case "A":
                // add an album to collection
                collection.add(newAlbum);
                System.out.println(newAlbum + " >> added");
                break;
            case "D":
                // remove an album from collection
                collection.remove(newAlbum);
                break;
            case "L":
                // lend out an album
                collection.lendingOut(newAlbum);
                break;
            case "R":
                // return an album
                collection.returnAlbum(newAlbum);
                break;
            case "P":
                // display list of albums in collection no order
                if(collection.getNumAlbums() == 0){
                    System.out.println("The collection is empty!");
                    break; }
                collection.print();
                break;
            case "PD":
                // display list of albums in collection sort by release dates
                if(collection.getNumAlbums() == 0){
                    System.out.println("The collection is empty!");
                    break; }
                collection.printByReleaseDate();
                break;
            case "PG":
                // display list of albums in collection sort by the genre
                if(collection.getNumAlbums() == 0){
                    System.out.println("The collection is empty!");
                    break; }
                collection.printByGenre();break;

        }

    }
}
