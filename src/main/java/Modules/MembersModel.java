package Modules;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MembersModel extends GlobalModel{
    public MembersModel(){

    }


    public void showDonors(ObservableList<Donors> donorsList) throws SQLException {
        String sql="SELECT * FROM donor;";
        Statement s=this.connect().createStatement();
        ResultSet r=s.executeQuery(sql);

        while (r.next()){
            donorsList.add(new Donors(r.getInt("donor_id"),
                    r.getString("name"),
                    r.getString("email"),
                    r.getString("blood_Grp"),
                    r.getString("addres")));
        }
    }

    public void insertOnDonorTable(String name, String email, String location, String groupe) throws SQLException {
        PreparedStatement preparedStatement;
        ResultSet resultSet=null;
        String sql="INSERT INTO donor(name,email,addres,blood_Grp,admin_id) VALUES(?,?,?,?,?);";
        preparedStatement=this.connect().prepareStatement(sql);
        preparedStatement.setString(1,name);
        preparedStatement.setString(2,email);
        preparedStatement.setString(3,location);
        preparedStatement.setString(4,groupe);
        preparedStatement.setInt(5,AdminInfo.getId());
        preparedStatement.executeUpdate();

    }
}
