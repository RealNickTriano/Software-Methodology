package Project2;

/**
 * Used to create Student
 * Create Student with profile, credits, tuitionDue, lastPaymentDate, totalPayment
 * tuitionDue() and toString() methods are overwritten
 * @author Nicholas Triano, Antonio Ignarra
 */
public class Student {

    protected Profile profile;
    protected int credits;
    protected double tuitionDue;
    protected String lastPaymentDate;
    protected  double totalPayment;

    /**
     * Constructor for Student class, creates a new Student object with given parameters
     * @param profile profile of the Student
     * @param credits number of credit hours student has
     * @param tuitionDue amount of tuition due
     * @param lastPaymentDate the date of the latest payment submitted
     * @param totalPayment total amount paid by the student
     */
    public Student(Profile profile, int credits, double tuitionDue, String lastPaymentDate, double totalPayment) {
        this.profile = profile;
        this.credits = credits;
        this.tuitionDue = tuitionDue;
        this.lastPaymentDate = lastPaymentDate;
        this.totalPayment = totalPayment;
    }

    /**
     * Allows other classes to set the totalPayment
     * @param totalPayment total amount paid by the student
     */
    public void setTotalPayment(double totalPayment)
    {
        this.totalPayment += totalPayment;
    }

    /**
     * Allows other classes to set lastPaymentDate
     * @param date the date the student had last made a payment
     */
    public void setLastPaymentDate(String date)
    {
        this.lastPaymentDate = date;
    }

    /**
     * Allows other classes to set the tuitionDue
     * @param totalPayment total amount paid by the student
     */
    public void setTuitionDue( double totalPayment )
    {
        this.tuitionDue -= totalPayment;
    }

    /**
     * Does nothing, to be overridden by subclasses
     */
    public void tuitionDue(){

    }

    /**
     * Formats Student object into a string for use in output
     * @return formattedString the Student class in String format
     */
    @Override
    public String toString() {
        String formattedString = profile.getName() + ":" + profile.getMajor() + ":" + credits +
                "credit hours:tuition due:" + tuitionDue;
        return formattedString;
    }

}
