package com.example.demojavafx;


import Modules.AdminInfo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class ControllerMembers extends GlobalController {

    @FXML
    Text UserName;


    public  void show(){
        UserName.setText(AdminInfo.getName());
    }

}
