package Project2;

/**
 * @author Nicholas Triano, Antonio Ignarra
 */
public class Student {

    protected Profile profile;
    protected int credits;
    protected int totalPayment;
    protected Date lastPaymentDate;

    public Student(Profile profile, int credits, int totalPament, Date lastPaymentDateate) {
        this.profile = profile;
        this.credits = credits;
        this.totalPayment = totalPament;
        this.lastPaymentDate = lastPaymentDateate;
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
