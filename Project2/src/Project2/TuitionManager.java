
package Project2;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Handles user input/output to provide fluid interaction between user and program.
 * Provides feedback on user input and interacts with other classes to perform user requested actions.
 * Tokenizes user input to process the information, then makes a decision based on the tokens.
 * Various helper methods included.
 *
 * @author Nicholas Triano, Antonio Ignarra
 */
public class TuitionManager {

    private String command, studentName, majorString, creditHoursString, date, state;
    private Date newDate;
    private Major newMajor;
    private double totalPayment, financialAid;
    private boolean validDate = true, studyAbroad;
    private int credits;
    private Profile newProfile;
    private Student newStudent;
    private Student[] studentArray;
    private Roster roster = new Roster(studentArray, 0);
    String inputString = Constants.INITIALIZED;

    /**
     * The main method in this class, calls helper methods to handle user input/output.
     * Uses Scanner imported class to take user input adn then calls helper method to tokenize
     * Will check for valid date before checking command or making an album
     * Exits when key input "Q" is entered.
     */
    public void run()
    {
        System.out.println("Tuition Manager starts running.");

        while(!(inputString.equals("Q")))
        {
            Scanner input = new Scanner(System.in);
            inputString = input.nextLine();
            StringTokenizer st1 = new StringTokenizer(inputString, ",");
            int count = st1.countTokens();
            if (count != 0) {
                command = st1.nextToken();
                handleCommand(command, st1);
            }

        }
    }

    /**
     * Separate input string into different strings
     * @param st1 The whole line of input from user
     */
    private int tokenizeAdd(StringTokenizer st1) {

        // check token count
        int count = st1.countTokens();
        if( count < 2) {
            System.out.println("Missing data in command line.");
        }
        else if ( count < 3 )
        {
            System.out.println( "Credit hours missing." );
        }
            studentName = st1.nextToken();
            majorString = st1.nextToken();

            try {
                newMajor = Major.valueOf(majorString.toUpperCase());
            }
            catch ( IllegalArgumentException e)
            {
                System.out.println( "'" + majorString + "'" + " is not a valid major.");
                return -1;
            }
            creditHoursString = st1.nextToken();
            try {
                credits = Integer.parseInt(creditHoursString);
            }
            catch ( Exception e )
            {
                System.out.println( "Invalid credit hours." );
                return -1;
            }
            if ( credits < 0 )
            {
                System.out.println( "Credit hours cannot be negative." );
                throw new ArithmeticException( "Credit hours cannot be negative." );
            }
            else if ( credits < 3 ) {
                System.out.println( "Minimum credit hours is 3." );
                throw new ArithmeticException( "Minimum credit hours is 3." );
            }
            else if ( credits > 24 ){
                System.out.println( "Credit hours exceed the maximum 24." );
                throw new ArithmeticException( "Credit hours exceed the maximum 24." );
            }
            else if ( credits < 0 ){
                System.out.println( "Credit hours cannot be negative." );
                throw new ArithmeticException( "Credit hours cannot be negative." );
            }
            // TODO, AI/AT not adding to roster
            if (command.equalsIgnoreCase("AT")) // if tri state
                state = st1.nextToken();
            else if (command.equalsIgnoreCase("AI")) { // if international
                if (credits < 12) {
                    System.out.println("International students must enroll at least 12 credits.");
                    throw new ArithmeticException("International students must enroll at least 12 credits.");
                }
                studyAbroad = Boolean.parseBoolean(st1.nextToken());
            }
        return 1;
    }

    private void tokenizeRemove(StringTokenizer st1) {

        studentName = st1.nextToken();
        majorString = st1.nextToken();
        newMajor = Major.valueOf(majorString.toUpperCase());
    }

    /**
     * Determine what action to take with the given command, Checks printCommand method if nothing matches
     * @param command String entered by user
     * @param st1
     */
    private void handleCommand(String command, StringTokenizer st1) {
        boolean error;
        int err;
        switch (command) {
            default:
                printCommand(command);
                break;
            case "AR":
                // add a resident student
                try {
                    err = tokenizeAdd(st1);
                    if ( err == -1 )
                        break;
                    newProfile  = new Profile(studentName, newMajor);
                    Resident newResident = new Resident(newProfile, credits,
                            0, 0, new Date(), 0);
                    error = roster.add(newResident);
                    handleErrorAdd(error);
                }
                catch ( Exception e )
                {

                }
                break;
            case "AN":
                // add a nonresident student
                try {
                    err = tokenizeAdd(st1);
                    if (err == -1)
                        break;
                    newProfile = new Profile(studentName, newMajor);
                    NonResident newNonResident = new NonResident(newProfile, credits,
                            0, new Date(), 0);
                    error = roster.add(newNonResident);
                    handleErrorAdd(error);
                }
                catch ( Exception e ){

                }
                break;
            case "AT":
                // add a tristate student
                try {
                    err = tokenizeAdd(st1);
                    if (err == -1)
                        break;
                    newProfile = new Profile(studentName, newMajor);
                    TriState newTriState = new TriState(newProfile, credits, state,
                            0, new Date(), 0);
                    error = roster.add(newTriState);
                    handleErrorAdd(error);
                }
                catch ( Exception e ){

                }
                break;
            case "AI":
                // add a international student
                try {
                    err = tokenizeAdd(st1);
                    if (err == -1)
                        break;
                    newProfile = new Profile(studentName, newMajor);
                    International newInternational = new International(newProfile, credits, studyAbroad,
                            0, new Date(), 0);
                    error = roster.add(newInternational);
                    handleErrorAdd(error);
                }
                catch ( Exception e ){

                }
                break;
            case "R":
                //Remove a student
                tokenizeRemove(st1);
                newProfile  = new Profile(studentName, newMajor);
                // make student to compare profiles
                Student student = new Student(newProfile, 0, 0, new Date(), 0 );
                error = roster.remove(student);
                handleErrorRemove(error);
                break;
            case "C":
                // Calculate tuition dues
                roster.CalculateDues();
                System.out.println( "Calculation completed." );
                break;
            case "T":
                // Pay tuition
                err= payTuition(st1);
                if(err == 1)
                    System.out.println("Payment applied.");
                else
                break;
            case "S":
                // Set study abroad status to true for an international student
                Profile profile = makeProfile(st1);
                Student newStudent = new Student(profile, 0, 0, new Date(), 0);
                int position = roster.find(newStudent);
                if (position == Constants.NOT_FOUND)
                    System.out.println("Couldn't find the international student.");
                else {
                    roster.setStudyAbroad(position);
                    System.out.println("Tuition updated.");
                }
                break;
            case "F":
                // Set the financial aid amount for a resident student
                Profile profile = makeProfile(st1);
                Student newStudent = new Student(profile, 0, 0, new Date(), 0);
                int position = roster.find(newStudent);
                if (position == Constants.NOT_FOUND) {
                    System.out.println( "Student is not in the roster." )
                }
                else {
                    // Given name is in the roster, need to validate student qualifies and entered amount is valid
                    if ( roster.isResident(newStudent) ) {
                        if ( roster.isFullTime(newStudent) ) {
                            financialAid = Double.parseDouble(st1.nextToken());
                            if (financialAid <= 0 || financialAid > Constants.RESIDENT_MAX_AID) {
                                System.out.println( "Invalid amount." );
                            }
                            else {
                                error = roster.setFinancialAid(financialAid, position);
                                if ( !error ){
                                    System.out.println( "Awarded financial aid already." );
                                }
                            }
                        }
                        else {
                            System.out.println( "Parttime student doesn't qualify for the award." );
                        }
                    }
                    else {
                        System.out.println( "Not a resident student." );
                    }
                }
        }
    }

    public Profile makeProfile(StringTokenizer st1)
    {
        studentName = st1.nextToken();
        majorString = st1.nextToken();
        newMajor = Major.valueOf(majorString.toUpperCase());
        Profile profile = new Profile(studentName, newMajor);
        return profile;
    }

    private int payTuition( StringTokenizer st1 ) {
        Profile profile = makeProfile(st1);
        Student student = new Student(profile, 0, 0, new Date(), 0);
        totalPayment = Double.parseDouble(st1.nextToken());
        if(totalPayment == 0 || totalPayment < 0)
        {
            System.out.println( "Invalid amount." );
            return -1;
        }
        newDate = new Date(st1.nextToken());
        int position = roster.find(student);
        int error = roster.pay(totalPayment, newDate, position);
        if(error == -1) {
            System.out.println( "Amount is greater than amount due." );
            return -1;
        }
        return 1;
    }

    /**
     * Determines the order to print the Roster from the given command, "Invalid command" is output if nothing matches
     * "P" print the roster as is
     * "PN" print the roster sorted by student names
     * "PT" print only the students who have made payments, ordered by the payment date
     * @param command String entered by user
     */
    private void printCommand(String command) {
        switch (command) {
            default:
                System.out.format( "Command '%s' not supported!\n", command );
                break;
            case "P":
                //print the roster as is.
                roster.print();
                break;
            case "PN":
                //print the roster sorted by student names.
                roster.printByNames();
                break;
            case "PT":
                //print only the students who have made payments, ordered by the payment date.
                roster.printByPaymentDate();
                break;
        }
    }

    private void handleErrorAdd(boolean error)
    {
        if (!error)
            System.out.println( "Student is already in the roster." );
        else
            System.out.println( "Student added." );
    }

    private void handleErrorRemove(boolean error)
    {
        if (!error)
            System.out.println( "Student is not in the roster." );
        else
            System.out.println( "Student removed from the roster." );
    }
}
