package Modules;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RegisterModel extends GlobalModel{
    public RegisterModel() {
    }


    public void insertOnAdminTable(String name, String password, String email, String address) throws SQLException {
        PreparedStatement preparedStatement;
        ResultSet resultSet=null;
        String sql="INSERT INTO admin(name,passwor,email,address) VALUES(?,?,?,?);";
        preparedStatement=this.connect().prepareStatement(sql);
        preparedStatement.setString(1,name);
        preparedStatement.setString(2,password);
        preparedStatement.setString(3,email);
        preparedStatement.setString(4,address);
        preparedStatement.executeUpdate();

    }
}
