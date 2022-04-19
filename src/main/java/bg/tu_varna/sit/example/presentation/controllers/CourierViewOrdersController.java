package bg.tu_varna.sit.example.presentation.controllers;

import bg.tu_varna.sit.example.application.HelloApplication;
import bg.tu_varna.sit.example.data.access.SQLClass;
import bg.tu_varna.sit.example.data.entities.Poruchki;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.util.List;

public class CourierViewOrdersController {

    @FXML
    Button btnBackCorierViewId;

    @FXML
    ComboBox<Poruchki> comboPoruchki;
    @FXML
    Label adres;
    @FXML
    Label opisanie;
    @FXML
    Label data;
    @FXML
    Label status;

    public void initialize(){
        List<Poruchki> poruchki = SQLClass.getPoruchki();
        comboPoruchki.setItems(FXCollections.observableArrayList(poruchki));
    }

    public void poruchkiAction(){
        opisanie.setText(comboPoruchki.getValue().poruchka);
        adres.setText(comboPoruchki.getValue().adres);
        data.setText(comboPoruchki.getValue().data.toString());

    }

    public void curierRecieve(){
        SQLClass.curierRecieve(comboPoruchki.getValue().id);
        SQLClass.Prieti(comboPoruchki.getValue().id_klient);
    }
    public void curierNotRecieved(){
        SQLClass.curierNotRecieved(comboPoruchki.getValue().id);

    }
    public void cancelOrder(){
        SQLClass.cancelOrder(comboPoruchki.getValue().id);
        SQLClass.nePrieti(comboPoruchki.getValue().id_klient);
    }

    public void backCorierView() throws Exception {

        FXMLLoader root = new FXMLLoader(HelloApplication.class.getResource("/bg/tu_varna/sit/example/presentation.views/courier-view.fxml"));

        Stage window = (Stage) btnBackCorierViewId.getScene().getWindow();
        window.setScene(new Scene(root.load(), 605, 385));
    }


}
