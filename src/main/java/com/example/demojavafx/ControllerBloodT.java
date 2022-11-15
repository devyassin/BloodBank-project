package com.example.demojavafx;
import Modules.BloodTModel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.sql.SQLException;

public class ControllerBloodT extends GlobalController {

    @FXML
    Button DonateBtn;
    @FXML
    Text tested;

    public void printText() throws SQLException {
        BloodTModel m=new BloodTModel();
        String value=m.printCon();
        tested.setText(value);
    }
}
