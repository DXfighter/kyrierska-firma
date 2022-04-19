package bg.tu_varna.sit.example.presentation.controllers;

import bg.tu_varna.sit.example.application.HelloApplication;
import bg.tu_varna.sit.example.common.Utils;
import bg.tu_varna.sit.example.data.access.SQLClass;
import bg.tu_varna.sit.example.data.entities.Client;
import bg.tu_varna.sit.example.data.entities.Poruchki;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class ClientStatusController {

    @FXML
    Button btnBackStatusId;

    @FXML
    ListView<Poruchki> list;
    @FXML
    ComboBox<Client> clientCombo;

    public void initialize(){
        ArrayList<Client> user =  SQLClass.getClient();
        clientCombo.setItems(FXCollections.observableArrayList(user));

    }
    public void Go() throws Exception {
        int client = clientCombo.getValue().id;

        List<Poruchki> poruchki = SQLClass.getPoruchki();
        List<Poruchki> filter = Utils.filterClient(poruchki, client);
        list.setItems(FXCollections.observableArrayList(filter));

    }


    public void BackStatus() throws Exception {

        FXMLLoader root = new FXMLLoader(HelloApplication.class.getResource("/bg/tu_varna/sit/example/presentation.views/courier-view.fxml"));

        Stage window = (Stage) btnBackStatusId.getScene().getWindow();
        window.setScene(new Scene(root.load(), 605, 385));
    }

}
