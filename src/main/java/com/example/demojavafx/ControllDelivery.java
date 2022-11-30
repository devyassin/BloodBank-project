package com.example.demojavafx;

import Modules.MembersModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class ControllDelivery {

    @FXML
    ImageView closeBtn;

    @FXML
    private Button AddDonorsBtn;

    @FXML
    private TextField EmailDonorInputPopup;

    @FXML
    private TextField LocationDonorInputPopup;

    @FXML
    private TextField NameDonorInputPopup;
    @FXML
    private PasswordField PassDonorInputPopup;

    @FXML
    private Text emailEmpty;

    @FXML
    private Text passwordEmpty;

    @FXML
    private Text locationEmpty;

    @FXML
    private Text nameEmpty;

    @FXML
    private Text emailValid;

    @FXML
    private Text NameRegexict;
    public void closeWindow() throws IOException {
        Stage stage1 = (Stage) closeBtn.getScene().getWindow();
        stage1.close();
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

    protected void chekEmpty(String name,String email,String location,String password){
        if(name.isEmpty()){
            nameEmpty.setVisible(true);
        }else{
            nameEmpty.setVisible(false);
        }
        if(email.isEmpty()){
            emailEmpty.setVisible(true);
        }else{
            emailEmpty.setVisible(false);
        }
        if(location.isEmpty()){
            locationEmpty.setVisible(true);
        }else{
            locationEmpty.setVisible(false);
        }
        if(password.isEmpty()){
            passwordEmpty.setVisible(true);
        }else{
            passwordEmpty.setVisible(false);
        }

    }

    protected void clearInputsAndWarnings(){
        NameDonorInputPopup.setText("");
        LocationDonorInputPopup.setText("");
        EmailDonorInputPopup.setText("");
        PassDonorInputPopup.setText("");
        NameRegexict.setVisible(false);
    }

    public void insertDelivery(ActionEvent event) throws SQLException {
        String name=NameDonorInputPopup.getText();
        String email=EmailDonorInputPopup.getText();
        String location=LocationDonorInputPopup.getText();
        String password=PassDonorInputPopup.getText();

        this.chekEmpty(name,email,location,password);
        if(!checkEmailValidation(email)) return;
        if(!name.isEmpty() && !email.isEmpty() && !location.isEmpty()  &&!password.isEmpty()){
            MembersModel m =new MembersModel();
            if(m.checkUserNameWithId(name,"delevery")){
                NameRegexict.setVisible(true);
                return ;
            }else{
                m.insertOnDeliveryTable(name,email,location,password);
                this.clearInputsAndWarnings();
            }
        }

    }

    public void findDeliveryData() throws SQLException {
        String name=NameDonorInputPopup.getText();
        if(name.isEmpty()){
            nameEmpty.setVisible(true);
            NameRegexict.setVisible(false);
        }else{
            nameEmpty.setVisible(false);
            MembersModel m=new MembersModel();
            if(m.checkUserNameWithId(name,"delevery")){
                String email="";
                String location="";
                String password="";
                String data[] =  m.getDeliveryData(name,email,location,password,"delevery");
                EmailDonorInputPopup.setText(data[0]);
                LocationDonorInputPopup.setText(data[2]);
                PassDonorInputPopup.setText(data[1]);
                NameRegexict.setVisible(false);
            }else{
                NameRegexict.setVisible(true);
            }

        }
    }

    public void updateDelivery(ActionEvent event) throws SQLException {
        String name=NameDonorInputPopup.getText();
        String email=EmailDonorInputPopup.getText();
        String location=LocationDonorInputPopup.getText();
        String password=PassDonorInputPopup.getText();

        this.chekEmpty(name,email,location,password);
        if(!checkEmailValidation(email)) return;
        if(!name.isEmpty() && !email.isEmpty() && !location.isEmpty()  &&!password.isEmpty()){
            MembersModel m =new MembersModel();
            if(!m.checkUserNameWithId(name,"delevery")){
                NameRegexict.setVisible(true);
                return ;
            }else{
                m.updateOnDeliveryTable(name,email,location,password,"delevery");
                this.clearInputsAndWarnings();
            }
        }
    }
    public  void removeDelevery(ActionEvent event) throws SQLException {
        String name=NameDonorInputPopup.getText();

        if(name.isEmpty()){
            nameEmpty.setVisible(true);
            NameRegexict.setVisible(false);
        }else{
            nameEmpty.setVisible(false);
        }

        if(!name.isEmpty()){
            MembersModel m=new MembersModel();
            if(!m.checkUserNameWithId(name,"delevery")){
                NameRegexict.setVisible(true);
                return ;
            }else{
                m.deleteOnTable(name,"delevery");
                NameDonorInputPopup.setText("");
                NameRegexict.setVisible(false);
            }
        }
    }
}
