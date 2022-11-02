package SSMS_Con;

import java.sql.*;

public class SSMS {
    private Connection conn;
    public SSMS() throws SQLException {
        conn = null;
        try {
            String user = "DESKTOP-1F90U0Q\\admin";
            String dbURL = "jdbc:sqlserver://DESKTOP-1F90U0Q\\SQLEXPRESS;dataBase=Inventory;integratedSecurity=true";
            conn = DriverManager.getConnection(dbURL);
            System.out.println("all ok");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Connection getConn() {
        return conn;
    }
}
