package com.example.seminarproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CreateControll {
    //Button field
    @FXML
    private Button cancelButton;

    @FXML

    //Text Field
    private TextField topic;
    @FXML
    private TextField guest;
    @FXML
    private TextField id;

    @FXML
    private TextField date;
    @FXML
    private TextField venue ;

    // call method when user click on create
    public void createButtonSetOnAction(ActionEvent event) {
        // To check if all the textfield is not empty

        if(!topic.getText().trim().isEmpty() && !guest.getText().trim().isEmpty() && !date.getText().trim().isEmpty()&& !venue.getText().trim().isEmpty()){
            DBUtils.createSeminar(event, Integer.parseInt(id.getText()),topic.getText(),guest.getText(),date.getText(),venue.getText());
            Alert alert= new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Your information have been recorded");
            alert.show();
        }
        else{
            System.out.println("Please fill in the information above");
            Alert alert= new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please fill in all the information to create");
            alert.show();
        }




    }

    // when user click on back button

        public void BackButtonSetOnAction(ActionEvent event){
            DBUtils.changeScene(event,"main_screen.fxml","Main Screen", null);
        }

    // when user click on view button
    public void ViewButtonSetOnAction(ActionEvent event){
        DBUtils.changeScene(event,"view_screen.fxml","View Screen", null);
    }




}
