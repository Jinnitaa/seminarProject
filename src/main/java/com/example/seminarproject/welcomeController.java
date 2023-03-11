package com.example.seminarproject;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class welcomeController implements Initializable {
    @FXML
    private Button logoutButton;
    private Label welcome;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    logoutButton.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        //call in the DUBtils controller to change scene
        public void handle(ActionEvent event) {
        DBUtils.changeScene(event,"Login-view.fxml","Login",null);
        }
    });
    }
    // method to set user username on the screen of welcome page
    public void setUsername(String username){
        welcome.setText("Welcome "+ username);
    }

}
