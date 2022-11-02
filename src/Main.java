import Building.Building;
import Menus.MenuInit;
import SSMS_Con.SSMS;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Building building = new Building();
        SSMS connection = new SSMS();
        building.fillRooms(connection.getConn());
        building.showAllInventory();
       new MenuInit();
    }
}
