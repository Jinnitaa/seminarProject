package com.example.seminarproject;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class SignUpController implements Initializable {
    // Button Field
    @FXML
    private Button SignupButton;
    @FXML
    private Button loginButton;
    @FXML
    private Button cancelButton;

    // Textfield
    private TextField username;
    @FXML
    private TextField email;

    @FXML
    private PasswordField password;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //Click on SignUp button
        SignupButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // To check if all the textfield is not empty
                if(!username.getText().trim().isEmpty() && !email.getText().trim().isEmpty() && !password.getText().trim().isEmpty()){
                    DBUtils.signUpUser(event,username.getText(),email.getText(),password.getText());
                }
                else{
                    System.out.println("Please fill in the information above");
                    Alert alert= new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Please fill in all the information to sign up");
                    alert.show();
                }
            }
        });
        // Click on log in Button
        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event,"Login-view.fxml","Log in", null);
            }
        });
        // Click on Cancel Button
        cancelButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage=(Stage) cancelButton.getScene().getWindow();
                stage.close();
            }
        });
    }
}
