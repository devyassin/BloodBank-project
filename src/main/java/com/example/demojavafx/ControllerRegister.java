package com.example.demojavafx;
import Modules.RegisterModel;
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
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ControllerRegister extends  GlobalController{

    @FXML
    TextField inputEmailRegister;
    @FXML
    TextField inputUserRegister;

    @FXML
    TextField inputPassRegister;
    @FXML
    TextField inputRePassRegister;
    @FXML
    TextField inputLocationRegister;

    @FXML
    Line underlinepass,underlineRepass;

    @FXML
    Text passwarning,emailEmpty,nameEmpty,passEmpty,adressEmpty,emailValid,NameRegexict;

    protected boolean checkPasswordMatching(String password,String repassword){
        if(!repassword.equals(password)){
            underlinepass.setStyle("-fx-stroke: red;-fx-stroke-width:3");
            underlineRepass.setStyle("-fx-stroke: red;-fx-stroke-width:3");
            passwarning.setVisible(true);
            return false;
        }
        return true;
    }


    protected boolean checkEmailValidation(String email){
        String emailPattern="[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if(email.matches(emailPattern) || email.isEmpty()) {
            emailValid.setVisible(false);
            return true;
        }else{
            emailValid.setVisible(true);
            return false;
        }
    }
    protected void chekEmpty(String name,String password,String address,String email){
        if(email.isEmpty()){
            emailEmpty.setVisible(true);
        }else{
            emailEmpty.setVisible(false);
        }
        if(password.isEmpty()){
            passEmpty.setVisible(true);
        }else{
            passEmpty.setVisible(false);
        }
        if(address.isEmpty()){
            adressEmpty.setVisible(true);
        }else{
            adressEmpty.setVisible(false);
        }
        if(name.isEmpty()){
            nameEmpty.setVisible(true);
        }else{
            nameEmpty.setVisible(false);
        }

    }
    protected void clearInputsAndWarnings(){
        inputUserRegister.setText("");
        inputPassRegister.setText("");
        inputRePassRegister.setText("");
        inputLocationRegister.setText("");
        inputEmailRegister.setText("");
        underlinepass.setStyle("-fx-stroke: black;-fx-stroke-width:1");
        underlineRepass.setStyle("-fx-stroke: black;-fx-stroke-width:1");
        passwarning.setVisible(false);
        NameRegexict.setVisible(false);
    }

    public void insertData(ActionEvent event) throws SQLException {
        String name=inputUserRegister.getText();
        String password=inputPassRegister.getText();
        String repassword=inputRePassRegister.getText();
        String address=inputLocationRegister.getText();
        String email=inputEmailRegister.getText();


        this.chekEmpty(name,password,address,email);
        if(!checkEmailValidation(email)) return;
        if(this.checkPasswordMatching(password, repassword)){
            if(!name.isEmpty() && !password.isEmpty() && !address.isEmpty() && !email.isEmpty() &&!repassword.isEmpty()){
                RegisterModel register=new RegisterModel();
                if(register.checkUserName(name,"admin")){
                    NameRegexict.setVisible(true);
                    return ;
                }else{
                    register.insertOnAdminTable(name,password,email,address);
                    this.clearInputsAndWarnings();
                }
            }

        }



    }

}
