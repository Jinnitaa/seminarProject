package com.example.seminarproject;

import javafx.event.ActionEvent;

public class MainscreenController {

    // When user click on create button
    public void createButtonSetOnAction (ActionEvent event) {
        DBUtils.changeScene(event,"create_screen.fxml","Create", null);
    }
    // When user click on view button
    public void viewButtonSetOnAction (ActionEvent event){
        DBUtils.changeScene(event,"view_screen.fxml","View", null);
    }
    // When user click on delete button
    public void deleteButtonSetOnAction (ActionEvent event){
        DBUtils.changeScene(event,"delete_screen.fxml","Delete Screen", null);
    }
    // When user click on edit button
    public void editButtonSetOnAction (ActionEvent event){
        DBUtils.changeScene(event,"edit_screen.fxml","Edit Screen", null);
    }

}
