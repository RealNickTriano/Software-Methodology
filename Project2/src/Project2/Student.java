package Project2;

/**
 * @author Nicholas Triano, Antonio Ignarra
 */
public class Student {

    protected Profile profile;
    protected int credits;
    protected double totalPayment;
    protected Date lastPaymentDate;
    protected  double lastPayment;

    public Student(Profile profile, int credits, double totalPayment, Date lastPaymentDate, double lastPayment) {
        this.profile = profile;
        this.credits = credits;
        this.totalPayment = totalPayment;
        this.lastPaymentDate = lastPaymentDate;
        this.lastPayment = lastPayment;
    }

    public void tuitionDue(){

    }

    @Override
    public String toString() {
        String formattedString = profile.getName() + ":" + profile.getMajor() + ":" + credits +
                "credit hours:tuition due:" + totalPayment;
        return formattedString;
    }

}
