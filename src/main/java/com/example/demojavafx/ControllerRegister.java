package com.example.demojavafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerRegister extends  GlobalController{
    protected Stage stage;
    protected Scene scene;
    protected Parent root;

    @FXML
    TextField inputTypeRegister;
    @FXML
    ScrollPane scrollType;
    @FXML
    ImageView showTypes;

    public  void showAndHide(){
        if(scrollType.isVisible()){
            scrollType.setVisible(false);
        }

        if(!scrollType.isVisible()){
            scrollType.setVisible(true);
        }


    }
    public void getStringName(ActionEvent event){
        String value = ((Button)event.getSource()).getText();
        inputTypeRegister.setText(value);
        scrollType.setVisible(false);
    }

}
