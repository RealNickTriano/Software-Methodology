package Project2;

/**
 * @author Nicholas Triano, Antonio Ignarra
 */
public class Resident extends Student {

    public Resident(Profile profile, int credits, int tuitionRemissions) {
        super(profile, credits, tuitionRemissions);
    }

    @Override
    public void tuitionDue() {

        int tuition = Constants.INIT_INT;

        if ( credits < Constants.MINIMUM_FULL_TIME_CREDITS )
        {
            tuition = Constants.RESIDENT_COST_PER_CREDIT * credits;
        }
        else if ( credits > Constants.CREDITS_FOR_ADDITIONAL_TUITION)
        {
            tuition = (Constants.RESIDENT_TUITION + Constants.UNIVERSITY_FEE) +
                    (Constants.RESIDENT_COST_PER_CREDIT * (credits - Constants.CREDITS_FOR_ADDITIONAL_TUITION));
        }
        else
            tuition = Constants.RESIDENT_TUITION + Constants.UNIVERSITY_FEE;

    }
}
