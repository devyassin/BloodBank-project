package com.example.demojavafx;


import Modules.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.BoxBlur;
import javafx.scene.image.ImageView;

import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ControllerMembers extends GlobalController implements Initializable {

    // Donor table
   @FXML
   TableView<Donors> DonorTable;
   @FXML
    TableColumn<Donors,String> IdCol;
    @FXML
    TableColumn<Donors,String> NameCol;
    @FXML
    TableColumn<Donors,String> EmailCol;
    @FXML
    TableColumn<Donors,String> GroupCol;
    @FXML
    TableColumn<Donors,String> LocationCol;

    ObservableList<Donors> donorsList= FXCollections.observableArrayList();

    @FXML
    ImageView addDonor;

    @FXML
    TextField GroupDonorInputPopup;
    @FXML
    ScrollPane scrollType;
    @FXML
    ImageView closeBtn;

   //Delivery table

    @FXML
    TableView<Delivery> DeliveryTable;
    @FXML
    TableColumn<Delivery,String> NameColDelev;
    @FXML
    TableColumn<Delivery,String> PassColDelev;
    @FXML
    TableColumn<Delivery,String> EmailColDelev;
    @FXML
    TableColumn<Delivery,String> QteColDelev;
    @FXML
    TableColumn<Delivery,String> LocationColDelev;

    ObservableList<Delivery> deliveryList= FXCollections.observableArrayList();

    // technicien table

    @FXML
    TableView<Techniciens> TechnicienTable;
    @FXML
    TableColumn<Techniciens,String> NameColTech;
    @FXML
    TableColumn<Techniciens,String> PassColTech;
    @FXML
    TableColumn<Techniciens,String> EmailColTech;
    @FXML
    TableColumn<Techniciens,String> TransfertColTech;
    @FXML
    TableColumn<Techniciens,String> LocationColTech;

    ObservableList<Techniciens> technicienList= FXCollections.observableArrayList();

    @FXML
    Text donorTitle;

    @FXML
    Text DeliveryTitle;

    @FXML
    Text TechnicienTitle;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        loadTables();
    }

    public void showDonorsTable() throws SQLException {
        DeliveryTitle.setVisible(false);
        TechnicienTitle.setVisible(false);
        DeliveryTable.setVisible(false);
        TechnicienTable.setVisible(false);
        donorsList.clear();
        DonorTable.setVisible(true);
        donorTitle.setVisible(true);
        MembersModel m=new MembersModel();
        m.showDonors(donorsList);
        DonorTable.setItems(donorsList);
    }

    public void showDeliveryTable() throws SQLException {
        donorTitle.setVisible(false);
        TechnicienTitle.setVisible(false);
        DonorTable.setVisible(false);
        TechnicienTable.setVisible(false);
        deliveryList.clear();
        DeliveryTable.setVisible(true);
        DeliveryTitle.setVisible(true);
        MembersModel m=new MembersModel();
        m.showDelivery(deliveryList);
        DeliveryTable.setItems(deliveryList);
    }

    public void showTechniciensTable() throws SQLException {
        donorTitle.setVisible(false);
        DeliveryTitle.setVisible(false);
        DonorTable.setVisible(false);
        DeliveryTable.setVisible(false);
        technicienList.clear();
        TechnicienTable.setVisible(true);
        TechnicienTitle.setVisible(true);
        MembersModel m=new MembersModel();
        m.showTechnicien(technicienList);
        TechnicienTable.setItems(technicienList);
    }


    public void loadTables(){
        LoadDonorsTable();
        LoadDeliveryTable();
        LoadTechnicienTable();
    }


    public void LoadDonorsTable(){
        IdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        NameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        EmailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        GroupCol.setCellValueFactory(new PropertyValueFactory<>("group"));
        LocationCol.setCellValueFactory(new PropertyValueFactory<>("location"));
    }


    public void LoadDeliveryTable(){
        NameColDelev.setCellValueFactory(new PropertyValueFactory<>("name"));
        PassColDelev.setCellValueFactory(new PropertyValueFactory<>("password"));
        EmailColDelev.setCellValueFactory(new PropertyValueFactory<>("email"));
        QteColDelev.setCellValueFactory(new PropertyValueFactory<>("Qte"));
        LocationColDelev.setCellValueFactory(new PropertyValueFactory<>("location"));
    }

    public void LoadTechnicienTable(){
        NameColTech.setCellValueFactory(new PropertyValueFactory<>("name"));
        PassColTech.setCellValueFactory(new PropertyValueFactory<>("password"));
        EmailColTech.setCellValueFactory(new PropertyValueFactory<>("email"));
        TransfertColTech.setCellValueFactory(new PropertyValueFactory<>("NbTransfert"));
        LocationColTech.setCellValueFactory(new PropertyValueFactory<>("location"));
    }



    public void showDonorsAddPopUp() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("Views/addDonors.fxml"));
        Parent root1=(Parent) fxmlLoader.load();
        Stage stage=new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(new Scene(root1));
        stage.show();
    }

    public void showDeliveryAddPopUp() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("Views/addDelivery.fxml"));
        Parent root1=(Parent) fxmlLoader.load();
        Stage stage=new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(new Scene(root1));
        stage.show();
    }

    public void showTechnicienAddPopUp() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("Views/addTechniciens.fxml"));
        Parent root1=(Parent) fxmlLoader.load();
        Stage stage=new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(new Scene(root1));
        stage.show();
    }
    public void showDonorsRemovePopUp() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("Views/removeDonors.fxml"));
        Parent root1=(Parent) fxmlLoader.load();
        Stage stage=new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(new Scene(root1));
        stage.show();
    }

    public void showDeliveryRemovePopUp() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("Views/removeDelivery.fxml"));
        Parent root1=(Parent) fxmlLoader.load();
        Stage stage=new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(new Scene(root1));
        stage.show();
    }

    public void showTechnicienRemovePopUp() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("Views/removeTechniciens.fxml"));
        Parent root1=(Parent) fxmlLoader.load();
        Stage stage=new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(new Scene(root1));
        stage.show();
    }
    public void showDonorsUpdatePopUp() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("Views/updateDonors.fxml"));
        Parent root1=(Parent) fxmlLoader.load();
        Stage stage=new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(new Scene(root1));
        stage.show();
    }

    public void showDeliveryUpdatePopUp() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("Views/updateDelivery.fxml"));
        Parent root1=(Parent) fxmlLoader.load();
        Stage stage=new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(new Scene(root1));
        stage.show();
    }

    public void showTechnicienUpdatePopUp() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("Views/updateTechniciens.fxml"));
        Parent root1=(Parent) fxmlLoader.load();
        Stage stage=new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(new Scene(root1));
        stage.show();
    }

}
