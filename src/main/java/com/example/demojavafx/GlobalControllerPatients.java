package com.example.demojavafx;

import Modules.Patient;
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
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class GlobalControllerPatients extends GlobalController implements Initializable {

    @FXML
    TableView<Patient> PatientTable;

    @FXML
    TableColumn<Patient,String> NameCol;
    @FXML
    TableColumn<Patient,String> EmailCol;
    @FXML
    TableColumn<Patient,String> GroupCol;
    @FXML
    TableColumn<Patient,String> LocationCol;

    @FXML
    TableColumn<Patient,String> StatutCol;

    ObservableList<Patient> patientsList= FXCollections.observableArrayList();



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        LoadPatientsTable();
        try {
            showDonorsTable();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void showDonorsTable() throws SQLException {
        patientsList.clear();
        Patient m=new Patient();
        m.showPatients(patientsList);
        PatientTable.setItems(patientsList);
    }

    public void LoadPatientsTable(){
        NameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        EmailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        GroupCol.setCellValueFactory(new PropertyValueFactory<>("group"));
        LocationCol.setCellValueFactory(new PropertyValueFactory<>("address"));
        StatutCol.setCellValueFactory(new PropertyValueFactory<>("statut"));
    }

    public void showDonorsAddPopUp() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("Views/addPatient.fxml"));
        Parent root1=(Parent) fxmlLoader.load();
        Stage stage=new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(new Scene(root1));
        stage.show();
    }
    public void showPatientsRemovePopUp() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("Views/removePatient.fxml"));
        Parent root1=(Parent) fxmlLoader.load();
        Stage stage=new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(new Scene(root1));
        stage.show();
    }

    public void showPatientsUpdatePopUp() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("Views/updatePatient.fxml"));
        Parent root1=(Parent) fxmlLoader.load();
        Stage stage=new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(new Scene(root1));
        stage.show();
    }
}
