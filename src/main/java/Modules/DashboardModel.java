package Modules;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DashboardModel extends  GlobalModel{
    public int numDonors() throws SQLException {
        PreparedStatement preparedStatement;
        ResultSet resultSet=null;
        String sql="SELECT COUNT(*) as num  FROM donor WHERE admin_id=?;";
        preparedStatement=this.connect().prepareStatement(sql);
        preparedStatement.setInt(1,AdminInfo.getId());
        resultSet=  preparedStatement.executeQuery();

        if (!resultSet.next()){
            return 0;
        }
        return  resultSet.getInt(1);
    };

    public int numPatients() throws SQLException {
        PreparedStatement preparedStatement;
        ResultSet resultSet=null;
        String sql="SELECT COUNT(*) as num  FROM patient WHERE admin_id=?;";
        preparedStatement=this.connect().prepareStatement(sql);
        preparedStatement.setInt(1,AdminInfo.getId());
        resultSet=  preparedStatement.executeQuery();

        if (!resultSet.next()){
            return 0;
        }
        return  resultSet.getInt(1);
    };

    public int numTransfers() throws SQLException {
        PreparedStatement preparedStatement;
        ResultSet resultSet=null;
        String sql="SELECT COUNT(*) as num  FROM patient WHERE admin_id=? AND statut='traité';";
        preparedStatement=this.connect().prepareStatement(sql);
        preparedStatement.setInt(1,AdminInfo.getId());
        resultSet=  preparedStatement.executeQuery();

        if (!resultSet.next()){
            return 0;
        }
        return  resultSet.getInt(1);
    };


    public int getNumberofBloodTypes(String name) throws SQLException {
        PreparedStatement preparedStatement;
        ResultSet resultSet=null;
        String sql="SELECT blood_Grp ,COUNT(*) as 'numberBlood' FROM donor WHERE statut !='traité' AND blood_Grp=? AND admin_id=? GROUP BY blood_Grp;";
        preparedStatement=this.connect().prepareStatement(sql);
        preparedStatement.setString(1,name);
        preparedStatement.setInt(2,AdminInfo.getId());
        resultSet=  preparedStatement.executeQuery();

        if (!resultSet.next()){
            return 0;
        }
        return  resultSet.getInt(2);
    };

}
