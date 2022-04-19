package bg.tu_varna.sit.example.presentation.controllers;

import bg.tu_varna.sit.example.application.HelloApplication;
import bg.tu_varna.sit.example.common.Utils;
import bg.tu_varna.sit.example.data.access.SQLClass;
import bg.tu_varna.sit.example.data.entities.Courier;
import bg.tu_varna.sit.example.data.entities.Poruchki;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class AdminViewJobdonecourierController {
    @FXML
    Button btnBackAdminViewId,chek;
    @FXML
    DatePicker data01,data02;
    @FXML
    ComboBox <Courier> izbor;
    @FXML
    ListView<Poruchki> lists;
    @FXML
    Label porychkiId;
   @FXML
   public void initialize() {
       List<Courier> users = SQLClass.getCouriers();
       izbor.setItems(FXCollections.observableArrayList(users));
   }

    public void Chek() throws Exception {
        int courier = izbor.getValue().id;

        Date tData01 = Date.valueOf(data01.getValue());
        Date tData02 = Date.valueOf(data02.getValue());


        ArrayList<Poruchki> poruchki = SQLClass.getPoruchki();
        List<Poruchki> filter = Utils.filterJobDone(poruchki, courier, tData01, tData02);
        porychkiId.setText(String.valueOf(filter.size()));
        lists.setItems(FXCollections.observableArrayList(filter));

        }


    public void backAdminView() throws Exception {

        FXMLLoader root = new FXMLLoader(HelloApplication.class.getResource("/bg/tu_varna/sit/example/presentation.views/admin-view.fxml"));

        Stage window = (Stage) btnBackAdminViewId.getScene().getWindow();
        window.setScene(new Scene(root.load(), 605, 385));
    }
}
