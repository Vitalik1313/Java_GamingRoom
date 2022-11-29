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
    public SSMS() throws SQLException, IOException {
        conn = null;
        try {
            String user = "DESKTOP-1F90U0Q\\admin";
            String dbURL = "jdbc:sqlserver://DESKTOP-1F90U0Q\\SQLEXPRESS;dataBase=Inventory;integratedSecurity=true";
            conn = DriverManager.getConnection(dbURL);
            MyLogger.getLogger().info("Connected to SSMS successfully");
        } catch (SQLException ex) {
            MyLogger.getLogger().severe("SQL Server don't response\n");
            EmailSender sender = null;
            try {
                sender = new EmailSender();
            } catch (MessagingException e) {
                throw new RuntimeException(e);
            }
            try {
                sender.sendMsg("SQL SERVER CAN'T RESPONSE");
            } catch (MessagingException e) {
                throw new RuntimeException(e);
            }
            System.exit(0);
        }
    }

    public Connection getConn() {
        return conn;
    }
}
