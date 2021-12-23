package com.example.peymanmoshfegh_comp228_sec13_testfall2021;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CarApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CarApplication.class.getResource("car-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 720, 560);
        stage.setTitle("Final!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}