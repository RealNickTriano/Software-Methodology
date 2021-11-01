package com.example.project3;

/**
 * Used to create non-residents, a subclass of Student.
 * Create non-resident with profile, credits, tuitionDue, lastPaymentDate, totalPayment
 * tuitionDue() and toString() methods are overwritten
 * @author Nicholas Triano, Antonio Ignarra
 */
public class NonResident extends Student {

    /**
     * Constructor for NonResident class, creates a new NonResident object with given parameters
     * @param profile profile of the Student
     * @param credits number of credit hours student has
     * @param tuitionDue amount of tuition due
     * @param lastPaymentDate the date of the latest payment submitted
     * @param totalPayment total amount paid by the student
     */
    public NonResident(Profile profile, int credits, double tuitionDue, String lastPaymentDate, double totalPayment) {
        super(profile, credits, tuitionDue, lastPaymentDate, totalPayment);
    }

    /**
     * Calculates tuitionDue for the NonResident student
     */
    @Override
    public void tuitionDue() {

        if ( credits < Constants.MINIMUM_FULL_TIME_CREDITS )
        {
            tuitionDue = (Constants.NONRESIDENT_COST_PER_CREDIT * credits) + Constants.PART_TIME_UNIVERSITY_FEE;
        }
        else if ( credits > Constants.CREDITS_FOR_ADDITIONAL_TUITION)
        {
            tuitionDue = (Constants.NONRESIDENT_TUITION + Constants.UNIVERSITY_FEE) +
                    (Constants.NONRESIDENT_COST_PER_CREDIT * (credits - Constants.CREDITS_FOR_ADDITIONAL_TUITION));
        }
        else
            tuitionDue = Constants.NONRESIDENT_TUITION + Constants.UNIVERSITY_FEE;

    }

    /**
     * Formats NonResident object into a string for use in output
     * @return formattedString the NonResident class in String format
     */
    @Override
    public String toString() {
        String formattedString = super.toString() + ":total payment:" + totalPayment +
                "payment date:" + lastPaymentDate + ":non-resident";
        return formattedString;
    }

}
