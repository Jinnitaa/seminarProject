package com.example.seminarproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    //field
    @FXML
    private Button cancelButton;
    @FXML
    private Label message;
    @FXML
    private TextField username_login;
    @FXML
    private TextField email_login;
    @FXML
    private PasswordField login_password;

    //for picture
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){}

    //cancle Button
    public void cancelButtonOnAction(ActionEvent event){
        Stage stage=(Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    // method login
    public void loginButtonOnAction(ActionEvent event){
        if(username_login.getText().isBlank()==false && email_login.getText().isBlank()==false && login_password.getText().isBlank()==false){
            validateLogin();
        }
        else{
            message.setText("Please fill in the text");
        }
    }

    //validate method
    public void validateLogin(){
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB= connectNow.getConnection();
        String verifyLogin="SELECT Count(1) From javafx.admin WHERE username='" + username_login.getText() +" ' AND password='"+login_password.getText() +" ' ";
        try{
            Statement statement=connectDB.createStatement();
            ResultSet queryResult= statement.executeQuery(verifyLogin);
            while(queryResult.next()){
                if(queryResult.getInt(1)==1){
                    message.setText("Congrats! You in");
                }
                else{
                    message.setText("Invalid, Please try to login again");
                }
            }

        }
        catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }

    }

}