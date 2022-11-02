package Building;

import Inventory.Device;
import Inventory.Sport;
import Inventory.Toy;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Building {
    ArrayList<Gaming_Room> rooms;
    private final int maxBudget;
    private final int maxNumberToys;
    private int curBudget;

    public Building(){
        rooms = new ArrayList <>(3);
        maxBudget = 6000;
        maxNumberToys = 60;
        curBudget = maxBudget;
        for(int i = 0;i < 3;i++){
            String name = "room" + (i+1);
            rooms.add(new Gaming_Room(name,i+1,maxNumberToys / 3));
        }
    }

    public void fillRooms(Connection conn) throws SQLException {
        Statement stat = conn.createStatement();

        for(int i = 0; i < rooms.size();i++) {
            String query = "Select * from dbo.SportRoom" + (i+1);
            ResultSet rs = stat.executeQuery(query);

            while (rs.next()) {
                rooms.get(i).buyInventory(new Sport(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7)));
            }

            query = "Select * from dbo.DeviceRoom" + (i+1);
            rs = stat.executeQuery(query);

            while (rs.next()) {
                rooms.get(i).buyInventory(new Device(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getInt(7)));
            }

            query = "Select * from dbo.ToysRoom" + (i+1);
            rs = stat.executeQuery(query);

            while (rs.next()) {
                rooms.get(i).buyInventory(new Toy(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getInt(6)));
            }
        }
       rooms.get(2).showInventory();
    }

    public void showAllInventory(){
        for (Gaming_Room room : rooms) {
            room.showInventory();
        }
    }
}

