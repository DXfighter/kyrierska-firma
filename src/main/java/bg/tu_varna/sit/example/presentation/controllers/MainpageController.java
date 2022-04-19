package bg.tu_varna.sit.example.presentation.controllers;

import bg.tu_varna.sit.example.application.HelloApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainpageController {

    @FXML
    Button btnAdministratorLogInId, btnCourierLogInId;

    public void administratorLogIn() throws Exception {

        FXMLLoader root = new FXMLLoader(HelloApplication.class.getResource("/bg/tu_varna/sit/example/presentation.views/adminlogin.fxml"));

        Stage window = (Stage) btnAdministratorLogInId.getScene().getWindow();
        window.setScene(new Scene(root.load(), 605, 385));
    }

    public void courierLogIn() throws Exception {

        FXMLLoader root = new FXMLLoader(HelloApplication.class.getResource("/bg/tu_varna/sit/example/presentation.views/courierlogin.fxml"));

        Stage window = (Stage) btnCourierLogInId.getScene().getWindow();
        window.setScene(new Scene(root.load(), 605, 385));
    }


}
