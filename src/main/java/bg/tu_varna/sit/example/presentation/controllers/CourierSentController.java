package bg.tu_varna.sit.example.presentation.controllers;

import bg.tu_varna.sit.example.application.HelloApplication;
import bg.tu_varna.sit.example.data.access.SQLClass;
import bg.tu_varna.sit.example.data.entities.Client;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class CourierSentController {
    
    
    @FXML
    Button btnBackBuyId;
    @FXML
    ComboBox<Client> clientCombo;
    @FXML
    ComboBox<String> vidPoruchka;
    @FXML
    TextField adres;
    @FXML
    TextArea poruchka;
    @FXML
    DatePicker data;
    @FXML
    TextField polychatel;
    @FXML
    TextField stat;

    public void initialize(){


        ArrayList<Client> user =  SQLClass.getClient();
        clientCombo.setItems(FXCollections.observableArrayList(user));

            List<String> types = SQLClass.getTypes();
        vidPoruchka.setItems(FXCollections.observableArrayList(types));
    }

    public void clientBuy() throws IOException {
        int client = clientCombo.getValue().id;
        int type = SQLClass.getTypeID(vidPoruchka.getValue());
        String tAdres = adres.getText();
        String tPoruchka = poruchka.getText();
        Date tData = Date.valueOf(data.getValue());
        String tPolychatel= polychatel.getText();
        String tStat= stat.getText();
        SQLClass.clientBuy(client, type, tAdres, tPoruchka, tData,tPolychatel,tStat);

        FXMLLoader root = new FXMLLoader(HelloApplication.class.getResource("/bg/tu_varna/sit/example/presentation.views/successful.fxml"));

        Parent root1 = (Parent) root.load();
        Stage stage = new Stage();

        stage.setTitle("Success!");
        stage.setScene(new Scene(root1, 250, 105));
        stage.show();

        adres.setText("");
        poruchka.setText("");
        polychatel.setText("");
        stat.setText("");
    }

    public void backBuy() throws Exception {

        FXMLLoader root = new FXMLLoader(HelloApplication.class.getResource("/bg/tu_varna/sit/example/presentation.views/courier-view.fxml"));

        Stage window = (Stage) btnBackBuyId.getScene().getWindow();
        window.setScene(new Scene(root.load(), 605, 385));
    }
}
