
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
    private boolean validDate = true, studyAbroad;
    private int credits, tuitionRemissions = 0;
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
            if ( inputString.length() == 0 ){
                System.out.println("\n");
            }
            StringTokenizer st1 = new StringTokenizer(inputString, ",");
            int count = st1.countTokens();
            command = st1.nextToken();
            handleCommand(command, st1);

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
            if ( credits < 3 ) {
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

            if (command.equalsIgnoreCase("AT")) // if tri state
                state = st1.nextToken();
            else if (command.equalsIgnoreCase("AI")) // if international
                studyAbroad = Boolean.parseBoolean(st1.nextToken());

        return 1;
    }

    private void tokenizeRemove(StringTokenizer st1) {

        studentName = st1.nextToken();
        majorString = st1.nextToken();
        newMajor = Major.valueOf(majorString);
    }

    /**
     * Determine what action to take with the given command, Checks printCommand method if nothing matches
     * @param command String entered by user
     * @param st1
     */
    private void handleCommand(String command, StringTokenizer st1) {
        boolean error;
        switch (command) {
            default:
                printCommand(command);
                break;
            case "AR":
                // add a resident student
                try {
                    int err = tokenizeAdd(st1);
                    if ( err == -1 )
                        break;
                    newProfile  = new Profile(studentName, newMajor);
                    Resident newResident = new Resident(newProfile, credits, 0, 0, new Date());
                    error = roster.add(newResident);
                    handleErrorAdd(error);
                }
                catch ( Exception e )
                {

                }

                break;
            case "AN":
                // add a nonresident student
                tokenizeAdd(st1);
                newProfile  = new Profile(studentName, newMajor);
                NonResident newNonResident = new NonResident(newProfile, credits, 0, 0, new Date());
                error = roster.add(newNonResident);
                handleErrorAdd(error);
                break;
            case "AT":
                // add a tristate student
                tokenizeAdd(st1);
                newProfile  = new Profile(studentName, newMajor);
                TriState newTriState = new TriState(newProfile, credits, state, 0, 0, new Date());
                error = roster.add(newTriState);
                handleErrorAdd(error);
                break;
            case "AI":
                // add a international student
                tokenizeAdd(st1);
                newProfile  = new Profile(studentName, newMajor);
                International newInternational = new International(newProfile, credits, studyAbroad, 0, 0, new Date());
                error = roster.add(newInternational);
                handleErrorAdd(error);
                break;
            case "R":
                //Remove a student
                // TODO: need to make this student first
                tokenizeRemove(st1);
                newProfile  = new Profile(studentName, newMajor);
                // make student to compare profiles
                Student student = new Student(newProfile, 0, 0, new Date() );
                error = roster.remove(student);
                handleErrorRemove(error);
                break;
            case "C":
                // Calculate tuition dues
                roster.CalculateDues();
                break;
            case "T":
                // Pay tuition
                // TODO: may need another variable in student classes
                break;
            case "S":
                // Set study abroad status to true for an international student
                int position = roster.find(newStudent);
                if (position == Constants.NOT_FOUND)
                    System.out.println("Student does not exist.");
                // TODO: Do we remove this student and add it again with updated information?
                break;
            case "F":
                // Set the financial aid amount for a resident student
                // TODO: Do we remove this student and add it again with updated information?

        }
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
                System.out.println("Invalid Command!");
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
