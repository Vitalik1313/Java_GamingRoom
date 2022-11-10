package Building;

import Inventory.Device;
import Inventory.Inventory;
import Inventory.Sport;
import Inventory.Toy;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Building {
    private String nameOfBuilding;
    private ArrayList<Gaming_Room> rooms;
    private final int maxBudget;
    private final int maxNumberToys;
    private int curBudget;
    private int curNumberToys;
    private ArrayList<Inventory> fullInvent;

    public Building(){
        nameOfBuilding = "House of fun";
        fullInvent = new ArrayList<Inventory>();
        rooms = new ArrayList <>(3);
        maxBudget = 20000;
        maxNumberToys = 60;
        curBudget = maxBudget;
        curNumberToys = 0;
        for(int i = 0;i < 3;i++){
            String name = "Room-" + (i+1);
            rooms.add(new Gaming_Room(name,i+1,maxNumberToys / 3));
        }
    }

    public void fillRooms(Connection conn) throws SQLException {
        Statement stat = conn.createStatement();

        for(int i = 0; i < rooms.size();i++) {
            String query = "Select * from dbo.SportRoom" + (i+1);
            ResultSet rs = stat.executeQuery(query);

            while (rs.next()) {
                if(((curBudget - rs.getInt(3)) < 0) || (curNumberToys == maxNumberToys)){
                    System.out.println("Unable to buy - " + rs.getString(1) + " ID:" + rs.getInt(6));
                }else {
                    rooms.get(i).buyInventory(new Sport(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7)));
                    curBudget -= rs.getInt(3);
                    curNumberToys += 1;
                }
            }

            query = "Select * from dbo.DeviceRoom" + (i+1);
            rs = stat.executeQuery(query);

            while (rs.next()) {
                if(((curBudget - rs.getInt(3)) < 0) || (curNumberToys == maxNumberToys)){
                    System.out.println("Unable to buy - " + rs.getString(1) + " ID:" + rs.getInt(6));
                }else {
                    rooms.get(i).buyInventory(new Device(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getInt(7)));
                    curBudget -= rs.getInt(4);
                    curNumberToys += 1;
                }
            }

            query = "Select * from dbo.ToysRoom" + (i+1);
            rs = stat.executeQuery(query);

            while (rs.next()) {
                if(((curBudget - rs.getInt(3)) < 0) ||  (curNumberToys == maxNumberToys)){
                    System.out.println("Unable to buy - " + rs.getString(1) + " ID:" + rs.getInt(6));
                }else {
                    rooms.get(i).buyInventory(new Toy(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getInt(6)));
                    curBudget -= rs.getInt(3);
                    curNumberToys += 1;
                }
            }
        }
        fillFullInvent();
    }

    public void showAllInventory(){
        for(Inventory invent : fullInvent){
            System.out.println(invent);
        }
    }

    public void showInventoryInRoom(int numberRoom){
        rooms.get(numberRoom).showInventory();
    }

    public void searchByGroup(String group){
        for (Gaming_Room room : rooms) {
            room.searchByGroup(group);
        }
    }

    public void searchBySize(String size){
        for (Gaming_Room room : rooms) {
            room.searchBySize(size);
        }
    }

    public void searchByName(String name){
        for (Gaming_Room room : rooms) {
            room.searchByName(name);
        }
    }

    public void sortBySize(){
        fullInvent.sort(Comparator.comparing(Inventory::getSize));
        showAllInventory();
    }

    public void sortByPrice(){
        fullInvent.sort(Comparator.comparing(Inventory::getPrice));
        showAllInventory();
    }

    public void sortByGroup(){
        fullInvent.sort(Comparator.comparing(Inventory::getGroup));
        showAllInventory();
    }

    public void sortByNumber(){
        fullInvent.sort(Comparator.comparing(Inventory::getNumber));
        showAllInventory();
    }

    public ArrayList<Gaming_Room> getRooms() {
        return rooms;
    }

    public void budgetInfo(){
        System.out.println("\n\tMaximum budget of \"" + nameOfBuilding + "\" - " + maxBudget + "$");
        System.out.println("\tCurrent budget - " + curBudget + "$\n");
    }

    void fillFullInvent(){
        for (Gaming_Room room : rooms) {
            fullInvent.addAll(room.invent);
        }
    }
}

