package Modules;

import java.sql.Connection;
import java.sql.SQLException;

public class BloodTModel extends GlobalModel{
    Connection con=this.connect();

    public BloodTModel() throws SQLException {
    }

    public String printCon(){
        System.out.println(this.con);
        String test="test";
        return test;
    }
}
