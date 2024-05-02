package com.example.swe206project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainPage extends Application {
    public void start(Stage mainStage)throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("MainPageController.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        mainStage.setTitle("Main Page");
        mainStage.setScene(scene);
        mainStage.setResizable(false);
        mainStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
