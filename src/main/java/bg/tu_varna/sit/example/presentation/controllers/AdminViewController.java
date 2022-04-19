package bg.tu_varna.sit.example.presentation.controllers;

import bg.tu_varna.sit.example.application.HelloApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AdminViewController {

    @FXML
    Button btnBackAdminId, btnAdminHireId, btnAdminFireId, bpratka, bkyrier, bklient, register;

    public void courierJobDone() throws Exception {

        FXMLLoader root = new FXMLLoader(HelloApplication.class.getResource("/bg/tu_varna/sit/example/presentation.views/admin-view-jobdonecourier.fxml"));

        Stage window = (Stage) bkyrier.getScene().getWindow();
        window.setScene(new Scene(root.load(), 605, 385));
    }

    public void adminHire() throws Exception {

        FXMLLoader root = new FXMLLoader(HelloApplication.class.getResource("/bg/tu_varna/sit/example/presentation.views/admin-view-hire.fxml"));

        Stage window = (Stage) btnAdminHireId.getScene().getWindow();
        window.setScene(new Scene(root.load(), 605, 385));
    }

    public void adminFire() throws Exception {

        FXMLLoader root = new FXMLLoader(HelloApplication.class.getResource("/bg/tu_varna/sit/example/presentation.views/admin-view-fire.fxml"));

        Stage window = (Stage) btnAdminFireId.getScene().getWindow();
        window.setScene(new Scene(root.load(), 605, 385));
    }

    public void backAdmin() throws Exception {

        FXMLLoader root = new FXMLLoader(HelloApplication.class.getResource("/bg/tu_varna/sit/example/presentation.views/mainpage.fxml"));

        Stage window = (Stage) btnBackAdminId.getScene().getWindow();
        window.setScene(new Scene(root.load(), 605, 385));
    }

    public void orderStatistics() throws Exception {

        FXMLLoader root = new FXMLLoader(HelloApplication.class.getResource("/bg/tu_varna/sit/example/presentation.views/admin-view-statistics.fxml"));

        Stage window = (Stage) bpratka.getScene().getWindow();
        window.setScene(new Scene(root.load(), 605, 385));
    }


    public void Reg() throws Exception {

        FXMLLoader root = new FXMLLoader(HelloApplication.class.getResource("/bg/tu_varna/sit/example/presentation.views/admin-view-registerclient.fxml"));

        Stage window = (Stage) register.getScene().getWindow();
        window.setScene(new Scene(root.load(), 605, 385));
    }
}
