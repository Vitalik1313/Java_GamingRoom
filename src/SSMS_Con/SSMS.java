package SSMS_Con;

import Logger.MyLogger;
import MailSender.EmailSender;
import com.sun.net.httpserver.Authenticator;
import org.junit.internal.runners.statements.Fail;

import javax.mail.MessagingException;
import java.io.IOException;
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
            try {
                EmailSender sender = new EmailSender();
                sender.sendMsg("SQL SERVER CAN'T RESPONSE");
            } catch (IOException e) {
                MyLogger.getLogger().severe("IOException error");
            } catch (MessagingException e) {
                throw new RuntimeException(e);
            }
            ex.printStackTrace();
            System.exit(0);
        }
    }

    public Connection getConn() {
        return conn;
    }
}
