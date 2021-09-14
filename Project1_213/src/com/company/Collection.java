/**
 * @author Nicholas Triano
 * @author Antonio Ignarra
 */
package com.company;

public class Collection {

    private Album[] albums;
    private int numAlbums; //number of albums currently in the collection

    private int find(Album album) //find the album index, or return NOT_FOUND
    {
        int i;
        for(i=0; i<numAlbums; i++){
            if (albums[i].getTitle() == album.getTitle() && albums[i].getArtist() == album.getArtist()){
                return i;
            }
        }
        return Constants.NOT_FOUND;
    }

    private void grow() //increase the capacity of the array list by 4
    {

    }
    public boolean add(Album album)
    {
        return true;
    }
    public boolean remove(Album album)
    {
        return true;
    }
    public boolean lendingOut(Album album) //set to not available
    {
        return true;
    }
    public boolean returnAlbum(Album album) //set to available
    {
        return true;
    }
    public void print() //display the list without specifying the order
    {

    }
    public void printByReleaseDate()
    {

    }
    public void printByGenre()
    {

    }
}
