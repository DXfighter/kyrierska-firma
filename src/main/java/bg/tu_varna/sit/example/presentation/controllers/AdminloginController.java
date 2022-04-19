package bg.tu_varna.sit.example.presentation.controllers;

import bg.tu_varna.sit.example.application.HelloApplication;
import bg.tu_varna.sit.example.data.access.SQLClass;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AdminloginController {

    @FXML
    Button btnAdminViewId, btnBackAdminLoginId;
    @FXML
    TextField logb;
    @FXML
    TextField pasb;

    public void adminView() throws Exception {

            if(SQLClass.loginAdmin(logb.getText(), pasb.getText())){
                FXMLLoader root = new FXMLLoader(HelloApplication.class.getResource("/bg/tu_varna/sit/example/presentation.views/admin-view.fxml"));

                Stage window = (Stage) btnAdminViewId.getScene().getWindow();
                window.setScene(new Scene(root.load(), 605, 385));
            } else {

                FXMLLoader root = new FXMLLoader(HelloApplication.class.getResource("/bg/tu_varna/sit/example/presentation.views/error.fxml"));

                Parent root1 = (Parent) root.load();
                Stage stage = new Stage();

                stage.setTitle("Error");
                stage.setScene(new Scene(root1, 200, 105));
                stage.show();


            }
        }

    public void backAdminLogin() throws Exception {

        FXMLLoader root = new FXMLLoader(HelloApplication.class.getResource("/bg/tu_varna/sit/example/presentation.views/mainpage.fxml"));

        Stage window = (Stage) btnBackAdminLoginId.getScene().getWindow();
        window.setScene(new Scene(root.load(), 605, 385));
    }
    }

