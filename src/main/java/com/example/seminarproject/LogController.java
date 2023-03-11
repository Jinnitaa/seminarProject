package com.example.seminarproject;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class LogController implements Initializable {
    //Button field
    @FXML
    private Button cancelButton;
    @FXML
    private Button loginButton;
    @FXML
    private Button signupButton;
    @FXML

    //Text Field
    private TextField username;
    @FXML
    private TextField email;

    @FXML
    private PasswordField password;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        // Click on Login Button
    loginButton.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            DBUtils.loginUser(event,username.getText(),email.getText(),password.getText());
        }
    });

        // Click on SignUp Button
        signupButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event,"Sign-view.fxml","SignUP",null);

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
