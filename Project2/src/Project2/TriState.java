package Project2;

/**
 * @author Nicholas Triano, Antonio Ignarra
 */
public class TriState extends NonResident {

    private String state;

    public TriState(Profile profile, int credits, int tuitionRemissions, String state) {
        super(profile, credits, tuitionRemissions);
        this.state = state;
    }

    @Override
    public void tuitionDue(){



    }


    @Override
    public String toString() {
        string formattedString = profile.getName() + ":" + profile.getMajor() + ":" + credits +
                "credit hours:tuition due:" + this.tuitionDue() + "non-resident(tri-state):" + state;
        return formattedString;
    }


}
