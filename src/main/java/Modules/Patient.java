package Modules;

import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Patient extends GlobalModel {
    String name;
    String email;
    String address;
    String group;

    String statut;

    public Patient() {
    }

    public Patient(String name, String email, String address, String group, String statut) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.group = group;
        this.statut=statut;
    }


    public void showPatients(ObservableList<Patient> patientsList) throws SQLException {
        String sql="SELECT * FROM patient WHERE admin_id='"+AdminInfo.getId()+"';";
        Statement s=this.connect().createStatement();
        ResultSet r=s.executeQuery(sql);

        while (r.next()){
            patientsList.add(new Patient(
                    r.getString("name"),
                    r.getString("email"),
                    r.getString("blood_Grp"),
                    r.getString("address"),
                    r.getString("statut")));
        }
    }

    public int getPatientId(String name) throws SQLException {
        PreparedStatement preparedStatement;
        ResultSet resultSet=null;
        String sql="SELECT * FROM patient WHERE name=? ;";
        preparedStatement=this.connect().prepareStatement(sql);
        preparedStatement.setString(1,name);
        resultSet=  preparedStatement.executeQuery();

        if (!resultSet.next()){
            return 0;
        }
        return  resultSet.getInt(1);
    };

    public void insertOnCommandeTable(int patien_id, String blood_grp, String address) throws SQLException {
        PreparedStatement preparedStatement;
        ResultSet resultSet=null;
        String sql="INSERT INTO commande(patien_id,blood_grp,address) VALUES(?,?,?);";
        preparedStatement=this.connect().prepareStatement(sql);
        preparedStatement.setInt(1,patien_id);
        preparedStatement.setString(2,blood_grp);
        preparedStatement.setString(3,address);
        preparedStatement.executeUpdate();

    }

    public void insertOnPatientTable(String name, String email, String location, String groupe) throws SQLException {
        PreparedStatement preparedStatement;
        ResultSet resultSet=null;
        String sql="INSERT INTO patient(name,email,address,blood_Grp,admin_id) VALUES(?,?,?,?,?);";
        preparedStatement=this.connect().prepareStatement(sql);
        preparedStatement.setString(1,name);
        preparedStatement.setString(2,email);
        preparedStatement.setString(3,location);
        preparedStatement.setString(4,groupe);
        preparedStatement.setInt(5,AdminInfo.getId());
        preparedStatement.executeUpdate();
        int patientId=getPatientId(name);
        insertOnCommandeTable(patientId,groupe,location);

    }

    public void deleteOnCommandeTable(int patientId) throws SQLException {
        PreparedStatement preparedStatement;
        ResultSet resultSet=null;
        String sql="DELETE FROM commande WHERE patien_id=? ;";
        preparedStatement=this.connect().prepareStatement(sql);
        preparedStatement.setInt(1,patientId);
        preparedStatement.executeUpdate();
    }
    public void deleteOnPatientTable(String name) throws SQLException {
        int patientId=getPatientId(name);
        deleteOnCommandeTable(patientId);
        PreparedStatement preparedStatement;
        ResultSet resultSet=null;
        String sql="DELETE FROM patient WHERE name=? AND admin_id=?;";
        preparedStatement=this.connect().prepareStatement(sql);
        preparedStatement.setString(1,name);
        preparedStatement.setInt(2,AdminInfo.getId());
        preparedStatement.executeUpdate();
    }

    public void updateOnCommandeTable(int patientId,String groupe,String address) throws SQLException {
        PreparedStatement preparedStatement;
        ResultSet resultSet=null;
        String sql="UPDATE commande SET blood_grp=? ,  address=?  WHERE patien_id=? ;";
        preparedStatement=this.connect().prepareStatement(sql);
        preparedStatement.setString(1,groupe);
        preparedStatement.setString(2,address);
        preparedStatement.setInt(3,patientId);
        preparedStatement.executeUpdate();
    }

    public void updateOnPatientTable(String name,String email,String location,String groupe) throws SQLException {
        int patientId=getPatientId(name);
        updateOnCommandeTable(patientId,groupe,location);
        PreparedStatement preparedStatement;
        ResultSet resultSet=null;
        String sql="UPDATE patient SET email=? ,  address=? , blood_Grp=? WHERE name=? AND admin_id=?;";
        preparedStatement=this.connect().prepareStatement(sql);
        preparedStatement.setString(1,email);
        preparedStatement.setString(2,location);
        preparedStatement.setString(3,groupe);
        preparedStatement.setString(4,name);
        preparedStatement.setInt(5,AdminInfo.getId());
        preparedStatement.executeUpdate();

    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
