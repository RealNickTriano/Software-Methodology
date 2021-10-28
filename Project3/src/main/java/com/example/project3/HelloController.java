package com.example.project3;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label systemText;
    private Label systemDialog;

    @FXML
    protected void onHelloButtonClick() {
        systemText.setText("Welcome to JavaFX Application!");
    }
}