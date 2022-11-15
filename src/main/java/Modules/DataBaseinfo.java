package Modules;

import java.sql.*;

public class DataBaseinfo {

    private String username="root";
    private String password="javaDB";
    private String con_string="jdbc:mysql://localhost/etudiants";
    private Connection con;

    public Connection connect() throws SQLException {
        return DriverManager.getConnection(con_string,username,password);
    }


}
