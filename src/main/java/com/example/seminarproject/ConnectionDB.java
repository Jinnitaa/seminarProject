package com.example.seminarproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    Connection connection;


    public Connection getConnection() throws ClassNotFoundException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/seminarsystem", "root", "Nytadbms12345");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
