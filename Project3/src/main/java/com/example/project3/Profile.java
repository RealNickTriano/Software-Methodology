package com.example.project3;

/**
 * Used to create Profiles with a name and major to serve as a unique identifier for students
 * Overrides equals() and toString() methods.
 * Getters and Setters for name and major.
 * @author Nicholas Triano, Antonio Ignarra
 */
public class Profile {

    private String name;
    private Major major; //5 majors and 2-charater each: CS, IT, BA, EE, ME

    /**
     * Constructor for Profile class creates a new Profile object with given parameters
     * @param name The name of the student
     * @param major The major of the student
     */
    public Profile(String name, Major major) {
        this.name = name;
        this.major = major;
    }

    /**
     * Allows other classes to retrieve the name
     * @return name of the student profile
     */
    public String getName() {
        return name;
    }


    /**
     * Allows other classes to set the name
     * @param name name of the student profile
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Allows other classes to retrieve the major
     * @return major of the student profile
     */
    public Major getMajor() {
        return major;
    }

    /**
     * Allows other classes to set the major
     * @param major major of the student profile
     */
    public void setMajor(Major major) {
        this.major = major;
    }

    /**
     * Compares two Profiles and returns true if they are equal, false if not
     * @param obj the Profile object being compared
     * @return true if equal, false if NOT equal
     */
    @Override
    public boolean equals(Object obj)
    {
        // If object is being compared to itself return true
        if ( obj == this ) {
            return true;
        }

        //If object is not an instance of Album return false
        if ( !( obj instanceof Profile ) ) {
            return false;
        }

        // typecast object to Album
        Profile newProfile = ( Profile ) obj;

        // Compare name and major, return true if both are equal, false of not
        if ( name.equals( newProfile.name ) && major == newProfile.major ) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Formats Profile object into a string for use in output
     * @return formattedString the Profile class in String format
     */
    @Override
    public String toString()
    {
        String formattedString;

        formattedString = name + ":" + major.name();

        return formattedString;
    }
}
