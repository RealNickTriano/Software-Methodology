
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
            StringTokenizer st1 = new StringTokenizer(inputString, ",");
            int count = st1.countTokens();
            command = st1.nextToken();
            handleCommand(command, st1);

        }
    }

    /**
     * Separate input string into different strings
     * @param inputString The whole line of input from user
     */
    private void tokenizeAdd(StringTokenizer st1) {

        studentName = st1.nextToken();
        majorString = st1.nextToken();
        newMajor = Major.valueOf(majorString);
        creditHoursString = st1.nextToken();
        credits = Integer.parseInt(creditHoursString);
    }

    /**
     * Determine what action to take with the given command, Checks printCommand method if nothing matches
     * @param command String entered by user
     * @param st1
     */
    private void handleCommand(String command, StringTokenizer st1) {
        boolean error;
        tokenizeAdd(st1);
        newProfile  = new Profile(studentName, newMajor);
        System.out.println(newProfile);
        switch (command) {
            default:
                printCommand(command);
                break;
            case "AR":
                // add a resident student
                Resident newResident = new Resident(newProfile, credits, 0, new Date());
                error = roster.add(newStudent);
                handleErrorAdd(error);
                break;
            case "AN":
                // add a nonresident student
                NonResident newNonResident = new NonResident(newProfile, credits, 0, new Date());
                error = roster.add(newStudent);
                handleErrorAdd(error);
                break;
            case "AT":
                // add a tristate student
                TriState newTriState = new TriState(newProfile, credits, state, 0, new Date());
                error = roster.add(newStudent);
                handleErrorAdd(error);
                break;
            case "AI":
                // add a international student
                International newInternational = new International(newProfile, credits, studyAbroad, 0, new Date());
                error = roster.add(newStudent);
                handleErrorAdd(error);
                break;
            case "R":
                //Remove a student
                error = roster.remove(newStudent);
                handleErrorRemove(error);
                break;
            case "C":
                // Calculate tuition dues
                break;
            case "T":
                // Pay tuition
                break;
            case "S":
                // Set study abroad status to true for an international student
                break;
            case "F":
                // Set the financial aid amount for a resident student

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
                break;
            case "PN":
                //print the roster sorted by student names.
                break;
            case "PT":
                //print only the students who have made payments, ordered by the payment date.
                break;
        }
    }

    private void handleErrorAdd(boolean error)
    {
        if (!error)
            System.out.println(newStudent + " >> is already on the roster.");
        else
            System.out.println(newStudent + " >> added successfully.");
    }

    private void handleErrorRemove(boolean error)
    {
        if (!error)
            System.out.println(newStudent + " >> is not on the roster.");
        else
            System.out.println(newStudent + " >> removed successfully.");
    }
}
