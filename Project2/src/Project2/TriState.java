package Project2;

/**
 * Used to create Tristate, a subclass of Student.
 * Create non-resident with profile, credits, tuitionDue, lastPaymentDate, totalPayment, state
 * tuitionDue() and toString() methods are overwritten
 * @author Nicholas Triano, Antonio Ignarra
 */
public class TriState extends NonResident {

    private String state;

    /**
     * Constructor for Tristate class, creates a new Tristate object with given parameters
     * @param profile profile of the Student
     * @param credits number of credit hours student has
     * @param state state that Tristate student lives in
     * @param tuitionDue amount of tuition due
     * @param lastPaymentDate the date of the latest payment submitted
     * @param totalPayment total amount paid by the student
     */
    public TriState(Profile profile, int credits, String state, double tuitionDue, String lastPaymentDate, double totalPayment ) {
        super(profile, credits, tuitionDue, lastPaymentDate, totalPayment);
        this.state = state;
    }

    /**
     * Calculates tuitionDue for the Tristate student
     */
    @Override
    public void tuitionDue(){

    }


    /**
     * Formats Tristate object into a string for use in output
     * @return formattedString the Tristate class in String format
     */
    @Override
    public String toString() {
        String formattedString = profile + ":" + credits +
                " credit hours:tuition due:" + tuitionDue + ":total payment:" + totalPayment +
                "payment date:" + lastPaymentDate + ":non-resident(tri-state):" + state;
        return formattedString;
    }


}
