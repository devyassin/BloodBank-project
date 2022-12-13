package Modules;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Techniciens {
    static  String currPatientName;
    String name;
    String password;
    String email;
    int NbTransfert;
    String location;


    public Techniciens(String name, String password, String email, int nbTransfert, String location) {
        this.name = name;
        this.password = password;
        this.email = email;
        NbTransfert = nbTransfert;
        this.location = location;
    }

    public static String getCurrPatientName() {
        return currPatientName;
    }

    public static void setCurrPatientName(String currPatientName) {
        Techniciens.currPatientName = currPatientName;
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

    public int getNbTransfert() {
        return NbTransfert;
    }

    public void setNbTransfert(int nbTransfert) {
        NbTransfert = nbTransfert;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
