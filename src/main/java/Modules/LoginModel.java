package Modules;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}
