package Modules;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GlobalModel extends DataBaseinfo {

    public boolean checkUserName(String name,String table) throws SQLException {

        PreparedStatement preparedStatement;
        ResultSet resultSet=null;
        String sql="SELECT name FROM " +table+" WHERE name=?;";
        preparedStatement=this.connect().prepareStatement(sql);
        preparedStatement.setString(1,name);
        resultSet=  preparedStatement.executeQuery();
        return resultSet.next();
    }
}
