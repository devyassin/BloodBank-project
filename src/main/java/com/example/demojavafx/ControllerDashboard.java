package com.example.demojavafx;

import Modules.DashboardModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.text.Text;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ControllerDashboard extends GlobalController implements Initializable {

    @FXML
    Text donorsNumber,patientsNumber,transfersNumber;
    @FXML
    BarChart <String,Integer> barChart;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        XYChart.Series<String,Integer> series=new XYChart.Series();
        series.setName("Stock Of Blood");
        try {
            series.getData().add(new XYChart.Data("A-",getNumberofBloodTypes("A-")));
            series.getData().add(new XYChart.Data("A+",getNumberofBloodTypes("A+")));
            series.getData().add(new XYChart.Data("B-",getNumberofBloodTypes("B-")));
            series.getData().add(new XYChart.Data("B+",getNumberofBloodTypes("B+")));
            series.getData().add(new XYChart.Data("AB-",getNumberofBloodTypes("AB-")));
            series.getData().add(new XYChart.Data("AB+",getNumberofBloodTypes("AB+")));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        series.getData().add(new XYChart.Data("O-",50));
        series.getData().add(new XYChart.Data("O+",100));

        barChart.getData().addAll(series);

        try {
            setCurrentTransferNumber();
            setCurrentDonorNumber();
            setCurrentPatientNumber();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void setCurrentDonorNumber() throws SQLException {
        DashboardModel m =new DashboardModel();
        String num=Integer.toString(m.numDonors());
        donorsNumber.setText(num);
    }


    public void setCurrentPatientNumber() throws SQLException {
        DashboardModel m =new DashboardModel();
        String num=Integer.toString(m.numPatients());
        patientsNumber.setText(num);
    }

    public void setCurrentTransferNumber() throws SQLException {
        DashboardModel m =new DashboardModel();
        String num=Integer.toString(m.numTransfers());
        transfersNumber.setText(num);
    }

    public int getNumberofBloodTypes(String name) throws SQLException {
        DashboardModel m=new DashboardModel();
       return m.getNumberofBloodTypes(name);
    }
}
