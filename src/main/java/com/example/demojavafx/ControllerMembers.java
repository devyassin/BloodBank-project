package com.example.demojavafx;


import Modules.AdminInfo;
import Modules.Donors;
import Modules.MembersModel;
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
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ControllerMembers extends GlobalController implements Initializable {

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

    @FXML
    AnchorPane styleDonorPopup;


   // public static Boolean isHidden=true;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        loadDate();
    }

    public void showDonorsTable() throws SQLException {
        donorsList.clear();
        DonorTable.setVisible(true);
        MembersModel m=new MembersModel();
        m.showDonors(donorsList);
        DonorTable.setItems(donorsList);
        System.out.println(AdminInfo.getId() + "---- " +AdminInfo.getName());
    }

    public void loadDate(){
        LoadDonorsTable();
    }


    public void LoadDonorsTable(){
        IdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        NameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        EmailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        GroupCol.setCellValueFactory(new PropertyValueFactory<>("group"));
        LocationCol.setCellValueFactory(new PropertyValueFactory<>("location"));
    }

    public void showDonorsPopUp() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("Views/addDonors.fxml"));
        Parent root1=(Parent) fxmlLoader.load();
        Stage stage=new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(new Scene(root1));
        stage.show();
      /*  BoxBlur b=new BoxBlur(5,5,1);
        effectWrapper.setEffect(b);
        effectWrapper.setDisable(true); */

    }

    public void getStringName(ActionEvent event){
        String value = ((Button)event.getSource()).getText();
        GroupDonorInputPopup.setText(value);
        scrollType.setVisible(false);
    }
    public  void showAndHide(){
        if(scrollType.isVisible()){
            scrollType.setVisible(false);
        }

        if(!scrollType.isVisible()){
            scrollType.setVisible(true);
        }
    }

    public void closeWindow() throws IOException {
        Stage stage1 = (Stage) closeBtn.getScene().getWindow();
        stage1.close();

       /* FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("Views/Members.fxml"));
        Parent root1=(Parent) fxmlLoader.load();
        Stage stage=new Stage();
        stage.setScene(new Scene(root1));
        stage.show(); */
        // ControllerMembers controllerMembers=fxmlLoader.getController();
        //controllerMembers.changeDisable();
    }
}
