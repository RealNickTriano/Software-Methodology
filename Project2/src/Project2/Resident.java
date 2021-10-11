package Project2;

/**
 * @author Nicholas Triano, Antonio Ignarra
 */
public class Resident extends Student {

    protected double financialAid;

    public Resident(Profile profile, int credits, double tuitionDue, double financialAid, String lastPaymentDate, double totalPayment) {
        super(profile, credits, tuitionDue, lastPaymentDate, totalPayment);
        this.financialAid = financialAid;
    }

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

    @Override
    public String toString() {
        String formattedString = profile + ":" + credits +
                " credit hours:tuition due:" + tuitionDue + ":total payment:" + totalPayment +
                "payment date:" + lastPaymentDate + ":resident";
        return formattedString;
    }

}
