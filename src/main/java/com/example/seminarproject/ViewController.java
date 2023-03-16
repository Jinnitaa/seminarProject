package com.example.seminarproject;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.*;


public class ViewController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<SeminarList> SeminarList;

    @FXML
    private TableColumn<SeminarList, String> date;

    @FXML
    private TableColumn<SeminarList, String> guest;

    @FXML
    private TableColumn<SeminarList, Integer> id;

    @FXML
    private TableColumn<SeminarList, String> topic;

    @FXML
    private TableColumn<SeminarList, String> venue;


    @FXML
    void initialize() throws ClassNotFoundException, SQLException {

            ObservableList<SeminarList> seminarLists = FXCollections.observableArrayList();
            ConnectionDB connectionDB = new ConnectionDB();
            Connection connection = connectionDB.getConnection();
            String sql = "SELECT id,topic,guest,date,venue FROM create_seminar";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {

                seminarLists.add(new SeminarList(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5)));
            }
            id.setCellValueFactory(new PropertyValueFactory<SeminarList, Integer>("id"));
            topic.setCellValueFactory(new PropertyValueFactory<SeminarList, String>("topic"));
            guest.setCellValueFactory(new PropertyValueFactory<SeminarList, String>("guest"));
            date.setCellValueFactory(new PropertyValueFactory<SeminarList, String>("date"));
            venue.setCellValueFactory(new PropertyValueFactory<SeminarList, String>("venue"));
      SeminarList.setItems(seminarLists);

    }public void BackButtonSetOnAction(ActionEvent event){
        DBUtils.changeScene(event,"main_screen.fxml","Main Screen", null);
    }
}


