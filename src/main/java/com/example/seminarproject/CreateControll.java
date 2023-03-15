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
    private TextField date;
    @FXML
    private TextField venue ;

    // call method when user click on create
    public void createButtonSetOnAction(ActionEvent event) {
        // To check if all the textfield is not empty

        if(!topic.getText().trim().isEmpty() && !guest.getText().trim().isEmpty() && !date.getText().trim().isEmpty()&& !venue.getText().trim().isEmpty()){
            DBUtils.createSeminar(event,topic.getText(),guest.getText(),date.getText(),venue.getText());
        }
        else{
            System.out.println("Please fill in the information above");
            Alert alert= new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please fill in all the information to create");
            alert.show();
        }




    }

        public void cancelButtonSetOnAction(ActionEvent event){
            System.out.println("cancel");
        }


}