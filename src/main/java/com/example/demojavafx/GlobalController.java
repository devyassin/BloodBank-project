package com.example.demojavafx;
import Modules.AdminInfo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.BoxBlur;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


import java.io.IOException;
public class GlobalController {
    protected Stage stage;
    protected Scene scene;
    protected Parent root;
    @FXML
    protected Pane popupLogout;
    @FXML
    protected  Group effectWrapper;
    public void logout(){
        popupLogout.setVisible(true);
        BoxBlur b=new BoxBlur(5,5,1);
        effectWrapper.setEffect(b);
        effectWrapper.setDisable(true);
    }

    public void CancelBtn(ActionEvent event){
        popupLogout.setVisible(false);
        effectWrapper.setEffect(null);
        effectWrapper.setDisable(false);

    }
    public void moveToPatientsView(ActionEvent event) throws IOException {
        root= FXMLLoader.load(getClass().getResource("Views/Patients.fxml"));
        stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void moveToDeleveryView(ActionEvent event) throws IOException {
        root= FXMLLoader.load(getClass().getResource("Views/Delivery.fxml"));
        stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public void moveToMembersView(ActionEvent event) throws IOException {
        if(AdminInfo.getType().equals("admin")){
            root= FXMLLoader.load(getClass().getResource("Views/Members.fxml"));
            stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
            scene=new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
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


    public void moveToLogin(ActionEvent event) throws IOException {
        root= FXMLLoader.load(getClass().getResource("Views/Login.fxml"));
        stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
