package Project2;

/**
 * @author Nicholas Triano, Antonio Ignarra
 */
public class International  extends NonResident {

    public International(Profile profile, int credits, int tuitionRemissions) {
        super(profile, credits, tuitionRemissions);
    }

    @Override
    public void tuitionDue() {

        int tuition = Constants.INIT_INT;

        if ( credits < Constants.MINIMUM_FULL_TIME_CREDITS )
        {
            // Error international students cannot be part time
        }
        else if ( credits > Constants.CREDITS_FOR_ADDITIONAL_TUITION)
        {
            // Error international students cannot have more than 12 credits
        }
        else
            tuition = Constants.INTERNATIONAL_TUITION + Constants.UNIVERSITY_FEE +
                        Constants.INTERNATIONAL_ADDITIONAL_FEE;

    }
}
