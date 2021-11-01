package com.example.project3;

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
        if ( credits < Constants.MINIMUM_FULL_TIME_CREDITS )
        {
            tuitionDue = (Constants.NONRESIDENT_COST_PER_CREDIT * credits) + Constants.PART_TIME_UNIVERSITY_FEE;
        }
        else if ( credits > Constants.CREDITS_FOR_ADDITIONAL_TUITION)
        {
            tuitionDue = (Constants.NONRESIDENT_TUITION + Constants.UNIVERSITY_FEE) +
                    (Constants.NONRESIDENT_COST_PER_CREDIT * (credits - Constants.CREDITS_FOR_ADDITIONAL_TUITION));
            if (state.equalsIgnoreCase("NY")) {
                tuitionDue = tuitionDue - Constants.DISCOUNT_NEW_YORK;
            }
            else if (state.equalsIgnoreCase("CT")) {
                tuitionDue = tuitionDue - Constants.DISCOUNT_CONNECTICUT;
            }
        }
        else
            tuitionDue = Constants.NONRESIDENT_TUITION + Constants.UNIVERSITY_FEE;
            if (state.equalsIgnoreCase("NY")) {
                tuitionDue = tuitionDue - Constants.DISCOUNT_NEW_YORK;
            }
            else if (state.equalsIgnoreCase("CT")) {
                tuitionDue = tuitionDue - Constants.DISCOUNT_CONNECTICUT;
            }
    }

    public String getState()
    {
        return this.state;
    }
    /**
     * Formats Tristate object into a string for use in output
     * @return formattedString the Tristate class in String format
     */
    @Override
    public String toString() {
        String formattedString = super.toString() + ":total payment:" + totalPayment +
                "payment date:" + lastPaymentDate + ":non-resident(tri-state):" + state;
        return formattedString;
    }


}
