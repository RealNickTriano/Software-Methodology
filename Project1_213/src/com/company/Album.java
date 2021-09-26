/**
 * Used to create Albums with specific names to be put into the Collection class.
 * Create Album with title, artist, genre, releaseDate, availability (True by default)
 * Equals and toString methods are overwritten and getters and setters in place
 * @author Nicholas Triano, Antonio Ignarra
 */
package com.company;

public class Album {

    private String title;
    private String artist;
    private Genre genre; //enum class; Classical, Country, Jazz, Pop, Unknown
    private Date releaseDate;
    private boolean isAvailable;

    public Album(String title, String artist, Genre genre, Date releaseDate, boolean isAvailable) {
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.isAvailable = true;
    }

    // setter methods for private fields
    public void setIsAvailable(boolean isAvailable)
    {
        this.isAvailable = isAvailable;
    }
    // getter methods for private fields
    public String getTitle()
    {
        return title;
    }

    public String getArtist()
    {
        return artist;
    }

    public boolean getIsAvailable()
    {
        return isAvailable;
    }

    public Date getDate()
    {
        return releaseDate;
    }
    public Genre getGenre()
    {
        return genre;
    }


    // Compares two Albums and returns true if they are equal, false if not
    @Override
    public boolean equals(Object obj)
    {
        // If object is being compared to itself return true
        if (obj == this)
        {
            return true;
        }

        //If object is not an instance of Album return false
        if(!(obj instanceof Album))
        {
            return false;
        }

        // typecast object to Album
        Album newAlbum = (Album) obj;

        // Compare title and artist, return true if both are equal, false of not
        if (title.equalsIgnoreCase(newAlbum.title) && artist.equalsIgnoreCase(newAlbum.artist) )
        {
            return true;
        }
        else
        {
            return false;
        }

    }

    // returns formatted string of Album class
    @Override
    public String toString()
    {
        String formattedString;
        if (isAvailable)
        {
            formattedString = title + "::" + artist + "::" + genre + "::"
                                + releaseDate + "::is available";
        }
        else
        {
            formattedString = title + "::" + artist + "::" + genre + "::"
                    + releaseDate + "::is not available";
        }

        return formattedString;
    }
}


