package Project2;

/**
 * Used to create Resident, a subclass of Student.
 * Create Resident with profile, credits, tuitionDue, lastPaymentDate, totalPayment, financial aid
 * tuitionDue() and toString() methods are overwritten
 * @author Nicholas Triano, Antonio Ignarra
 */
public class Resident extends Student {

    protected double financialAid;

    /**
     * Constructor for NonResident class, creates a new NonResident object with given parameters
     * @param profile profile of the Student
     * @param credits number of credit hours student has
     * @param tuitionDue amount of tuition due
     * @param financialAid amount of financial aid received by student
     * @param lastPaymentDate the date of the latest payment submitted
     * @param totalPayment total amount paid by the student
     */
    public Resident(Profile profile, int credits, double tuitionDue, double financialAid, String lastPaymentDate, double totalPayment) {
        super(profile, credits, tuitionDue, lastPaymentDate, totalPayment);
        this.financialAid = financialAid;
    }

    /**
     * Calculates tuitionDue for the Resident student
     */
    @Override
    public void tuitionDue() {

        if ( credits < Constants.MINIMUM_FULL_TIME_CREDITS )
        {
            tuitionDue = (Constants.NONRESIDENT_COST_PER_CREDIT * credits) + Constants.PART_TIME_UNIVERSITY_FEE;
        }
        else if ( credits > Constants.CREDITS_FOR_ADDITIONAL_TUITION)
        {
            tuitionDue = (Constants.RESIDENT_TUITION + Constants.UNIVERSITY_FEE) +
                    (Constants.RESIDENT_COST_PER_CREDIT * (credits - Constants.CREDITS_FOR_ADDITIONAL_TUITION));
        }
        else
            tuitionDue = Constants.RESIDENT_TUITION + Constants.UNIVERSITY_FEE - financialAid;

    }

    /**
     * Formats Resident object into a string for use in output
     * @return formattedString the Resident class in String format
     */
    @Override
    public String toString() {
        String formattedString = profile + ":" + credits +
                " credit hours:tuition due:" + tuitionDue + ":total payment:" + totalPayment +
                "payment date:" + lastPaymentDate + ":resident";
        return formattedString;
    }

}
