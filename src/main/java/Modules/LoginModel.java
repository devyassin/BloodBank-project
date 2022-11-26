package Modules;

import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginModel extends GlobalModel{

    public LoginModel() {
    }

    public boolean ChekLoginInfo(String name,String password,String type) throws SQLException {

        PreparedStatement preparedStatement;
        ResultSet resultSet=null;
        String sql="SELECT name FROM "+ type+ " WHERE name=? AND passwor=?;";
        preparedStatement=this.connect().prepareStatement(sql);
        preparedStatement.setString(1,name);
        preparedStatement.setString(2,password);
        resultSet=  preparedStatement.executeQuery();

        return resultSet.next();
    };

    public int getAdminId(String name) throws SQLException {
        PreparedStatement preparedStatement;
        ResultSet resultSet=null;
        String sql="SELECT * FROM admin WHERE name=? ;";
        preparedStatement=this.connect().prepareStatement(sql);
        preparedStatement.setString(1,name);
        resultSet=  preparedStatement.executeQuery();

         if (!resultSet.next()){
             return 0;
         }
        return  resultSet.getInt(1);
    };
};
