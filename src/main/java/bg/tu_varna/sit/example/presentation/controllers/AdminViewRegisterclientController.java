package bg.tu_varna.sit.example.presentation.controllers;

import bg.tu_varna.sit.example.application.HelloApplication;
import bg.tu_varna.sit.example.data.access.SQLClass;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AdminViewRegisterclientController {

    @FXML
    Button btnRegisterClientId, btnBackAdminViewId;
    @FXML
    TextField imekl;

    public void Register() throws Exception{

        SQLClass.registerClient(imekl.getText());

        imekl.setText("");

    }

    public void backAdminView() throws Exception {

        FXMLLoader root = new FXMLLoader(HelloApplication.class.getResource("/bg/tu_varna/sit/example/presentation.views/admin-view.fxml"));

        Stage window = (Stage) btnBackAdminViewId.getScene().getWindow();
        window.setScene(new Scene(root.load(), 605, 385));
    }
}

