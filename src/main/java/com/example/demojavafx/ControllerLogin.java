package com.example.demojavafx;
import Modules.AdminInfo;
import Modules.LoginModel;
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
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class ControllerLogin extends GlobalController{
    protected Stage stage;
    protected Scene scene;
    protected Parent root;


    @FXML
    TextField inputTypeLogin,inputNameLogin,inputPassLogin;
    @FXML
    ScrollPane scrollType;
    @FXML
    ImageView showTypes;

    @FXML
    Button LoginBtn;

    @FXML
    Text nameEmpty,passEmpty,typeEmpty,userNotFound;

    @FXML
    Line underLineName,underLinePass,underLineType;

    public void moveToRegister(ActionEvent event) throws IOException {
        root= FXMLLoader.load(getClass().getResource("Views/Register.fxml"));
        stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


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
        inputTypeLogin.setText(value);
        scrollType.setVisible(false);
    }


    protected void chekEmpty(String name,String password,String type){
        if(name.isEmpty()){
            nameEmpty.setVisible(true);
            underLineName.setStyle("-fx-stroke: red;-fx-stroke-width:3");
        }else{
            nameEmpty.setVisible(false);
            underLineName.setStyle("-fx-stroke: black;-fx-stroke-width:1");
        }
        if(password.isEmpty()){
            passEmpty.setVisible(true);
            underLinePass.setStyle("-fx-stroke: red;-fx-stroke-width:3");
        }else{
            passEmpty.setVisible(false);
            underLinePass.setStyle("-fx-stroke: black;-fx-stroke-width:1");
        }
        if(type.isEmpty()){
            typeEmpty.setVisible(true);
            underLineType.setStyle("-fx-stroke: red;-fx-stroke-width:3");
        }else{
            typeEmpty.setVisible(false);
            underLineType.setStyle("-fx-stroke: black;-fx-stroke-width:1");
        }
    }

    protected void clearInputsAndWarnings(){
        inputNameLogin.setText("");
        inputPassLogin.setText("");
        inputTypeLogin.setText("");
        userNotFound.setVisible(false);
        underLineName.setStyle("-fx-stroke: black;-fx-stroke-width:1");
        underLinePass.setStyle("-fx-stroke: black;-fx-stroke-width:1");
        underLineType.setStyle("-fx-stroke: black;-fx-stroke-width:1");
    }

    public void Login(ActionEvent event) throws SQLException, IOException {
    String name=inputNameLogin.getText();
    String password=inputPassLogin.getText();
    String type=inputTypeLogin.getText();

    this.chekEmpty(name,password,type);


        if(!name.isEmpty() && !password.isEmpty() && !type.isEmpty()){
            LoginModel mod=new LoginModel();
            if(mod.ChekLoginInfo(name,password,type)){
                this.clearInputsAndWarnings();
                System.out.println("welcome");
                AdminInfo.setName(name);
                AdminInfo.setId(mod.getAdminId(name));
                this.moveToMembersView(event);

            }else{
                userNotFound.setVisible(true);
                underLineName.setStyle("-fx-stroke: red;-fx-stroke-width:3");
                underLinePass.setStyle("-fx-stroke: red;-fx-stroke-width:3");
                underLineType.setStyle("-fx-stroke: red;-fx-stroke-width:3");
            }
        }

    }


}


