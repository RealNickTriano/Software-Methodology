package Project2;

/**
 * @author Nicholas Triano, Antonio Ignarra
 */
public class Student {

    protected Profile profile;
    protected int credits;
    protected double tuitionDue;
    protected Date lastPaymentDate;
    protected  double totalPayment;

    public Student(Profile profile, int credits, double tuitionDue, Date lastPaymentDate, double totalPayment) {
        this.profile = profile;
        this.credits = credits;
        this.tuitionDue = tuitionDue;
        this.lastPaymentDate = lastPaymentDate;
        this.totalPayment = totalPayment;
    }

    public void setTotalPayment(double totalPayment)
    {
        this.totalPayment += totalPayment;
    }

    public void setLastPaymentDate(Date date)
    {
        this.lastPaymentDate = date;
    }

    public void setTuitionDue( double totalPayment )
    {
        this.tuitionDue -= totalPayment;
    }
    public void tuitionDue(){

    }

    @Override
    public String toString() {
        String formattedString = profile.getName() + ":" + profile.getMajor() + ":" + credits +
                "credit hours:tuition due:" + tuitionDue;
        return formattedString;
    }

}
