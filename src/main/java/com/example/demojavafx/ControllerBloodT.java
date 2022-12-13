package com.example.demojavafx;
import Modules.BloodTModel;
import Modules.Donors;
import Modules.Patient;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.sql.SQLException;

public class ControllerBloodT extends GlobalController {

    @FXML
    Button DonateBtn;
    @FXML
    TextField NameInput;

    @FXML
    Text NameEmpty;
    @FXML
    Text nameExict;
    @FXML
    Text groupEmpty;
    @FXML
    TextField GroupeInput;
    @FXML
    ScrollPane scrollType;

    @FXML
    Text NotMatching;

    public void getStringName(ActionEvent event){
        String value = ((Button)event.getSource()).getText();
        GroupeInput.setText(value);
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
    public void transfertBlood (ActionEvent event) throws SQLException {
        String name=NameInput.getText();
        String group=GroupeInput.getText();

        if(name.isEmpty()){
            NameEmpty.setVisible(true);
            groupEmpty.setVisible(false);
        }else{
            NameEmpty.setVisible(false);
        }

        if (group.isEmpty()){
            groupEmpty.setVisible(true);
            NameEmpty.setVisible(false);
        }else{
            groupEmpty.setVisible(false);
        }

        if(!name.isEmpty() && !group.isEmpty()){
            Patient p=new Patient();
            if (!p.checkPatientName(name)){
                nameExict.setVisible(true);
                return;
            }else{
                if(p.checkGroupMaching(name,group)){
                    p.transfertBlood(name,group);
                    nameExict.setVisible(false);
                    groupEmpty.setVisible(false);
                    NotMatching.setVisible(false);
                    GroupeInput.setText("");
                }else{
                    NotMatching.setVisible(true);
                }
            }
        }
    }
}
