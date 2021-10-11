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
    public int find(Student student){

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
    public void grow(){

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
                    Profile profile = new Profile("NA", Major.CS);
                    roster[i] = new Student(profile, 0, 0, "--/--/--", 0);
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
     * Display the list without specifying the order
     */
    public void print()
    {
        if ( this.isEmpty() ){
            System.out.println( "Student roster is empty!" );
            return;
        }
        else {
            for (int i = 0; i < size; i++) {
                System.out.println(roster[i]);
            }
        }
    }

    /**
     * Display the list sorted by student names
     */
    public void printByNames()
    {
        if ( this.isEmpty() ) {
            System.out.println( "Student roster is empty!" );
            return;
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
        this.print();
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
     * Display the list of only the students who have made payments, ordered by the payment date
     */
    public void printByPaymentDate()
    {
        if ( this.isEmpty() ){
            System.out.println( "Student roster is empty!" );
            return;
        }
        else {
            boolean swapped;
            do {
                swapped = false;
                for ( int i = 1; i < size; i++ ) {
                    // if this pair is out of order, swap
                    if (roster[i].lastPaymentDate.compareTo(roster[i - 1].lastPaymentDate) == -1){
                        Student temp = roster[i - 1];
                        roster[i - 1] = roster[i];
                        roster[i] = temp;
                        swapped = true;
                    }
                }
            } while ( swapped == true );
        }
        this.print();
    }

    /**
     * Calculate all tuition for every student in the roster array
     */
    public void CalculateDues()
    {
        for ( int i = 0; i < size; i++ ) {
            roster[i].tuitionDue();
        }
    }

    /**
     * sets study abroad status of international student in roster
     * @param position position of student in the roster array
     */
    public void setStudyAbroad(int position)
    {
        International student = (International) roster[position];
        student.setStudyAbroad(true);
        roster[position] = student;
    }

    /**
     * sets totalPayment and lastPaymentDate for student, subtracts totalPayment from tuition
     * @param totalPayment the amount of money to pay towards current tuition
     * @param newDate date that payment was made
     * @param position position of student in the roster array
     * @return
     */
    public int pay(double totalPayment, String newDate, int position)
    {
        roster[position].setLastPaymentDate(newDate);
        if((roster[position].totalPayment + totalPayment) > roster[position].tuitionDue)
            return -1;
        roster[position].setTotalPayment(totalPayment);
        roster[position].setTuitionDue(totalPayment);
        return 1;
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
     * Helper method to determine if a student is full time
     * @param student the desired student
     * @return true if the queried student is full time, false otherwise
     */
    public boolean isFullTime(Student student){
        int i = find(student);
        if (roster[i].credits >= 3){
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
    public boolean setFinancialAid(double amount, int position) {
        Resident student = (Resident) roster[position];
        if ( student.financialAid != 0 ){
            return false;
        }
        student.financialAid = amount;
        this.CalculateDues();
        return true;
    }

}
