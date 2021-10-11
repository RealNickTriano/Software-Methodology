package Project2;

/**
 * @author Nicholas Triano, Antonio Ignarra
 */
public class International  extends NonResident {

    private boolean studyAbroad;

    public International(Profile profile, int credits, boolean studyAbroad, double totalPayment, double financialAid, Date lastPaymentDate, double lastPayment) {
        super(profile, credits, totalPayment, financialAid, lastPaymentDate, lastPayment);
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

        String formattedString;
        if(studyAbroad) {
            formattedString = profile + ":" + credits +
                    " credit hours:tuition due:" + totalPayment + ":last payment:" + lastPayment +
                    "payment date:" + lastPaymentDate + ":non-resident:international:study abroad";
        }
        else {
            formattedString = profile + ":" + credits +
                    " credit hours:tuition due:" + totalPayment + ":last payment:" + lastPayment +
                    "payment date:" + lastPaymentDate + ":non-resident:international";
        }
        return formattedString;

    }


}
