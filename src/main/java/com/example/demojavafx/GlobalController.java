package com.example.demojavafx;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
public class GlobalController {
    protected Stage stage;
    protected Scene scene;
    protected Parent root;

    public void moveToPatientsView(ActionEvent event) throws IOException {
        root= FXMLLoader.load(getClass().getResource("Views/Patients.fxml"));
        stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void moveToMembersView(ActionEvent event) throws IOException {
        root= FXMLLoader.load(getClass().getResource("Views/Members.fxml"));
        stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void moveToDonateView(ActionEvent event) throws IOException {
        root= FXMLLoader.load(getClass().getResource("Views/Donate.fxml"));
        stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void moveToBloodTransferView(ActionEvent event) throws IOException {
        root= FXMLLoader.load(getClass().getResource("Views/BloodT.fxml"));
        stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void moveToDashboardView(ActionEvent event) throws IOException {
        root= FXMLLoader.load(getClass().getResource("Views/Dashboard.fxml"));
        stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
