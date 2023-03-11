package com.example.seminarproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;


public class DBUtils {
    public static void changeScene(ActionEvent event, String fxmlFile, String title, String username) {
        Parent root = null;
        // If they pass in the information
        if (username != null) {
            try {
                FXMLLoader loader = new FXMLLoader(DBUtils.class.getResource(fxmlFile));
                root = loader.load();
                welcomeController welcomeController1 = loader.getController();
                welcomeController1.setUsername(username);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        // If they are not that is means they want to change scene
        else {
            try {
                root = FXMLLoader.load(DBUtils.class.getResource(fxmlFile));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // Here we create a stage and a stage can have multiple scene .The scene is what we display in the window.
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle(title);
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }

    //method to signUp user
    public static void signUpUser(ActionEvent event, String username, String email, String password) {
        Connection connection = null;
        PreparedStatement psCheckUserExist = null;
        PreparedStatement psInsert = null;
        ResultSet resultSet = null;

        // Set up connection with our database in mysql
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/seminarsystem", "root", "Nytadbms12345");
            // To check if user is already exist in the database
            psCheckUserExist = connection.prepareStatement("SELECT *FROM admin WHERE username=?");// ? refer to what user fill in
            // To query the database
            psCheckUserExist.setString(1, username);
            // if the result set is empty that means user doesn't exist
            resultSet = psCheckUserExist.executeQuery();
            // isBeforeFirst is to check if the user is empty
            if (resultSet.isBeforeFirst()) {
                // if user already exist we execute the code below
                System.out.println("User already exist");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("You can't use this username");
                alert.show();
            }
            // if user hasn't existed yet , we will insert user to our database
            else {
                psInsert = connection.prepareStatement("INSERT INTO admin(username,email,password VALUES(?,?,?)");
                psInsert.setString(1, username);
                psInsert.setString(2, email);
                psInsert.setString(3, password);
                psInsert.executeUpdate();// To update the database

                //To change scene from login page to welcome page
                changeScene(event, "Login-view.fxml", "Welcome", username);
            }
        } catch (SQLException e) {
            e.printStackTrace();

            // This will help to free database resourse when user log out
        } finally {
            // check resultset if it is not null
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            // check pscheckUserExist if it is not null
            if (psCheckUserExist != null) {
                try {
                    psCheckUserExist.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            // check psInsert if it is not null
            if (psInsert != null) {
                try {
                    psInsert.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            // check connection if it is not null
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    // Method to login user
    public static void loginUser(ActionEvent event, String username, String email, String password) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        // Set up connection with our database in mysql
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/seminarsystem", "root", "Nytadbms12345");
            preparedStatement = connection.prepareStatement("SELECT email,password FROM admin WHERE username=?");
            preparedStatement.setString(1,username);
            resultSet=preparedStatement.executeQuery();

            // To check if user is in the database
            if(!resultSet.isBeforeFirst()){
                System.out.println("User is not found in the database");
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setContentText("The provided credential is incorrect");
                alert.show();
            }
            //If User found
            else {
                while (resultSet.next()) {
                    String storeEmail = resultSet.getString("email");
                    String storePassword = resultSet.getString("password");
                    // To compare the password of user and in the database
                    if(storePassword.equals(password)){
                        changeScene(event,"Login-view.fxml","Login",username);
                    }
                    else{
                        System.out.println("Password is incorrect");
                        Alert alert=new Alert(Alert.AlertType.ERROR);
                        alert.setContentText("The provided credential is incorrect");
                        alert.show();
                    }
                }


            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            {
                // check resultset if it is not null
                if (resultSet != null) {
                    try {
                        resultSet.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                // check if preparestatement is not null
                if (preparedStatement != null) {
                    try {
                        preparedStatement.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                // check connection if it is not null
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }
}
