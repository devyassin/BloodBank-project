package com.example.demojavafx;

import Modules.AdminInfo;
import Modules.MembersModel;
import Modules.Patient;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ControllerPatient extends GlobalController {

    @FXML
    ImageView closeBtn;


    @FXML
    ScrollPane scrollType;

    @FXML
    TextField GroupDonorInputPopup;

    @FXML
    private Button AddDonorsBtn;

    @FXML
    private TextField EmailDonorInputPopup;

    @FXML
    private TextField LocationDonorInputPopup;

    @FXML
    private TextField NameDonorInputPopup;

    @FXML
    private Text emailEmpty;

    @FXML
    private Text groupEmpty;

    @FXML
    private Text locationEmpty;

    @FXML
    private Text nameEmpty;

    @FXML
    private Text emailValid;

    @FXML
    private Text NameRegexict;
    public void getStringName(ActionEvent event){
        String value = ((Button)event.getSource()).getText();
        GroupDonorInputPopup.setText(value);
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

    protected void chekEmpty(String name,String email,String location,String group){
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
        if(group.isEmpty()){
            groupEmpty.setVisible(true);
        }else{
            groupEmpty.setVisible(false);
        }

    }

    protected void clearInputsAndWarnings(){
        NameDonorInputPopup.setText("");
        LocationDonorInputPopup.setText("");
        EmailDonorInputPopup.setText("");
        GroupDonorInputPopup.setText("");
        NameRegexict.setVisible(false);
    }

    public void insertPatient(ActionEvent event) throws SQLException {
        String name=NameDonorInputPopup.getText();
        String email=EmailDonorInputPopup.getText();
        String location=LocationDonorInputPopup.getText();
        String groupe=GroupDonorInputPopup.getText();

        this.chekEmpty(name,email,location,groupe);
        if(!checkEmailValidation(email)) return;
        if(!name.isEmpty() && !email.isEmpty() && !location.isEmpty()  &&!groupe.isEmpty()){
            Patient m =new Patient();
            if(m.checkUserNameWithId(name,"patient")){
                NameRegexict.setVisible(true);
                return ;
            }else{
                m.insertOnPatientTable(name,email,location,groupe);
                this.clearInputsAndWarnings();
            }
        }

    }

    public  void removePatient(ActionEvent event) throws SQLException {
        String name=NameDonorInputPopup.getText();

        if(name.isEmpty()){
            nameEmpty.setVisible(true);
            NameRegexict.setVisible(false);
        }else{
            nameEmpty.setVisible(false);
        }

        if(!name.isEmpty()){
            MembersModel m=new MembersModel();
            Patient p =new Patient();
            if(!m.checkUserNameWithId(name,"patient")){
                NameRegexict.setVisible(true);
                return ;
            }else{
                p.deleteOnPatientTable(name);
                NameDonorInputPopup.setText("");
                NameRegexict.setVisible(false);
            }
        }
    }

    public void findPatientData() throws SQLException {
        String name=NameDonorInputPopup.getText();
        if(name.isEmpty()){
            nameEmpty.setVisible(true);
            NameRegexict.setVisible(false);
        }else{
            nameEmpty.setVisible(false);
            MembersModel m=new MembersModel();
            if(m.checkUserNameWithId(name,"patient")){
                String email="";
                String location="";
                String group="";
                String data[] =  m.getDonorData(name,email,location,group,"patient");
                EmailDonorInputPopup.setText(data[0]);
                LocationDonorInputPopup.setText(data[2]);
                GroupDonorInputPopup.setText(data[1]);
                NameRegexict.setVisible(false);
            }else{
                NameRegexict.setVisible(true);
            }

        }
    }

    public void updatePatient(ActionEvent event) throws SQLException {
        String name=NameDonorInputPopup.getText();
        String email=EmailDonorInputPopup.getText();
        String location=LocationDonorInputPopup.getText();
        String groupe=GroupDonorInputPopup.getText();

        this.chekEmpty(name,email,location,groupe);
        if(!checkEmailValidation(email)) return;
        if(!name.isEmpty() && !email.isEmpty() && !location.isEmpty()  &&!groupe.isEmpty()){
            MembersModel m =new MembersModel();
            Patient p =new Patient();
            if(!m.checkUserNameWithId(name,"patient")){
                NameRegexict.setVisible(true);
                return ;
            }else{
                p.updateOnPatientTable(name,email,location,groupe);
                this.clearInputsAndWarnings();
            }
        }
    }



}
