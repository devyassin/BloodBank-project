package com.example.demojavafx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Scene2Controller {
   @FXML
    Label labelChange;

   void setUsername(String username){
       labelChange.setText("Welcome: "+username);
   }
}
