package Project2;

import com.sun.corba.se.impl.orbutil.closure.Constant;

/**
 * @author Nicholas Triano, Antonio Ignarra
 */
public class NonResident extends Student {

    public NonResident(Profile profile, int credits, double totalPayment, Date lastPaymentDate) {
        super(profile, credits, totalPayment, lastPaymentDate);
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
        String formattedString = profile.getName() + ":" + profile.getMajor() + ":" + credits +
                "credit hours:tuition due:" + totalPayment + "non-resident";
        return formattedString;
    }

}
