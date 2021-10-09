package Project2;

/**
 * @author Nicholas Triano, Antonio Ignarra
 */
public class Resident extends Student {

    protected double financialAid;

    public Resident(Profile profile, int credits, double totalPayment, double financialAid, Date lastPaymentDate) {
        super(profile, credits, totalPayment, lastPaymentDate);
        this.financialAid = financialAid;
    }

    @Override
    public void tuitionDue() {

        if ( credits < Constants.MINIMUM_FULL_TIME_CREDITS )
        {
            totalPayment = (Constants.NONRESIDENT_COST_PER_CREDIT * credits) + Constants.PART_TIME_UNIVERSITY_FEE;
        }
        else if ( credits > Constants.CREDITS_FOR_ADDITIONAL_TUITION)
        {
            totalPayment = (Constants.RESIDENT_TUITION + Constants.UNIVERSITY_FEE) +
                    (Constants.RESIDENT_COST_PER_CREDIT * (credits - Constants.CREDITS_FOR_ADDITIONAL_TUITION));
        }
        else
            totalPayment = Constants.RESIDENT_TUITION + Constants.UNIVERSITY_FEE - financialAid;

    }

    @Override
    public String toString() {
        String formattedString = profile.getName() + ":" + profile.getMajor() + ":" + credits +
                "credit hours:tuition due:" + totalPayment + "financial aid:" + financialAid;
        return formattedString;
    }

}
