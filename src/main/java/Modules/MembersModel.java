package Modules;

import javafx.collections.ObservableList;

import java.sql.*;

public class MembersModel extends GlobalModel{
    public MembersModel(){

    }


    public void showDonors(ObservableList<Donors> donorsList) throws SQLException {
        String sql="SELECT * FROM donor WHERE admin_id='"+AdminInfo.getId()+"';";
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

    public void showDelivery(ObservableList<Delivery> deliveryList) throws SQLException {
        String sql="SELECT * FROM delevery WHERE admin_id='"+AdminInfo.getId()+"';";
        Statement s=this.connect().createStatement();
        ResultSet r=s.executeQuery(sql);

        while (r.next()){
            deliveryList.add(new Delivery(r.getString("name"),
                    r.getString("password"),
                    r.getString("email"),
                    r.getString("address"),
                    r.getInt("Qte")));
        }
    }

    public void showTechnicien(ObservableList<Techniciens> technecienList) throws SQLException {
        String sql="SELECT * FROM technicien WHERE admin_id='"+AdminInfo.getId()+"';";
        Statement s=this.connect().createStatement();
        ResultSet r=s.executeQuery(sql);

        while (r.next()){
            technecienList.add(new Techniciens(r.getString("name"),
                    r.getString("password"),
                    r.getString("email"),
                    r.getInt("nbTransfert"),
                    r.getString("address")
                    ));
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

    public void insertOnDeliveryTable(String name, String email, String location, String password) throws SQLException {
        PreparedStatement preparedStatement;
        ResultSet resultSet=null;
        String sql="INSERT INTO delevery(name,password,email,address,admin_id) VALUES(?,?,?,?,?);";
        preparedStatement=this.connect().prepareStatement(sql);
        preparedStatement.setString(1,name);
        preparedStatement.setString(2,password);
        preparedStatement.setString(3,email);
        preparedStatement.setString(4,location);
        preparedStatement.setInt(5,AdminInfo.getId());
        preparedStatement.executeUpdate();

    }

    public void insertOnTechnicienTable(String name, String email, String location, String password) throws SQLException {
        PreparedStatement preparedStatement;
        ResultSet resultSet=null;
        String sql="INSERT INTO Technicien(name,password,email,address,admin_id) VALUES(?,?,?,?,?);";
        preparedStatement=this.connect().prepareStatement(sql);
        preparedStatement.setString(1,name);
        preparedStatement.setString(2,password);
        preparedStatement.setString(3,email);
        preparedStatement.setString(4,location);
        preparedStatement.setInt(5,AdminInfo.getId());
        preparedStatement.executeUpdate();

    }
    public void deleteOnTable(String name,String table) throws SQLException {
        PreparedStatement preparedStatement;
        ResultSet resultSet=null;
        String sql="DELETE FROM "+ table +" WHERE name=? AND admin_id=?;";
        preparedStatement=this.connect().prepareStatement(sql);
        preparedStatement.setString(1,name);
        preparedStatement.setInt(2,AdminInfo.getId());
        preparedStatement.executeUpdate();
    }

    public String[] getDonorData(String name, String email, String location, String groupe,String table) throws SQLException {
        String data[]=new String[3];
        PreparedStatement preparedStatement;
        String sql="SELECT * FROM "+ table+" WHERE name= '"+name+"'"+ " AND "+ " admin_id= "+AdminInfo.getId() +" ;";
        Statement s=this.connect().createStatement();
        ResultSet r=s.executeQuery(sql);

        while (r.next()){
            email=  r.getString("email");
            groupe=  r.getString("blood_Grp");
            if (table == "donor") {
                location=  r.getString("addres");
            }else if(table=="patient"){
                location=  r.getString("address");
            }

            data[0]=email;
            data[1]=groupe;
            data[2]=location;
        }
        return data;
    }

    public String[] getDeliveryData(String name, String email, String location, String password,String table) throws SQLException {
        String data[]=new String[3];
        PreparedStatement preparedStatement;
        String sql="SELECT * FROM "+table+" WHERE name= '"+name+"'"+ " AND "+ " admin_id= "+AdminInfo.getId() +" ;";
        Statement s=this.connect().createStatement();
        ResultSet r=s.executeQuery(sql);

        while (r.next()){
            email=  r.getString("email");
            password=  r.getString("password");
            location=  r.getString("address");
            data[0]=email;
            data[1]=password;
            data[2]=location;
        }
        return data;
    }
    public void updateOnDonorTable(String name,String email,String location,String groupe) throws SQLException {
        PreparedStatement preparedStatement;
        ResultSet resultSet=null;
        String sql="UPDATE donor SET email=? ,  addres=? , blood_Grp=? WHERE name=? AND admin_id=?;";
        preparedStatement=this.connect().prepareStatement(sql);
        preparedStatement.setString(1,email);
        preparedStatement.setString(2,location);
        preparedStatement.setString(3,groupe);
        preparedStatement.setString(4,name);
        preparedStatement.setInt(5,AdminInfo.getId());
        preparedStatement.executeUpdate();
    }

    public void updateOnDeliveryTable(String name,String email,String location,String password,String table) throws SQLException {
        PreparedStatement preparedStatement;
        ResultSet resultSet=null;
        String sql="UPDATE "+table+ " SET email=? ,  address=? , password=? WHERE name=? AND admin_id=?;";
        preparedStatement=this.connect().prepareStatement(sql);
        preparedStatement.setString(1,email);
        preparedStatement.setString(2,location);
        preparedStatement.setString(3,password);
        preparedStatement.setString(4,name);
        preparedStatement.setInt(5,AdminInfo.getId());
        preparedStatement.executeUpdate();
    }

}
