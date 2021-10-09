package Project2;

import com.sun.corba.se.impl.orbutil.closure.Constant;

/**
 * @author Nicholas Triano, Antonio Ignarra
 */
public class NonResident extends Student {

    public NonResident(Profile profile, int credits, int tuitionRemissions) {
        super(profile, credits, tuitionRemissions);
    }

    @Override
    public void tuitionDue() {

        double tuition = Constants.INIT_INT;

        if ( credits < Constants.MINIMUM_FULL_TIME_CREDITS )
        {
            tuition = (Constants.NONRESIDENT_COST_PER_CREDIT * credits) + Constants.PART_TIME_UNIVERSITY_FEE;
        }
        else if ( credits > Constants.CREDITS_FOR_ADDITIONAL_TUITION)
        {
            tuition = (Constants.NONRESIDENT_TUITION + Constants.UNIVERSITY_FEE) +
                    (Constants.NONRESIDENT_COST_PER_CREDIT * (credits - Constants.CREDITS_FOR_ADDITIONAL_TUITION));
        }
        else
            tuition = Constants.NONRESIDENT_TUITION + Constants.UNIVERSITY_FEE;

    }

    @Override
    public String toString() {
        string formattedString = profile.getName() + ":" + profile.getMajor() + ":" + credits +
                "credit hours:tuition due:" + this.tuitionDue() + "non-resident";
        return formattedString;
    }

}
