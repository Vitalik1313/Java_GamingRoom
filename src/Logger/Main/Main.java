package Logger.Main;

import Building.Building;
import Logger.MyLogger;
import Menus.MenuInit;
import SSMS_Con.SSMS;


import javax.mail.MessagingException;
import java.io.IOException;
import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws SQLException, IOException, MessagingException {
        new MailSender.EmailSender();
        MyLogger logger = new MyLogger();

        SSMS connection = new SSMS();
        Building building = new Building(connection.getConn());

        try {
            building.fillRooms();
            MyLogger.getLogger().info("Rooms filled by inventory");
        }
        catch (SQLException e){
            MyLogger.getLogger().severe("Error filling rooms");
        }

        new MenuInit(building);
    }
}


