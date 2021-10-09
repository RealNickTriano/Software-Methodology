package Project2;

/**
 * @author Nicholas Triano, Antonio Ignarra
 */
public class Student {

    protected Profile profile;
    protected int credits;
    protected int tuitionRemissions;

    public Student(Profile profile, int credits, int tuitionRemissions) {
        this.profile = profile;
        this.credits = credits;
        this.tuitionRemissions = tuitionRemissions;
    }

    public void tuitionDue(){

    }

    @Override
    public String toString() {
        string formattedString = profile.getName() + ":" + profile.getMajor() + ":" + credits +
                "credit hours:tuition due:" + this.tuitionDue();
        return formattedString;
    }

}
