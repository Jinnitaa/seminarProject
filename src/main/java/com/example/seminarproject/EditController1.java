package com.example.seminarproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class EditController1 {
    //Text Field
    @FXML
    private TextField topic;
    // When user click on delete
    public void Edit1ButtonSetOnAction(ActionEvent event) {

        DBUtils.editSeminar1(event,topic.getText());
        DBUtils.changeScene(event,"edit_screen.fxml","View Screen", null);
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
