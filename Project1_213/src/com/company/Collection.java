/**
 * @author Nicholas Triano
 * @author Antonio Ignarra
 */
package com.company;

public class Collection {

    // instance variables
    private Album[] albums;
    private int numAlbums; //number of albums currently in the collection

    // constructor
    public Collection(Album[] albums, int numAlbums) {
        this.albums = albums;
        this.numAlbums = numAlbums;
    }

    public int getNumAlbums()
    {
        return numAlbums;
    }

    private int find(Album album) //find the album index, or return NOT_FOUND
    {
        int i;
        for(i=0; i<numAlbums; i++){
            if (albums[i].equals(album)){
                return i;
            }
        }
        return Constants.NOT_FOUND;
    }

    private void grow() // increase the capacity of the array list by 4
    {
        Album[] newAlbumArr = new Album[numAlbums + 4];
        // copy over albums in the current collection to the collection w/ updated size
        for(int i=0; i<numAlbums; i++ ){
            newAlbumArr[i] = albums[i];
        }
        albums = newAlbumArr;
    }

    public boolean add(Album album)
    {
        if (numAlbums == 0) {
            this.grow();
        }
        else if (numAlbums >= albums.length) {
            this.grow();
        }
        albums[numAlbums] = album;
        numAlbums++;
        return true;
    }

    public boolean remove(Album album)
    {
        // find the index of the album to be removed
        int i = find(album);
        // check if requested album is in the collection
        if (i == Constants.NOT_FOUND){
            return false;
        }
        // remove album
        else{
            for(; i<numAlbums; i++){
                // if collection is at full capacity
                if (i == albums.length - 1){
                    Date date = new Date("12/25/2030");
                    albums[i] = new Album("none", "none", Genre.unknown, date, true);
                }
                else{
                    albums[i] = albums[i+1];
                }
            }
        }
        numAlbums--;
        return true;
    }

    public boolean lendingOut(Album album) //set to not available
    {
        // if already not available return false for error
        if(!(album.getIsAvailable()))
        {
            return false;
        }
        album.setIsAvailable(false);
        return true;
    }

    public boolean returnAlbum(Album album) //set to available
    {
        // if already available return false for error
        if(album.getIsAvailable())
        {
            return false;
        }
        album.setIsAvailable(true);
        return true;
    }

    public void print() //display the list without specifying the order
    {
        for(int i = 0; i < numAlbums; i++) {
            System.out.println(albums[i]);
        }
    }

    public void printByReleaseDate()
    {
        Album[] newAlbums = new Album[numAlbums];
        Date date = new Date("12/25/2030");
        Collection col = new Collection(newAlbums, 0);

        for(int j = 0; j < numAlbums; j++) {
            Album lessAlbum = new Album("none", "none", Genre.unknown, date, true);
            for (int i = 0; i < numAlbums; i++) {
                if (albums[i].getDate().compareTo(lessAlbum.getDate()) == -1) {
                    if(col.find(albums[i]) == Constants.NOT_FOUND)
                        lessAlbum = albums[i];
                }
            }
            col.add(lessAlbum);
        }

        col.print();
    }

    public void printByGenre()
    {
       /** Album[] newAlbums = new Album[numAlbums];
        Date date = new Date("12/25/2030");
        Album lessAlbum = new Album("none", "none", Genre.unknown, date, true);

        for(int j = 0; j < numAlbums; j++) {
            for (int i = 0; i < numAlbums; i++) {
                if (Genre.valueOf(albums[i].getGenre().name()) < 1) {
                    lessAlbum = albums[i];
                }
            }
            newAlbums[j] = lessAlbum;
        }
        */
        for(int i = 0; i < numAlbums; i++)
        {
            System.out.println(albums[i]);
        }
    }
}
