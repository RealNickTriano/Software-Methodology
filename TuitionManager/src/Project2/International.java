package Project2;

/**
 * Used to create International, a subclass of Student.
 * Create International with profile, credits, tuitionDue, lastPaymentDate, totalPayment, studyAbroad
 * tuitionDue() and toString() methods are overwritten
 * @author Nicholas Triano, Antonio Ignarra
 */
public class International  extends NonResident {

    protected boolean studyAbroad;

    /**
     * Constructor for International class, creates a new International object with given parameters
     * @param profile profile of the Student
     * @param credits number of credit hours student has
     * @param studyAbroad study abroad status of the student
     * @param tuitionDue amount of tuition due
     * @param lastPaymentDate the date of the latest payment submitted
     * @param totalPayment total amount paid by the student
     */
    public International(Profile profile, int credits, boolean studyAbroad, double tuitionDue, String lastPaymentDate, double totalPayment) {
        super(profile, credits, tuitionDue, lastPaymentDate, totalPayment);
        this.studyAbroad = studyAbroad;
    }

    /**
     * Allows other classes to set study abroad status
     * @param studyAbroad the study abroad status of the student
     */
    public void setStudyAbroad(boolean studyAbroad)
    {
        this.studyAbroad = studyAbroad;
    }

    /**
     * Allows other classes to get tuitionDue amount
     * @return tuitionDue the amount the student owes
     */
    public double getTuitionDue()
    {
        return tuitionDue;
    }

    /**
     * Calculates tuitionDue for the International student
     */
    @Override
    public void tuitionDue() {

        if ( credits < Constants.MINIMUM_FULL_TIME_CREDITS)
        {
            // Error international students cannot be part time
        }
        else if ( credits > Constants.MINIMUM_FULL_TIME_CREDITS && studyAbroad)
        {
            // Error international students in study abroad cannot have more than 12 credits
        }
        else if(studyAbroad)
        {
            tuitionDue = Constants.UNIVERSITY_FEE + Constants.INTERNATIONAL_ADDITIONAL_FEE;
        }
        else if( credits > Constants.CREDITS_FOR_ADDITIONAL_TUITION)
        {
            tuitionDue = Constants.INTERNATIONAL_TUITION + Constants.UNIVERSITY_FEE +
                    Constants.INTERNATIONAL_ADDITIONAL_FEE + (Constants.NONRESIDENT_COST_PER_CREDIT *
                    (credits - Constants.CREDITS_FOR_ADDITIONAL_TUITION));
        }
        else
            tuitionDue = Constants.INTERNATIONAL_TUITION + Constants.UNIVERSITY_FEE +
                        Constants.INTERNATIONAL_ADDITIONAL_FEE;

    }

    /**
     * Formats International object into a string for use in output
     * @return formattedString the International class in String format
     */
    @Override
    public String toString() {

        String formattedString;
        if(studyAbroad) {
            formattedString = profile + ":" + credits +
                    " credit hours:tuition due:" + tuitionDue + ":total payment:" + totalPayment +
                    "payment date:" + lastPaymentDate + ":non-resident:international:study abroad";
        }
        else {
            formattedString = profile + ":" + credits +
                    " credit hours:tuition due:" + tuitionDue + ":total payment:" + totalPayment +
                    "payment date:" + lastPaymentDate + ":non-resident:international";
        }
        return formattedString;

    }


}
