package SSMS_Con;

import Logger.MyLogger;

import java.sql.*;

public class SSMS {
    private Connection conn;
    public SSMS() throws SQLException {
        conn = null;
        try {
            String user = "DESKTOP-1F90U0Q\\admin";
            String dbURL = "jdbc:sqlserver://DESKTOP-1F90U0Q\\SQLEXPRESS;dataBase=Inventory;integratedSecurity=true";
            conn = DriverManager.getConnection(dbURL);
            MyLogger.getLogger().info("Connected to SSMS successfully");
        } catch (SQLException ex) {
            MyLogger.getLogger().severe("SQL Server don't response\n");
            ex.printStackTrace();
        }
    }

    public Connection getConn() {
        return conn;
    }
}
