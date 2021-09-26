/**
 * Used to create Albums with specific names to be put into the Collection class.
 * Create Album with title, artist, genre, releaseDate, availability (True by default)
 * Equals and toString methods are overwritten and getters and setters in place
 *
 * @author Nicholas Triano, Antonio Ignarra
 */
package com.company;

public class Album {

    private String title;
    private String artist;
    private Genre genre; //enum class; Classical, Country, Jazz, Pop, Unknown
    private Date releaseDate;
    private boolean isAvailable;

    /**
     * Constructor for Album class creates a new Album object with given parameters
     * @param title The title of the Album
     * @param artist The artist of the Album
     * @param genre The gente of the Album
     * @param releaseDate When the Album released
     * @param isAvailable If the albums is available or not
     */
    public Album(String title, String artist, Genre genre, Date releaseDate, boolean isAvailable) {
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.isAvailable = true;
    }

    /**
     * Allows other classes to set the availability
     * @param isAvailable If the albums is available or not
     */
    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    /**
     * Allows other classes to retrieve the Title
     * @return title of the Album
     */
    public String getTitle() {
        return title;
    }

    /**
     * Allows other classes to retrieve the Artist
     * @return artist of the album
     */
    public String getArtist() {
        return artist;
    }

    /**
     * Allows other classes to retrieve the availability
     * @return true if album is available false if not
     */
    public boolean getIsAvailable() {
        return isAvailable;
    }

    /**
     * Allows other classes to retrieve the release date
     * @return release date of the album
     */
    public Date getDate() {
        return releaseDate;
    }

    /**
     * Allows other classes to retrieve the genre
     * @return genre of the album
     */
    public Genre getGenre() {
        return genre;
    }

    /**
     * Compares two Albums and returns true if they are equal, false if not
     * @param obj the Album object being compared
     * @return true if equal, false if NOT equal
     */
    @Override
    public boolean equals(Object obj) {
        // If object is being compared to itself return true
        if (obj == this) {
            return true;
        }

        //If object is not an instance of Album return false
        if (!(obj instanceof Album)) {
            return false;
        }

        // typecast object to Album
        Album newAlbum = (Album) obj;

        // Compare title and artist, return true if both are equal, false of not
        if (title.equalsIgnoreCase(newAlbum.title) && artist.equalsIgnoreCase(newAlbum.artist)) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * Formats Album object into a string for use in output
     * @return formattedString the Album class in String format
     */
    @Override
    public String toString() {
        String formattedString;
        if (isAvailable) {
            formattedString = title + "::" + artist + "::" + genre + "::"
                    + releaseDate + "::is available";
        } else {
            formattedString = title + "::" + artist + "::" + genre + "::"
                    + releaseDate + "::is not available";
        }

        return formattedString;
    }
}


