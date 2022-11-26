package com.example.demojavafx;

import Modules.BloodTModel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.*;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException, SQLException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("Views/Login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),1000,600);
        //stage.initStyle(StageStyle.UNDECORATED);

        stage.setTitle("RedBank");
       // stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        stage.show();


    }

    public static void main(String[] args) {
        launch();
    }
}