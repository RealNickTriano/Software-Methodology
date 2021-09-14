/**
 * @author Nicholas Triano
 * @author Antonio Ignarra
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

    // getter methods for private fields
    public String getTitle()
    {
        return title;
    }

    public String getArtist()
    {
        return artist;
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
            formattedString = title + "::" + artist + "::" + genre + "::" +
                    releaseDate.getMonth() + "/"+ releaseDate.getDay() + "/" +
                    releaseDate.getYear() + "::is available";
        }
        else
        {
            formattedString = title + "::" + artist + "::" + genre + "::"
                    + releaseDate.getMonth() + "/"+ releaseDate.getDay() + "/"
                    + releaseDate.getYear() + "::is not available";
        }

        return formattedString;
    }
}


