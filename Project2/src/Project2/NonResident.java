package Project2;

/**
 * @author Nicholas Triano, Antonio Ignarra
 */
public class NonResident extends Student {

    public NonResident(Profile profile, int credits, int tuitionRemissions) {
        super(profile, credits, tuitionRemissions);
    }

    @Override
    public void tuitionDue() {

        int tuition = 0;

        if ( credits < 12 )
        {
            tuition = 966 * credits;
        }
        else if ( credits > 16)
        {
            tuition = (29737 + 3268) + (966 * (credits - 16));
        }
        else
            tuition = 29737 + 3268;

    }
}
