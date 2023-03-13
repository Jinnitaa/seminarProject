package com.example.seminarproject;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;

import javafx.scene.control.Label;



public class welcomeController  {


    @FXML
    private Label welcome;




        //call in the DUBtils controller to change scene
        public void logoutButtonSetOnAction (ActionEvent event) {
        DBUtils.changeScene(event,"Login-view.fxml","Login",null);
        }
    // method to set user username on the screen of welcome page
    public void setUsername(String username){
        welcome.setText("Welcome "+ username);
    }

}
