package Project2;

/**
 * @author Nicholas Triano, Antonio Ignarra
 */
public class International  extends NonResident {

    private boolean studyAbroad;

    public International(Profile profile, int credits, int tuitionRemissions, boolean studyAbroad) {
        super(profile, credits, tuitionRemissions);
        this.studyAbroad = studyAbroad;
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

    @Override
    public String toString() {
        string formattedString = profile.getName() + ":" + profile.getMajor() + ":" + credits +
                "credit hours:tuition due:" + this.tuitionDue() + "study abroad:" + studyAbroad;
        return formattedString;
    }


}
