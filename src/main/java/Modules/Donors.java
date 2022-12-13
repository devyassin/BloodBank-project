package Modules;

import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Donors extends GlobalModel{
    int id;
    String name;
    String email;
    String group;
    String location;

    public Donors() {
    }

    public Donors(int id, String name, String email, String group, String location) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.group = group;
        this.location = location;
    }

    public Donors(String name, String group) {
        this.name = name;
        this.group = group;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void showDonorsNoConf(ObservableList<Donors> donorsList) throws SQLException {
        String sql="SELECT * FROM donor WHERE admin_id='"+AdminInfo.getId()+"' AND statut='false';";
        Statement s=this.connect().createStatement();
        ResultSet r=s.executeQuery(sql);

        while (r.next()){
            donorsList.add(new Donors(
                    r.getString("name"),
                    r.getString("blood_Grp")));
        }
    }

    public boolean checkDonors(String name,String table) throws SQLException {

        PreparedStatement preparedStatement;
        ResultSet resultSet=null;
        String sql="SELECT name FROM " +table+" WHERE name=? AND admin_id=? AND statut=?;";
        preparedStatement=this.connect().prepareStatement(sql);
        preparedStatement.setString(1,name);
        preparedStatement.setInt(2,AdminInfo.getId());
        preparedStatement.setString(3,"false");
        resultSet=  preparedStatement.executeQuery();
        return resultSet.next();
    }

    public  void addToStock(String name) throws SQLException {
        PreparedStatement preparedStatement;
        ResultSet resultSet=null;
        String sql="UPDATE donor SET statut='true' WHERE name=? AND admin_id=?;";
        preparedStatement=this.connect().prepareStatement(sql);
        preparedStatement.setString(1,name);
        preparedStatement.setInt(2,AdminInfo.getId());
        preparedStatement.executeUpdate();
    }
}
