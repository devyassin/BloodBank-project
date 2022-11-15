package com.example.demojavafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerLogin {
    protected Stage stage;
    protected Scene scene;
    protected Parent root;
    public void moveToRegister(ActionEvent event) throws IOException {
        root= FXMLLoader.load(getClass().getResource("Views/Register.fxml"));
        stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
