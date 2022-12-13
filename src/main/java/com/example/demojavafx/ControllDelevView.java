package com.example.demojavafx;

import Modules.Delivery;
import Modules.Patient;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ControllDelevView extends GlobalController implements Initializable {

    @FXML
    Button DonateBlood;

    @FXML
    Text NameExict,TextEmpty;

    @FXML
    TextField NameInput;

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


    ObservableList<Patient> patientsTreatedList= FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        LoadPatientsTreatedTable();
        try {
            showPatientsTreatedTable();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void showPatientsTreatedTable() throws SQLException {
        patientsTreatedList.clear();
        Patient m=new Patient();
        m.showTreatedPatients(patientsTreatedList);
        PatientTable.setItems(patientsTreatedList);
    }
    public void LoadPatientsTreatedTable(){
        NameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        EmailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        GroupCol.setCellValueFactory(new PropertyValueFactory<>("group"));
        LocationCol.setCellValueFactory(new PropertyValueFactory<>("address"));
    }

    public void traitCommand(ActionEvent event) throws SQLException {
        String name=NameInput.getText();
        if(name.isEmpty()){
            TextEmpty.setVisible(true);
        }else{
            TextEmpty.setVisible(false);

        }

        if(!name.isEmpty()){
            Patient m =new Patient();
            if(!m.checkTreatedPatient(name)){
                NameExict.setVisible(true);
                System.out.println("not found");
                return ;
            }else{

                Delivery d=new Delivery();
                Patient p =new Patient();
                d.incrimantQte();
                p.changeStatutTotreated(name);
                p.updateCommandeStatut(p.getPatientId(name));
                NameInput.setText("");
                NameExict.setVisible(false);
                NameInput.setVisible(false);
                showPatientsTreatedTable();
            }
        }
    }
}
