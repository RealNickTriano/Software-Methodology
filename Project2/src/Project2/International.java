package Project2;

/**
 * @author Nicholas Triano, Antonio Ignarra
 */
public class International  extends NonResident {

    protected boolean studyAbroad;

    public International(Profile profile, int credits, boolean studyAbroad, double tuitionDue, String lastPaymentDate, double totalPayment) {
        super(profile, credits, tuitionDue, lastPaymentDate, totalPayment);
        this.studyAbroad = studyAbroad;
    }

    public void setStudyAbroad(boolean studyAbroad)
    {
        this.studyAbroad = studyAbroad;
    }

    public double getTuitionDue()
    {
        return tuitionDue;
    }
    @Override
    public void tuitionDue() {

        if ( credits < Constants.MINIMUM_FULL_TIME_CREDITS)
        {
            // Error international students cannot be part time
        }
        else if ( credits > Constants.MINIMUM_FULL_TIME_CREDITS && studyAbroad)
        {
            // Error international students in study abroad cannot have more than 12 credits
        }
        else if(studyAbroad)
        {
            tuitionDue = Constants.UNIVERSITY_FEE + Constants.INTERNATIONAL_ADDITIONAL_FEE;
        }
        else if( credits > Constants.CREDITS_FOR_ADDITIONAL_TUITION)
        {
            tuitionDue = Constants.INTERNATIONAL_TUITION + Constants.UNIVERSITY_FEE +
                    Constants.INTERNATIONAL_ADDITIONAL_FEE + (Constants.NONRESIDENT_COST_PER_CREDIT *
                    (credits - Constants.CREDITS_FOR_ADDITIONAL_TUITION));
        }
        else
            tuitionDue = Constants.INTERNATIONAL_TUITION + Constants.UNIVERSITY_FEE +
                        Constants.INTERNATIONAL_ADDITIONAL_FEE;

    }

    @Override
    public String toString() {

        String formattedString;
        if(studyAbroad) {
            formattedString = profile + ":" + credits +
                    " credit hours:tuition due:" + tuitionDue + ":total payment:" + totalPayment +
                    "payment date:" + lastPaymentDate + ":non-resident:international:study abroad";
        }
        else {
            formattedString = profile + ":" + credits +
                    " credit hours:tuition due:" + tuitionDue + ":total payment:" + totalPayment +
                    "payment date:" + lastPaymentDate + ":non-resident:international";
        }
        return formattedString;

    }


}
