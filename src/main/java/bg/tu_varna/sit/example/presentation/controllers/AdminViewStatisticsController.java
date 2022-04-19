package bg.tu_varna.sit.example.presentation.controllers;

import bg.tu_varna.sit.example.application.HelloApplication;
import bg.tu_varna.sit.example.data.access.SQLClass;
import bg.tu_varna.sit.example.data.entities.Client;
import bg.tu_varna.sit.example.data.entities.Poruchki;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.sql.Date;
import java.util.ArrayList;

public class AdminViewStatisticsController {
    @FXML
    Button  btnback;
    @FXML
    DatePicker data1,data2;
    @FXML
    ListView<Poruchki> poruchki;

    @FXML
    ListView<String> list;
    @FXML
    public void initialize(){
        ArrayList<Client> statsCl = SQLClass.getClientStatistics();
        ArrayList<String> statsClstrings = new ArrayList<String>();

        for(Client client : statsCl){
            statsClstrings.add(client.id +" Name: "+client.name + "  Prieti:" + client.prieti + "  Neprieti:" + client.neprieti);
        }
        list.setItems(FXCollections.observableArrayList(statsClstrings));
    }

    public void proverka() throws Exception {
        Date tData1 = Date.valueOf(data1.getValue());
        Date tData2 = Date.valueOf(data2.getValue());
        SQLClass.orderStatistics(tData1,tData2);

        ArrayList<Poruchki> test = SQLClass.orderStatistics(tData1,tData2);
        poruchki.setItems(FXCollections.observableArrayList(test));


    }

    public void back() throws Exception {

        FXMLLoader root = new FXMLLoader(HelloApplication.class.getResource("/bg/tu_varna/sit/example/presentation.views/admin-view.fxml"));

        Stage window = (Stage) btnback.getScene().getWindow();
        window.setScene(new Scene(root.load(), 605, 385));
    }

}
