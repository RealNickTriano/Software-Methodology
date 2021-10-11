package Project2;

/**
 * @author Nicholas Triano, Antonio Ignarra
 */
public class TriState extends NonResident {

    private String state;

    public TriState(Profile profile, int credits, String state, double totalPayment, double financialAid, Date lastPaymentDate, double lastPayment ) {
        super(profile, credits, totalPayment, financialAid, lastPaymentDate, lastPayment);
        this.state = state;
    }

    @Override
    public void tuitionDue(){

    }


    @Override
    public String toString() {
        String formattedString = profile + ":" + credits +
                " credit hours:tuition due:" + totalPayment + ":last payment:" + lastPayment +
                "payment date:" + lastPaymentDate + ":non-resident(tri-state):" + state;
        return formattedString;
    }


}
