package com.example.project3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;

public class HelloController {
    @FXML
    private Label systemText;
    @FXML
    private DialogPane systemDialog;
    @FXML
    private TextField name;
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
    private ToggleGroup residentGroup;
    @FXML
    private ToggleGroup triStateGroup;
    @FXML
    private CheckBox studyAbroad;

    private String studentName;
    private Major studentMajor;
    private int studentCredits;
    private double tuitionDueAmount;
    private String lastPaymentDate;
    private double totalPayment;
    private RadioButton selectedButton;
    private String statusString;
    private String state;
    private Profile studentProfile;
    private Student[] studentArray;
    private Roster studentRoster = new Roster(studentArray, 0);


    @FXML
    protected void onHelloButtonClick() {
        systemText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    protected  void handleTristateSelected()
    {
            newYork.setOpacity(1.0);
            newYork.setDisable(false);
            connecticut.setOpacity(1.0);
            connecticut.setDisable(false);
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

        studentName = name.getText();
        selectedButton = (RadioButton) majorGroup.getSelectedToggle();
        studentMajor = Major.valueOf(selectedButton.getText());
        selectedButton = (RadioButton) residentGroup.getSelectedToggle();
        statusString = selectedButton.getText();
        try
        {
            studentCredits = Integer.parseInt(creditHours.getText());
        }
        catch(NumberFormatException e)
        {
            // int exception
            systemDialog.setContentText("Credit Hours must be a number.");

        }

        studentProfile = new Profile(studentName, studentMajor);

        if (tristateButton.isSelected())

        {
            if (newYork.isSelected())
                state = "NY";
            else if(connecticut.isSelected())
                state = "CT";

            TriState student = new TriState(studentProfile, studentCredits, state, 0,
                    "--/--/--", 0);

            System.out.println("Created new Tristate object.");

            studentRoster.add(student);
            studentRoster.print();
        }

        else if (international.isSelected())

        {
            International student = new International(studentProfile, studentCredits,
                    studyAbroad.isSelected(), 0,"--/--/--", 0);

            System.out.println("Created new International object.");

            studentRoster.add(student);
            studentRoster.print();        }

        else if (resident.isSelected())

        {
            Resident student = new Resident(studentProfile, studentCredits,
                    tuitionDueAmount, 0, "--/--/--", 0);

            System.out.println("Created new Resident object.");

            studentRoster.add(student);
            studentRoster.print();
        }

        else if (nonResident.isSelected())

        {
            NonResident student = new NonResident(studentProfile, studentCredits,
                    tuitionDueAmount, "--/--/--", 0);

            System.out.println("Created new Non-Resident object.");

            studentRoster.add(student);
            studentRoster.print();
        }




    }

    @FXML
    protected void handleRemoveStudent()
    {
        /** TODO: same thing as add
         * Remove student from roster
         * print msg to user
         */
    }

    @FXML
    protected void handleTuitionDue()
    {
        // TODO: Calculate tuition due for student and print to text field
        // print msg to user
    }

}