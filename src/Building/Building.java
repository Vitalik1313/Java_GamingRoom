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
import java.util.Comparator;


public class Building {
    private final String nameOfBuilding;
    private ArrayList<Gaming_Room> rooms;
    private Accounting accounting;
    private ArrayList<Inventory> fullInvent;
    private Connection conn;

    public Building(Connection conn){
        this.conn = conn;
        accounting = new Accounting();
        nameOfBuilding = "House of fun";
        fullInvent = new ArrayList<Inventory>();
        rooms = new ArrayList <>(3);
        for(int i = 0;i < 3;i++){
            String name = "Room-" + (i+1);
            rooms.add(new Gaming_Room(name,i+1,accounting.getMaxNumberToys() / 3,conn,this));
        }
    }

    public Accounting getAccounting() {
        return accounting;
    }

    public boolean fillRooms() throws SQLException {
        Statement stat = conn.createStatement();

        for(int i = 0; i < rooms.size();i++) {
            String query = "Select * from dbo.SportRoom" + (i+1);
            ResultSet rs = stat.executeQuery(query);

            while (rs.next()) {
                if(((accounting.getCurBudget() - rs.getInt(3)) < 0) || (accounting.getCurNumberToys() == accounting.getMaxNumberToys())){
                    System.out.println("Unable to buy - " + rs.getString(1) + " ID:" + rs.getInt(6));
                }else {
                    rooms.get(i).buyInventory(new Sport(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7)));
                    accounting.reduceBudget(rs.getInt(3));
                    accounting.addNewToy();
                }
            }

            query = "Select * from dbo.DeviceRoom" + (i+1);
            rs = stat.executeQuery(query);

            while (rs.next()) {
                if(((accounting.getCurBudget() - rs.getInt(3)) < 0) || (accounting.getCurNumberToys() == accounting.getMaxNumberToys())){
                    System.out.println("Unable to buy - " + rs.getString(1) + " ID:" + rs.getInt(6));
                }else {
                    rooms.get(i).buyInventory(new Device(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getInt(7)));
                    accounting.reduceBudget(rs.getInt(4));
                    accounting.addNewToy();
                }
            }

            query = "Select * from dbo.ToysRoom" + (i+1);
            rs = stat.executeQuery(query);

            while (rs.next()) {
                if(((accounting.getCurBudget() - rs.getInt(3)) < 0) ||  (accounting.getCurNumberToys() == accounting.getMaxNumberToys())){
                    System.out.println("Unable to buy - " + rs.getString(1) + " ID:" + rs.getInt(6));
                }else {
                    rooms.get(i).buyInventory(new Toy(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getInt(6)));
                    accounting.reduceBudget(rs.getInt(3));
                    accounting.addNewToy();
                }
            }
        }
        fillFullInvent();
        return true;
    }

    public void showAllInventory(){
        for(Inventory invent : fullInvent){
            System.out.println(invent);
        }
    }

    public void showInventoryInRoom(int numberRoom){
        rooms.get(numberRoom).showInventory();
    }

    public boolean searchByGroup(String group){
        boolean founded = false;
        for (Gaming_Room room : rooms) {
            if(room.searchByGroup(group))
                founded = true;
        }
        return founded;
    }

    public boolean searchBySize(String size){
        boolean founded = false;
        for (Gaming_Room room : rooms) {
            if(room.searchBySize(size))
                founded = true;
        }
        return founded;
    }

    public boolean searchByName(String name){
        boolean founded = false;
        for (Gaming_Room room : rooms) {
            if(room.searchByName(name))
                founded = true;
        }
        return founded;
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
        System.out.println(accounting);
    }

    void fillFullInvent(){
        for (Gaming_Room room : rooms) {
            fullInvent.addAll(room.invent);
        }
    }

    public void fillRoomsTest(){
        rooms.get(1).buyInventory(new Device("large","laptop",777,100,2,25616,3));
        rooms.get(0).buyInventory(new Sport("medium","ball machine",500,"football","new",15124,1));
        rooms.get(1).buyInventory(new Device("small","tablet",100,50,2,25612,1));
    }

    public void fillInventTest(){
        fullInvent.add(new Device("large","laptop",777,100,2,25616,3));
        fullInvent.add(new Sport("medium","ball machine",500,"football","new",15124,1));
        fullInvent.add(new Device("small","tablet",100,50,2,25612,1));
    }

    public ArrayList<Inventory> getFullInvent() {
        return fullInvent;
    }
}

