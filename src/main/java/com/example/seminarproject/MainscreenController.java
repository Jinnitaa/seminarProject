package com.example.seminarproject;

import javafx.event.ActionEvent;

public class MainscreenController {

    // When user click on create button
    public void createButtonSetOnAction (ActionEvent event) {
        DBUtils.changeScene(event,"create_screen.fxml","Create", null);
    }
}
