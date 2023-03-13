package com.example.seminarproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class LogController {
    //Button field
    @FXML
    private Button cancelButton;

    @FXML

    //Text Field
    private TextField username;
    @FXML
    private TextField email;

    @FXML
    private PasswordField password;

        // Click on Login Button

        public void loginButtonSetOnAction(ActionEvent event){
            DBUtils.loginUser(event,username.getText(),email.getText(),password.getText());
        }
        // Click on SignUp Button

            public void signupSetOnAction(ActionEvent event) {
                DBUtils.changeScene(event,"Sign-view.fxml","SignUP",null);

            }
        // Click on Cancel Button

            public void cancelButtonSetOnAction(ActionEvent event) {
                Stage stage=(Stage) cancelButton.getScene().getWindow();
                stage.close();
            }
    }

