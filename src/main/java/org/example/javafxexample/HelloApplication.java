package org.example.javafxexample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // Carga la vista de la calculadora (disenada en Scene Builder)
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("calculadora-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Calculadora");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
