package com.example.seminarproject;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.lang.invoke.StringConcatException;
import java.net.URL;
import java.util.ResourceBundle;

public class EditView implements Initializable {

    @FXML
    private BorderPane rootPane;

    @FXML
    private AnchorPane centerPane;

    @FXML
    private Label editSeminarsLabel;

    @FXML
    private Label newnameLabel;

    @FXML
    private Label newDateLabel;

    @FXML
    private Label numberOfParticipantsLabel;

    @FXML
    private Label venueLabel;

    @FXML
    private TextField username_login;

    @FXML
    private TextField username_login1;

    @FXML
    private TextField username_login2;

    @FXML
    private TextField username_login3;

    @FXML
    private Button submitButton;

    @FXML
    private Button cancelButton;

    @FXML
    private AnchorPane leftPane;

    @FXML
    private Label seminarLabel1;

    @FXML
    private Label managementLabel;

    @FXML
    private Label systemLabel;

    public void initialize(URL url, ResourceBundle rb) {
    }


    public void Submit(javafx.event.ActionEvent actionEvent) {
        try {
            String newName = username_login.getText();
            String newDate = username_login1.getText();
            int newParticipantCount = Integer.parseInt(username_login2.getText());
            String newVenue = username_login3.getText();
            System.out.println("You have submitted new name: " + newName);
            System.out.println("You have submitted new date: " + newDate);
            System.out.println("You have submitted new participant count: " + newParticipantCount);
            System.out.println("You have submitted new venue: " + newVenue);
        } catch (NumberFormatException e) {
            System.out.println("Error: Participant count must be a number.");
        }

    }


    public void Cancel(javafx.event.ActionEvent actionEvent) {

        username_login.clear();
        username_login1.clear();
        username_login2.clear();
        username_login3.clear();
    }
}
