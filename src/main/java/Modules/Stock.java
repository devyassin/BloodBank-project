package Modules;

import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Stock extends GlobalModel{
    String groupe;
    int stock;


    public Stock() {
    }

    public Stock(String groupe, int stock) {
        this.groupe = groupe;
        this.stock = stock;
    }

    public String getGroupe() {
        return groupe;
    }

    public void setGroupe(String groupe) {
        this.groupe = groupe;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void showStock(ObservableList<Stock> stockList) throws SQLException {
        String sql="SELECT blood_Grp , COUNT(blood_Grp) AS stock  FROM donor WHERE admin_id='"+AdminInfo.getId()+"' AND statut='true' GROUP BY blood_Grp;";
        Statement s=this.connect().createStatement();
        ResultSet r=s.executeQuery(sql);

        while (r.next()){
            stockList.add(new Stock(
                    r.getString("blood_Grp"),
                    r.getInt("stock")));
        }

    }
    public String   getnbStock() throws SQLException {
        String sql="SELECT blood_Grp , COUNT(blood_Grp) AS total  FROM donor WHERE admin_id='"+AdminInfo.getId()+"' AND statut='true';";
        Statement s=this.connect().createStatement();
        ResultSet r=s.executeQuery(sql);

        if (r.next()){
            return r.getString("total");
        }
        return "";
    }
}

