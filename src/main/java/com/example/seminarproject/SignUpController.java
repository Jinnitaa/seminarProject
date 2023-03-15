package com.example.seminarproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SignUpController {
    // Button Field
    @FXML
    private Button cancelButton;

    // Textfield
    @FXML
    private TextField username;
    @FXML
    private TextField email;

    @FXML
    private PasswordField password;


        //Click on SignUp button

            public void signupButtonSetOnAction(ActionEvent event) {
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
        // Click on log in Button

            public void loginButtonSetOnAction(ActionEvent event) {
                DBUtils.changeScene(event,"Login-view.fxml","Log in", null);
            }

        // Click on Cancel Button

            public void cancelButtonSetOnAction(ActionEvent event) {
                Stage stage=(Stage) cancelButton.getScene().getWindow();
                stage.close();
            }
    }

