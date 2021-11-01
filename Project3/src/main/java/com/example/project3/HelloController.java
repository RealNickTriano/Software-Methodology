package com.example.project3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;

public class HelloController {
    @FXML
    private Label systemText;
    @FXML
    private TextArea systemDialog;
    @FXML
    private TextField name;
    @FXML
    private TextField paymentName;
    @FXML
    private RadioButton tristateButton;
    @FXML
    private RadioButton newYork;
    @FXML
    private RadioButton connecticut;
    @FXML
    private RadioButton international;
    @FXML
    private RadioButton resident;
    @FXML
    private RadioButton nonResident;
    @FXML
    private TextField creditHours;
    @FXML
    private Button addStudent;
    @FXML
    private Button removeStudent;
    @FXML
    private Button tuitionDue;
    @FXML
    private TextField tuitionAmount;
    @FXML
    private ToggleGroup majorGroup;
    @FXML
    private ToggleGroup paymentMajorGroup;
    @FXML
    private ToggleGroup residentGroup;
    @FXML
    private ToggleGroup triStateGroup;
    @FXML
    private CheckBox studyAbroad;
    @FXML
    private Button pay;
    @FXML
    private Button setFinAid;
    @FXML
    private TextField paymentAmount;
    @FXML
    private TextField financialAid;
    @FXML
    private DatePicker paymentDatePicker;
    @FXML
    private Button printStudents;
    @FXML
    private Button printByName;
    @FXML
    private Button printByPayment;

    private String studentName;
    private Major studentMajor;
    private int studentCredits;
    private double tuitionDueAmount;
    private String lastPaymentDate;
    private double currentPayment;
    private double totalPayment;
    private RadioButton selectedButton;
    private String statusString;
    private Date paymentDate;
    private String paymentDateString;
    private String state;
    private Profile studentProfile;
    private Double financialAidAmount;
    private Student[] studentArray;
    private Roster studentRoster = new Roster(studentArray, 0);
    private boolean tuition = false;


    public int setValues()
    {
        studentName = name.getText();
        if (studentName == "") {
            systemDialog.appendText("Must enter a name.\n");
            return -1;
        }

        try {
            selectedButton = (RadioButton) majorGroup.getSelectedToggle();
            studentMajor = Major.valueOf(selectedButton.getText());
        }
        catch (Exception e) {
            systemDialog.appendText("Must select a major.\n");
        }

        try {
            selectedButton = (RadioButton) residentGroup.getSelectedToggle();
            statusString = selectedButton.getText();
        }
        catch (Exception e) {
            systemDialog.appendText("Must select a residency status.\n");
        }

        try {
            studentCredits = Integer.parseInt(creditHours.getText());
            if (studentCredits > 24 || studentCredits < 3) {
                systemDialog.appendText("Student must enroll in at least 3 credits and at most 24 credits.\n");
                return -1;
            }
        }
        catch(NumberFormatException e) {
            // int exception
            systemDialog.appendText("Credit Hours must be a number.\n");
            return -1;
        }

        tuitionDueAmount = Double.parseDouble(tuitionAmount.getText());
        return 1;

    }

    public void makeProfile()
    {
        studentProfile = new Profile(studentName, studentMajor);
    }

    public Student makeStudent()
    {
        makeProfile();
        Student student = new Student(studentProfile, 0, 0,
                "--/--/--", 0);
        if (tristateButton.isSelected()) {
            if (newYork.isSelected())
                state = "NY";
            else if(connecticut.isSelected())
                state = "CT";

            student = new TriState(studentProfile, studentCredits, state, tuitionDueAmount,
                    "--/--/--", 0);
            return student;
        }

        else if (international.isSelected()) {
            student = new International(studentProfile, studentCredits,
                    studyAbroad.isSelected(), tuitionDueAmount,"--/--/--", 0);
            return student;
        }

        else if (resident.isSelected()) {
            student = new Resident(studentProfile, studentCredits,
                    tuitionDueAmount, 0, "--/--/--", 0);
            return student;
        }

        else if (nonResident.isSelected()) {
            student = new NonResident(studentProfile, studentCredits,
                    tuitionDueAmount, "--/--/--", 0);
            return student;
        }
        return student;
    }

    @FXML
    protected  void handleNonResidentSelected()
    {
        tristateButton.setOpacity(1.0);
        tristateButton.setDisable(false);
        international.setOpacity(1.0);
        international.setDisable(false);
        newYork.setDisable(true);
        newYork.setOpacity(0.5);
        newYork.setSelected(false);
        connecticut.setDisable(true);
        connecticut.setOpacity(0.5);
        connecticut.setSelected(false);
        studyAbroad.setDisable(true);
        studyAbroad.setOpacity(0.5);
        studyAbroad.setSelected(false);

    }

    @FXML
    protected  void handleResidentSelected()
    {
        tristateButton.setSelected(false);
        international.setSelected(false);
        studyAbroad.setOpacity(0.5);
        studyAbroad.setDisable(true);
        studyAbroad.setSelected(false);
        newYork.setSelected(false);
        newYork.setOpacity(0.5);
        newYork.setDisable(true);
        connecticut.setSelected(false);
        connecticut.setOpacity(0.5);
        connecticut.setDisable(true);
    }

    @FXML
    protected  void handleTristateSelected()
    {
            newYork.setOpacity(1.0);
            newYork.setDisable(false);
            connecticut.setOpacity(1.0);
            connecticut.setDisable(false);
            studyAbroad.setSelected(false);
            studyAbroad.setOpacity(0.5);
            studyAbroad.setDisable(true);
    }

    @FXML
    protected  void handleInternationalSelected()
    {
            newYork.setOpacity(0.5);
            newYork.setDisable(true);
            newYork.setSelected(false);
            connecticut.setOpacity(0.5);
            connecticut.setDisable(true);
            connecticut.setSelected(false);
            studyAbroad.setDisable(false);
            studyAbroad.setOpacity(1);
    }

    @FXML
    protected void handleAddStudent(ActionEvent event)
    {
        /**TODO: get student name as a string from text field
         * get major as enum from button group
         * get status from button group
         * get credit hours from text field catch non-integers
         * add student to roster
         * print msg to user
        */

        if(setValues() == 1) {
            if(!tuition) {
                systemDialog.appendText("Tuition must be calculated.\n");
                return;
            }
            tuition = false;
            Student student = makeStudent();

            if (studentRoster.add(student)) {
                systemDialog.appendText("Student added.\n");
                studentRoster.print();
            }
            else {
                systemDialog.appendText("Student already in Roster.\n");
            }
        }

        else {
            return;
        }

    }

    @FXML
    protected void handleRemoveStudent()
    {
        /** TODO: same thing as add
         * Remove student from roster
         * print msg to user
         */

        if(setValues() == 1) {
            Student student = makeStudent();
            if (studentRoster.remove(student)) {
                systemDialog.appendText("Student removed.\n");
                studentRoster.print();
            } else {
                systemDialog.appendText("Student is not on the roster.\n");
            }

        }
        else{
            return;
        }

    }

    @FXML
    protected void handleTuitionDue()
    {
        // TODO: Calculate tuition due for student and print to text field
        tuition = true;
        setValues();
        Student student = makeStudent();
        student.tuitionDue();
        tuitionAmount.setText(String.valueOf(student.getTuitionDue()));
        tuitionDueAmount = Double.parseDouble(tuitionAmount.getText());
    }

    @FXML
    protected void handlePayment()
    {
            studentName = paymentName.getText();
            if (studentName == "") {
                systemDialog.appendText("Must enter a name.\n");
                return;
            }
            try {
                selectedButton = (RadioButton) paymentMajorGroup.getSelectedToggle();
                studentMajor = Major.valueOf(selectedButton.getText());
            }
            catch (Exception e){
                systemDialog.appendText("Must select a major to make a payment.\n");
                return;
            }
            try {
                currentPayment = Double.parseDouble(paymentAmount.getText());
            }
            catch (Exception e){
                systemDialog.appendText("Must enter a valid payment.\n");
                return;
            }
            try {
                paymentDateString = paymentDatePicker.getValue().toString();
                paymentDate = new Date(paymentDateString);
            }
            catch (Exception e){
                systemDialog.appendText("Must enter a valid date.\n");
                return;
            }
            if (!paymentDate.isValid())
            {
                systemDialog.appendText("Invalid Date.\n");
                return;
            }
            else {
                makeProfile();
                Student currStudent = new Student(studentProfile, 0, 0, "--/--/--", 0 );
                if (studentRoster.exists(currStudent) == false){
                    systemDialog.appendText("Student is not on the roster.\n");
                }
                else {
                    // check if current payment + existing payments exceeds tuition due
                    if((studentRoster.pay(currentPayment, paymentDateString, studentRoster.find(currStudent))) == -1)
                    {
                        systemDialog.appendText("This payment is more than due.\n");
                    }
                    else
                    {
                        systemDialog.appendText("Payment Received.\n");
                    }

                }
            }
    }

    @FXML
    protected void handleSetFinancialAid()
    {
        financialAidAmount = Double.parseDouble(financialAid.getText());

        studentName = paymentName.getText();
        if (studentName == "") {
            systemDialog.appendText("Must enter a name.\n");
            return;
        }

        selectedButton = (RadioButton) paymentMajorGroup.getSelectedToggle();
        studentMajor = Major.valueOf(selectedButton.getText());

        makeProfile();
        Student student = new Student(studentProfile, 0, 0, "--/--/--", 0);

        if(studentRoster.exists(student)) {
            if(financialAidAmount <= 0) {
                systemDialog.appendText("Financial Aid must be more than 0.\n");
                return;
            }
            else if(studentRoster.isResident(student) && financialAidAmount > 10000.00) {
                systemDialog.appendText("Financial Aid exceeds maximum.\n");
                return;
            }
            else if(studentRoster.isNY(student)) {
                systemDialog.appendText("New York students automatically receive $4000 in financial aid.\n");
                return;
            }
            else if(studentRoster.isCT(student)) {
                systemDialog.appendText("Connecticut students automatically receive $5000 in financial aid.\n");
                return;
            }
            else if(studentRoster.isInternational(student)) {
                systemDialog.appendText("International students cannot receive financial aid.\n");
                return;
            }
            int index = studentRoster.find(student);
            int error = studentRoster.setFinancialAid(financialAidAmount, index);
            if(error == -1) {
                systemDialog.appendText("Financial Aid already set for this student.\n");
                return;
            }
            else if (error == -1) {
                systemDialog.appendText("Financial Aid is more than due.\n");
                return;
            }
            systemDialog.appendText("Financial Aid of $" + financialAidAmount + " awarded to " + studentName);
            studentRoster.print();
        }
        else {
            systemDialog.appendText("This student is not in the roster.\n");
            return;
        }
    }

    //TODO: Change Roster methods to return a String
    @FXML
    protected void handlePrintStudents()
    {
        if(studentRoster.print().equalsIgnoreCase("")) {
            systemDialog.appendText("Student Roster is empty.\n");
        }
        else {
            systemDialog.appendText("Printing the roster by insertion order...\n");
            systemDialog.appendText(studentRoster.print());
        }
    }

    @FXML
    protected void handlePrintByName()
    {
        if(studentRoster.print().equalsIgnoreCase("")) {
            systemDialog.appendText("Student Roster is empty.\n");
        }
        else {
            systemDialog.appendText("Printing by name...\n");
            systemDialog.appendText(studentRoster.printByNames());
        }
    }

    @FXML
    protected void handlePrintByPaymentDate()
    {
        if(studentRoster.print().equalsIgnoreCase("")) {
            systemDialog.appendText("Student Roster is empty.\n");
        }
        else {
            systemDialog.appendText("Printing in order of most recent payment date...\n");
            systemDialog.appendText(studentRoster.printByPaymentDate());
        }
    }

}