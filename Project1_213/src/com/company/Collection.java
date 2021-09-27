/**
 * The collection where Album objects are added into, methods here operate on the collection.
 * Can find, add, remove, lendOut, and return Albums in the collection.
 * Can grow and print the collection to the user based on their sorted preference.
 *
 * @author Nicholas Triano, Antonio Ignarra
 */
package com.company;

public class Collection {

    // instance variables
    private Album[] albums;
    private int numAlbums; //number of albums currently in the collection


    /**
     * Constructor for Collection class creates a new Collection object with given parameters
     * @param albums An array of the albums currently in the collection
     * @param numAlbums The number of albums in the collection
     */
    public Collection(Album[] albums, int numAlbums) {
        this.albums = albums;
        this.numAlbums = numAlbums;
    }

    /**
     * Allows other classes to retrieve the number of albums
     * @return the number of albums currently in the collection
     */
    public int getNumAlbums() {return numAlbums;}

    /**
     * Finds the given album's index, or returns NOT_FOUND
     * @param album The requested album
     * @return The index of the album requested
     */
    private int find(Album album)
    {
        int i;
        for (i = 0; i < numAlbums; i++) {
            if (albums[i].equals(album)) {
                return i;
            }
        }
        return Constants.NOT_FOUND;
    }

    /**
     * Increase the capacity of the array list by 4
     */
    private void grow()
    {
        Album[] newAlbumArr = new Album[numAlbums + 4];
        // copy over albums in the current collection to the collection w/ updated size
        for (int i = 0; i < numAlbums; i++) {
            newAlbumArr[i] = albums[i];
        }
        albums = newAlbumArr;
    }

    /**
     * Adds an album to the collection
     * @param album The album to be added to the collection
     * @return false if the collection already contains the given album, true if the album was successfully added
     */
    public boolean add(Album album) {
        if (find(album) != Constants.NOT_FOUND)
            return false;
        if (numAlbums == 0) {
            this.grow();
        } else if (numAlbums >= albums.length) {
            this.grow();
        }
        albums[numAlbums] = album;
        numAlbums++;
        return true;
    }

    /**
     * Removes an album from the collection
     * @param album the album to be removed from the collection
     * @return false if the album is not in the collection, true if the album is successfully removed
     */
    public boolean remove(Album album) {
        // find the index of the album to be removed
        int i = find(album);
        // check if requested album is in the collection
        if (i == Constants.NOT_FOUND) {
            return false;
        }
        // remove album
        else {
            for (; i < numAlbums; i++) {
                // if at last space in current capacity
                if (i == albums.length - 1) {
                    Date date = new Date("12/25/2030");
                    albums[i] = new Album("none", "none", Genre.unknown, date, true);
                } else {
                    albums[i] = albums[i + 1];
                }
            }
        }
        numAlbums--;
        return true;
    }

    /**
     * Lends out an album and sets the album's availability to unavailable if eligible
     * @param album the album to lend out
     * @return true if album is successfully lent out, false otherwise
     */
    public boolean lendingOut(Album album)
    {
        // if already not available return false for error
        if (!(album.getIsAvailable())) {
            return false;
        }
        album.setIsAvailable(false);
        return true;
    }

    /**
     * Returns an album and sets the album's availability to available if eligible
     * @param album the album being returned
     * @return true if album is successfully returned, false otherwise
     */
    public boolean returnAlbum(Album album) //set to available
    {
        // if already available return false for error
        if (album.getIsAvailable()) {
            return false;
        }
        album.setIsAvailable(true);
        return true;
    }

    /**
     * Display the list without specifying the order
     */
    public void print()
    {
        for (int i = 0; i < numAlbums; i++) {
            System.out.println(albums[i]);
        }
    }

    /**
     * Display the list in order of release dates
     */
    public void printByReleaseDate() {
        Album[] newAlbums = new Album[numAlbums];
        Date date = new Date("12/25/2030");
        Collection col = new Collection(newAlbums, 0);

        for (int j = 0; j < numAlbums; j++) {
            Album lessAlbum = new Album("none", "none", Genre.unknown, date, true);
            for (int i = 0; i < numAlbums; i++) {
                if (albums[i].getDate().compareTo(lessAlbum.getDate()) == -1) {
                    if (col.find(albums[i]) == Constants.NOT_FOUND)
                        lessAlbum = albums[i];
                }
            }
            col.add(lessAlbum);
        }

        this.albums = col.albums;
        this.print();
    }

    /**
     * Display the list sorted by genres
     */
    public void printByGenre() {
        Album[] sortedAlbums = new Album[numAlbums];
        int j = 0;
        // copy over albums into sorted[] by genre
        for (int i = 0; i < numAlbums; i++){
            if (albums[i].getGenre() == Genre.classical){
                sortedAlbums[j] = albums[i];
                j++;
            }
        }
        for (int i = 0; i < numAlbums; i++){
            if (albums[i].getGenre() == Genre.country){
                sortedAlbums[j] = albums[i];
                j++;
            }
        }
        for (int i = 0; i < numAlbums; i++){
            if (albums[i].getGenre() == Genre.jazz){
                sortedAlbums[j] = albums[i];
                j++;
            }
        }
        for (int i = 0; i < numAlbums; i++){
            if (albums[i].getGenre() == Genre.pop){
                sortedAlbums[j] = albums[i];
                j++;
            }
        }
        for (int i = 0; i < numAlbums; i++){
            if (albums[i].getGenre() == Genre.unknown){
                sortedAlbums[j] = albums[i];
                j++;
            }
        }
        // copy over sorted and print
        albums = sortedAlbums;
        for (int i = 0; i < numAlbums; i++){
            System.out.println(albums[i]);
        }
    }

}