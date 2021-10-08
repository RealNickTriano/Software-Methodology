package Project2;

/**
 * @author Nicholas Triano, Antonio Ignarra
 */
public class Roster {

    private Student[] roster;
    private int size; // keep track of the number of students in the roster

    /**
     * Constructor for Roster class creates a new Collection-like object with given parameters
     * @param roster An array of the Students currently in the collection
     * @param size The number of Students in the collection
     */

    public Roster(Student[] roster, int size) {
        this.roster = roster;
        this.size = size;
    }

    /**
     * Finds the given student's index, or returns NOT_FOUND
     * @param student The requested student
     * @return The index of the student requested
     */
    private int find(Student student){

        int i;
        for ( i = 0; i < size; i++ ) {
            if ( roster[i].equals(student) ) {
                return i;
            }
        }
        return Constants.NOT_FOUND;

    }

    /**
     * Increase the capacity of the array list by 4
     */
    private void grow(){

        Student[] newRosterArr = new Student[size + 4];
        // copy over students in the current roster to the roster w/ updated size
        for ( int i = 0; i < size; i++ ) {
            newRosterArr[i] = roster[i];
        }
        roster = newRosterArr;

    }

    /**
     * Adds a Student to the roster
     * @param student The student to be added to the roster
     * @return false if the roster already contains the student, true if the student was successfully added
     */
    public boolean add(Student student){

        if ( find(student) != Constants.NOT_FOUND ){
            return false;
        }
        if ( size == 0 ) {
            this.grow();
        }
        else if ( size >= roster.length ) {
            this.grow();
        }
        roster[size] = student;
        size++;
        return true;

    }

    /**
     * Removes a student from the collection
     * @param student the student to be removed from the collection
     * @return false if the student is not in the collection, true if the student is successfully removed
     */
    public boolean remove(Student student){

        // find the index of the student to be removed
        int i = find( student );
        // check if requested student is in the roster
        if ( i == Constants.NOT_FOUND ) {
            return false;
        }
        // remove student
        else {
            for ( ; i < size; i++ ) {
                // if at last space in current capacity
                if ( i == roster.length - 1 ) {
                    Profile profile = new profile("NA", "NA");
                    roster[i] = new student(profile, 0, 0);
                }
                else {
                    roster[i] = roster[i + 1];
                }
            }
        }
        size--;
        return true;

    }
}
