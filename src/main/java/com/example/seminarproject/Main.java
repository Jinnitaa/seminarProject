package com.example.seminarproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root;
        root = FXMLLoader.load(getClass().getResource("Login-view.fxml"));
        stage.setTitle("Admin login");
        stage.setScene(new Scene(root,600,400));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}