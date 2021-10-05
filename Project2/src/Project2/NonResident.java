package Project2;

/**
 * @author Nicholas Triano, Antonio Ignarra
 */
public class NonResident extends Student {

    public NonResident(Profile profile, int credits, int tuitionRemissions) {
        super(profile, credits, tuitionRemissions);
    }

    @Override
    public void tuitionDue() {

        int tuition = Constants.INIT_INT;

        if ( credits < Constants.MINIMUM_FULL_TIME_CREDITS )
        {
            tuition = Constants.NONRESIDENT_COST_PER_CREDIT * credits;
        }
        else if ( credits > Constants.CREDITS_FOR_ADDITIONAL_TUITION)
        {
            tuition = (Constants.NONRESIDENT_TUITION + Constants.UNIVERSITY_FEE) +
                    (Constants.NONRESIDENT_COST_PER_CREDIT * (credits - Constants.CREDITS_FOR_ADDITIONAL_TUITION));
        }
        else
            tuition = Constants.NONRESIDENT_TUITION + Constants.UNIVERSITY_FEE;

    }
}
