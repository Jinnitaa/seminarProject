package com.example.seminarproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class EditController {
    //Text Field
    @FXML
    private TextField topic;
    @FXML
    private TextField guest;

    @FXML
    private TextField date;
    @FXML
    private TextField venue ;
    // When user click on delete
    public void editButtonSetOnAction(ActionEvent event) {

        DBUtils.editSeminar(event,topic.getText(),guest.getText(),date.getText(),venue.getText());
        Alert alert= new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Seminar have been edited from the record");
        alert.show();
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
