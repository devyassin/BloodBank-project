package com.example.demojavafx;

import Modules.Donors;
import Modules.MembersModel;
import Modules.Stock;
import com.sun.javafx.scene.control.InputField;
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

public class ControllerDonate extends GlobalController implements Initializable {

    @FXML
    Button DonateBlood;

    @FXML
    TextField NameInput;

    @FXML
    Text nbStock;

    @FXML
    Text nameExict;

    @FXML
    Text NameEmpty;

    @FXML
    TableView<Donors> DonorTable;

    @FXML
    TableColumn<Donors,String> NameCol;
    @FXML
    TableColumn<Donors,String> GroupCol;


    ObservableList<Donors> donorsNoConfList= FXCollections.observableArrayList();

    @FXML
    TableView<Stock> StockTable;

    @FXML
    TableColumn<Stock,String> GroupstockCol;
    @FXML
    TableColumn<Stock,String> StockCol;


    ObservableList<Stock> stockList= FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        LoadDonorsNoConfTable();
        LoadStockTable();

        try {
            showDonorsTable();
            showStockTable();
            initStock();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    public void LoadDonorsNoConfTable(){
        NameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        GroupCol.setCellValueFactory(new PropertyValueFactory<>("group"));
    }

    public void LoadStockTable(){
        GroupstockCol.setCellValueFactory(new PropertyValueFactory<>("groupe"));
        StockCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
    }

    public void showDonorsTable() throws SQLException {
        donorsNoConfList.clear();
        Donors d=new Donors();
        d.showDonorsNoConf(donorsNoConfList);
        DonorTable.setItems(donorsNoConfList);
    }

    public void showStockTable() throws SQLException {
        stockList.clear();
        Stock s=new Stock();
        s.showStock(stockList);
        StockTable.setItems(stockList);
    }

   public void initStock() throws SQLException {
        Stock s=new Stock();
       String value= s.getnbStock();
       nbStock.setText(value);
    }
    public  void StockBlood(ActionEvent event) throws SQLException {
        String name=NameInput.getText();

        if(name.isEmpty()){
            NameEmpty.setVisible(true);
        }else{
            NameEmpty.setVisible(false);
        }

        if(!name.isEmpty()){
            Donors d=new Donors();
            if (!d.checkDonors(name,"donor")){
                nameExict.setVisible(true);
                return;
            }else{
                nameExict.setVisible(false);
                d.addToStock(name);
                NameInput.setText("");
                LoadStockTable();
                LoadDonorsNoConfTable();
                showDonorsTable();
                showStockTable();
                initStock();

            }
        }
    }

}
