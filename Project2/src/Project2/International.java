package Project2;

/**
 * @author Nicholas Triano, Antonio Ignarra
 */
public class International  extends NonResident {

    private boolean studyAbroad;

    public International(Profile profile, int credits, boolean studyAbroad, double totalPayment, double financialAid, Date lastPaymentDate) {
        super(profile, credits, totalPayment, financialAid, lastPaymentDate);
        this.studyAbroad = studyAbroad;
    }

    @Override
    public void tuitionDue() {

        if ( credits < Constants.MINIMUM_FULL_TIME_CREDITS )
        {
            // Error international students cannot be part time
        }
        else if ( credits > Constants.CREDITS_FOR_ADDITIONAL_TUITION)
        {
            // Error international students cannot have more than 12 credits
        }
        else
            totalPayment = Constants.INTERNATIONAL_TUITION + Constants.UNIVERSITY_FEE +
                        Constants.INTERNATIONAL_ADDITIONAL_FEE;

    }

    @Override
    public String toString() {
        String formattedString = profile.getName() + ":" + profile.getMajor() + ":" + credits +
                "credit hours:tuition due:" + totalPayment + "study abroad:" + studyAbroad;
        return formattedString;
    }


}
