package bg.tu_varna.sit.example.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Logger;

public class HelloApplication extends Application {

    private static final Logger log = Logger.getLogger(HelloApplication.class.getName());

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/bg/tu_varna/sit/example/presentation.views/mainpage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 605, 385);
        stage.setTitle("Curier Firm");
        stage.setScene(scene);
        stage.show();



    }

    public static void main(String[] args) {
        launch();
    }
}