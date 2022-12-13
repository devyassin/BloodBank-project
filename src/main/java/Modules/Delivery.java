package Modules;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Delivery extends GlobalModel {
    static  String currDelevName;
    String name;
    String password;
    String email;
    int Qte;
    String location;

    public Delivery() {
    }

    public Delivery(String name, String password, String email, String location, int Qte) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.Qte = Qte;
        this.location = location;
    }


    public static String getCurrDelevName() {
        return currDelevName;
    }

    public static void setCurrDelevName(String currDelevName) {
        Delivery.currDelevName = currDelevName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getQte() {
        return Qte;
    }

    public void setQte(int qte) {
        Qte = qte;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void incrimantQte() throws SQLException {
        PreparedStatement preparedStatement;
        ResultSet resultSet=null;
        String sql="UPDATE delevery SET Qte=Qte+1 WHERE name=? AND admin_id=? ;";
        preparedStatement=this.connect().prepareStatement(sql);
        preparedStatement.setString(1,Delivery.getCurrDelevName());
        preparedStatement.setInt(2,AdminInfo.getId());
        preparedStatement.executeUpdate();
    }
}
