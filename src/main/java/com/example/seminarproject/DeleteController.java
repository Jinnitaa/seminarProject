package com.example.seminarproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class DeleteController {
    //Text Field
    @FXML
    private TextField id;

    // When user click on delete
    public void DeleteButtonSetOnAction(ActionEvent event) {

        DBUtils.deleteSeminar(event, Integer.parseInt(id.getText()));
        Alert alert= new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Seminar have been deleted from the record");
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