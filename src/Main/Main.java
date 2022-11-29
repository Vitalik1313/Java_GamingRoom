package Main;

import Building.Building;
import Graphics.GraphicsMain;
import Logger.MyLogger;
import MailSender.EmailSender;
import Menus.MenuInit;
import SSMS_Con.SSMS;


import javax.mail.MessagingException;
import java.io.IOException;
import java.sql.SQLException;


public class Main  {
    public static void main  (String[] args) throws SQLException, IOException, MessagingException {

        MyLogger logger = new MyLogger();
        EmailSender sender = new EmailSender();

        SSMS connection = new SSMS();
        Building building = new Building(connection.getConn());

        /*try {
            building.fillRooms();
            MyLogger.getLogger().info("Rooms filled by inventory");
        }
        catch (SQLException e){
            MyLogger.getLogger().severe("Error filling rooms");
            sender.sendMsg("ERROR: CAN'T FILL ROOMS");
        }*/

        GraphicsMain graphicsMain = new GraphicsMain();
        graphicsMain.setBuilding_Conn(building,connection);
        graphicsMain.startWindow();

       // new MenuInit(building);
    }

}


