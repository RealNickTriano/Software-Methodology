package Project2;

/**
 * @author Nicholas Triano, Antonio Ignarra
 */
public class TriState extends NonResident {

    private String state;

    public TriState(Profile profile, int credits, String state, double tuitionDue, Date lastPaymentDate, double totalPayment ) {
        super(profile, credits, tuitionDue, lastPaymentDate, totalPayment);
        this.state = state;
    }

    @Override
    public void tuitionDue(){

    }


    @Override
    public String toString() {
        String formattedString = profile + ":" + credits +
                " credit hours:tuition due:" + tuitionDue + ":total payment:" + totalPayment +
                "payment date:" + lastPaymentDate + ":non-resident(tri-state):" + state;
        return formattedString;
    }


}
