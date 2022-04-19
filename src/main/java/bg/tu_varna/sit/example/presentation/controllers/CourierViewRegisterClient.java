package bg.tu_varna.sit.example.presentation.controllers;

import bg.tu_varna.sit.example.application.HelloApplication;
import bg.tu_varna.sit.example.data.access.SQLClass;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CourierViewRegisterClient {
    @FXML
    TextField addcl;

    @FXML
    Button btnBackCourierViewId;
    public void add() throws Exception{

        SQLClass.registerClient(addcl.getText());

    }
    public void backCourierView() throws Exception {

        FXMLLoader root = new FXMLLoader(HelloApplication.class.getResource("/bg/tu_varna/sit/example/presentation.views/courier-view.fxml"));

        Stage window = (Stage) btnBackCourierViewId.getScene().getWindow();
        window.setScene(new Scene(root.load(), 605, 385));
    }
}
