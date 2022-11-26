package com.example.demojavafx;

import Modules.MembersModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.SQLException;

public class ControllerDonors {

    @FXML
    TextField GroupDonorInputPopup;
    @FXML
    ScrollPane scrollType;
    @FXML
    ImageView closeBtn;

    @FXML
    AnchorPane styleDonorPopup;
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

       /* FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("Views/Members.fxml"));
        Parent root1=(Parent) fxmlLoader.load();
        Stage stage=new Stage();
        stage.setScene(new Scene(root1));
        stage.show(); */
       // ControllerMembers controllerMembers=fxmlLoader.getController();
        //controllerMembers.changeDisable();
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
    public void insertDonor(ActionEvent event) throws SQLException {
        String name=NameDonorInputPopup.getText();
        String email=EmailDonorInputPopup.getText();
        String location=LocationDonorInputPopup.getText();
        String groupe=GroupDonorInputPopup.getText();

        this.chekEmpty(name,email,location,groupe);
        if(!checkEmailValidation(email)) return;
        if(!name.isEmpty() && !email.isEmpty() && !location.isEmpty()  &&!groupe.isEmpty()){
            MembersModel m =new MembersModel();
            if(m.checkUserName(name,"donor")){
                NameRegexict.setVisible(true);
                return ;
            }else{
                m.insertOnDonorTable(name,email,location,groupe);
                this.clearInputsAndWarnings();
            }
        }

    }
}
