package Project2;

import com.sun.corba.se.impl.orbutil.closure.Constant;

/**
 * @author Nicholas Triano, Antonio Ignarra
 */
public class NonResident extends Student {
    protected double financialAid;

    public NonResident(Profile profile, int credits, double totalPayment, double financialAid, Date lastPaymentDate, double lastPayment) {
        super(profile, credits, totalPayment, lastPaymentDate, lastPayment);
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
            totalPayment = (Constants.NONRESIDENT_TUITION + Constants.UNIVERSITY_FEE) +
                    (Constants.NONRESIDENT_COST_PER_CREDIT * (credits - Constants.CREDITS_FOR_ADDITIONAL_TUITION));
        }
        else
            totalPayment = Constants.NONRESIDENT_TUITION + Constants.UNIVERSITY_FEE;

    }

    @Override
    public String toString() {
        String formattedString = profile + ":" + credits +
                " credit hours:tuition due:" + totalPayment + ":last payment:" + lastPayment +
                "payment date:" + lastPaymentDate + ":non-resident";
        return formattedString;
    }

}
