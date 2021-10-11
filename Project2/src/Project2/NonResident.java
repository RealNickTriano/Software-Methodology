package Project2;

/**
 * @author Nicholas Triano, Antonio Ignarra
 */
public class NonResident extends Student {

    public NonResident(Profile profile, int credits, double tuitionDue, String lastPaymentDate, double totalPayment) {
        super(profile, credits, tuitionDue, lastPaymentDate, tuitionDue);
    }

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

    @Override
    public String toString() {
        String formattedString = profile + ":" + credits +
                " credit hours:tuition due:" + tuitionDue + ":total payment:" + totalPayment +
                "payment date:" + lastPaymentDate + ":non-resident";
        return formattedString;
    }

}
