package tuitionProject3;

/**
 * The Collection where Student objects are added into, methods here operate on the collection.
 * Can find, add, remove, and print the Students in the collection.
 * Can grow and print the collection to the user based on their sorted preference.
 *
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
    public int find(Student student) {

        int i;
        for ( i = 0; i < size; i++ ) {
            if ( roster[i].profile.equals(student.profile) ) {
                return i;
            }
        }
        return Constants.NOT_FOUND;

    }

    /**
     * Increase the capacity of the array list by 4
     */
    private void grow() {

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
    public boolean add(Student student) {
        // student already on roster
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
                    // Profile profile = new Profile("NA", Major.CS);
                    // roster[i] = new Student(profile, 0, 0, "--/--/--", 0);
                    roster[i] = null;
                }
                else {
                    roster[i] = roster[i + 1];
                }
            }
        }
        size--;
        return true;

    }

    /**
     * helper method for checking if roster is empty
     * @return true if roster size is 0, false otherwise
     */
    private boolean isEmpty(){
        if ( size == 0 ){
            return true;
        }
        return false;
    }

    /**
     * Creates a string of the list without specifying the order
     * @return formatString the list of students
     */
    public String print()
    {
        String formatString = "";

        if ( this.isEmpty() ){
            //System.out.println( "Student roster is empty!" );
            return formatString;
        }
        else {
            for (int i = 0; i < size; i++) {
                formatString += roster[i].toString();
                formatString += "\n";
            }
        }
        return formatString;
    }

    /**
     * Creates a string of the list sorted by name
     * @return formatString the list of students
     */
    public String printByNames()
    {
        String formatString = "";
        if ( this.isEmpty() ) {
            //System.out.println( "Student roster is empty!" );
            return formatString;
        }
        else {
            boolean swapped;
            do {
                swapped = false;
                for ( int i = 1; i < size; i++ ) {
                    // if this pair is out of order, swap
                    if (compareNames(roster[i].profile.getName(), roster[i - 1].profile.getName()) == 0){
                        Student temp = roster[i - 1];
                        roster[i - 1] = roster[i];
                        roster[i] = temp;
                        swapped = true;
                    }
                }
            } while ( swapped == true );
        }
        return this.print();
    }

    /**
     *
     * @param a the first string to compare
     * @param b the second string to compare
     * @return 0 if first passed string is less than the second string, 1 if second passed string is less
     * than the first string
     */
    private int compareNames(String a, String b){
        int lenA = a.length();
        int lenB = b.length();
        for(int i = 0; i < lenA && i < lenB; i++){
            int aCharI = a.charAt(i);
            int bCharI = b.charAt(i);
            if ( aCharI < bCharI ){
                return 0;
            }
            else if ( bCharI < aCharI ){
                return 1;
            }
            else{
                continue;
            }
        }
        // don't swap if we reach here
        return 1;
    }

    /**
     * Creates a string of the list sorted by payment date
     * @return formatString the list of students
     */
    public String printByPaymentDate()
    {
        String formatString = "";
        if ( this.isEmpty() ){
            //System.out.println( "Student roster is empty!" );
            return formatString;
        }
        else {
            boolean swapped;
            do {
                swapped = false;
                for ( int i = 1; i < size; i++ ) {
                    // need to handle unset dates
                    if (roster[i].lastPaymentDate.equals("--/--/--") && roster[i-1].lastPaymentDate.equals("--/--/--")) {
                        continue;
                    }
                    else if (roster[i].lastPaymentDate.equals("--/--/--")) {
                        continue;
                    }
                    else if (roster[i-1].lastPaymentDate.equals("--/--/--")) {
                        Student temp = roster[i - 1];
                        roster[i - 1] = roster[i];
                        roster[i] = temp;
                        swapped = true;
                    }
                    else {
                        Date secondStudentDate = new Date(roster[i].lastPaymentDate);
                        Date firstStudentDate = new Date(roster[i - 1].lastPaymentDate);
                        if (secondStudentDate.compareTo(firstStudentDate) == -1) {
                            Student temp = roster[i - 1];
                            roster[i - 1] = roster[i];
                            roster[i] = temp;
                            swapped = true;
                        }
                    }
                }
            } while ( swapped == true );
        }
        return this.print();
    }


    /**
     * sets totalPayment and lastPaymentDate for student, subtracts totalPayment from tuition
     * @param currentPayment the amount of money to pay towards current tuition
     * @param newDate date that payment was made
     * @param position position of student in the roster array
     * @return
     */
    public int pay(double currentPayment, String newDate, int position)
    {
        roster[position].setLastPaymentDate(newDate);
        if(currentPayment > roster[position].tuitionDue)
            return Constants.ERROR;
        roster[position].setTotalPayment(currentPayment);
        roster[position].setTuitionDue(currentPayment);
        return Constants.SUCCESS;
    }

    /**
     * Helper method for tuition manager to determine if queried sttudent is a resident student
     * @param student the desired student
     * @return true if student is a resident, false otherwise
     */
    public boolean isResident(Student student){
        int i = find(student);
        if (roster[i] instanceof Resident) {
            return true;
        }
        return false;
    }
    

    /**
     * Method to set financial aid
     * @param amount how much financial aid to reward
     * @param position location of student in roster array
     * @return true if financial aid amount set successfully, false if financial aid was already rewarded
     */
    public int setFinancialAid(double amount, int position) {
        //TODO: have to cast this to correct student
        Resident student = (Resident) roster[position];
        if ( student.financialAid != 0 ){
            return Constants.ERROR;
        }
        if (student.tuitionDue < amount + student.totalPayment)
            return Constants.ERROR;
        student.financialAid = amount;
        student.tuitionDue -= student.financialAid;
        student.setTotalPayment(amount);
        return Constants.SUCCESS;
    }

    /**
     * Method which determines if a student is on the roster
     * @param student the desired student
     * @return true if student is on the roster false if not
     */
    public boolean exists(Student student) {
        if (find(student) == Constants.NOT_FOUND) {
            return false;
        }
        return true;
    }

}
