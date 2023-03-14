package com.example.seminarproject;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class ViewDetailController {
    @FXML
    private Button seminar1;
    @FXML
    private Button seminar2;
    @FXML
    private Button seminar3;

    @FXML
    protected void seminar1button() {
        seminar1.setText("Welcome to SEMINAR 1.");
    }
    @FXML
    protected void seminar2button() {
        seminar2.setText("Welcome to SEMINAR 2");
    }
    @FXML
    protected void seminar3button() {
        seminar3.setText("Welcome to SEMINAR 3");
    }

}