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
    private TextField tuitionAmount1;
    @FXML
    private TextField financialAid;
    @FXML
    private DatePicker paymentDatePicker;

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


    public int setValues()
    {

        try{
            studentName = name.getText();
            if (studentName == "") {
                systemDialog.appendText("Must enter a name.\n");
                return -1;
            }
            selectedButton = (RadioButton) majorGroup.getSelectedToggle();
            studentMajor = Major.valueOf(selectedButton.getText());
            selectedButton = (RadioButton) residentGroup.getSelectedToggle();
            statusString = selectedButton.getText();
        }
        catch(Exception e)
        {
            systemDialog.appendText("Must select major and residency status.\n");
            return -1;
        }
        try
        {
            studentCredits = Integer.parseInt(creditHours.getText());
            tuitionDueAmount = Double.parseDouble(tuitionAmount.getText());
        }
        catch(NumberFormatException e)
        {
            // int exception
            systemDialog.appendText("Credit Hours must be a number.\n");
            return -1;
        }
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
        if (tristateButton.isSelected())

        {
            if (newYork.isSelected())
                state = "NY";
            else if(connecticut.isSelected())
                state = "CT";

            student = new TriState(studentProfile, studentCredits, state, tuitionDueAmount,
                    "--/--/--", 0);

            System.out.println("Created new Tristate object.");
            return student;

        }

        else if (international.isSelected())

        {
            student = new International(studentProfile, studentCredits,
                    studyAbroad.isSelected(), tuitionDueAmount,"--/--/--", 0);

            System.out.println("Created new International object.");
            return student;

        }

        else if (resident.isSelected())

        {
            student = new Resident(studentProfile, studentCredits,
                    tuitionDueAmount, 0, "--/--/--", 0);

            System.out.println("Created new Resident object.");
            return student;

        }

        else if (nonResident.isSelected())

        {
            student = new NonResident(studentProfile, studentCredits,
                    tuitionDueAmount, "--/--/--", 0);

            System.out.println("Created new Non-Resident object.");
            return student;

        }

        // Report error
        System.out.println("Error");
        return student;

    }

    @FXML
    protected  void handleNonResidentSelected()
    {
        tristateButton.setOpacity(1.0);
        tristateButton.setDisable(false);
        international.setOpacity(1.0);
        international.setDisable(false);
    }

    @FXML
    protected  void handleResidentSelected()
    {
        tristateButton.setOpacity(0.5);
        tristateButton.setDisable(true);
        tristateButton.setSelected(false);
        international.setOpacity(0.5);
        international.setDisable(true);
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
            Student student = makeStudent();

            if (studentRoster.add(student)) {
                systemDialog.appendText("Student added.\n");
                studentRoster.print();
            } else {
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
        // print msg to user
        setValues();
        Student student = makeStudent();
        student.tuitionDue();
        tuitionAmount.setText(String.valueOf(student.getTuitionDue()));
        tuitionDueAmount = Double.parseDouble(tuitionAmount.getText());
    }

    @FXML
    protected void handlePayment()
    {
        //try {
            studentName = paymentName.getText();
            if (studentName == "") {
                systemDialog.appendText("Must enter a name.\n");
                return;
            }
            selectedButton = (RadioButton) paymentMajorGroup.getSelectedToggle();
            studentMajor = Major.valueOf(selectedButton.getText());
            tuitionDueAmount = Double.parseDouble(tuitionAmount1.getText());
            paymentDateString = paymentDatePicker.getValue().toString();
            System.out.println(paymentDateString);
            paymentDate = new Date(paymentDateString);

            if (!(paymentDate.isValid()))
            {
                systemDialog.appendText("Invalid Date.\n");
            }


       // }
        //catch (Exception e){
            //systemDialog.appendText("Must enter all data fields.\n");
       // }


    }

    @FXML
    protected void handleSetFinancialAid()
    {

    }

}