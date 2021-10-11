package Project2;

/**
 * @author Nicholas Triano, Antonio Ignarra
 */
public class TriState extends NonResident {

    private String state;

    public TriState(Profile profile, int credits, String state, double totalPayment, double financialAid, Date lastPaymentDate ) {
        super(profile, credits, totalPayment, financialAid, lastPaymentDate);
        this.state = state;
    }

    @Override
    public void tuitionDue(){

    }


    @Override
    public String toString() {
        String formattedString = profile.getName() + ":" + profile.getMajor() + ":" + credits +
                "credit hours:tuition due:" + totalPayment + "non-resident(tri-state):" + state;
        return formattedString;
    }


}
