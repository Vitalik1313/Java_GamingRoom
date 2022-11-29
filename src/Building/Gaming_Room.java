package Building;

import Inventory.Inventory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import Inventory.*;
import Logger.MyLogger;
import SSMS_Con.SSMS;

public class Gaming_Room {
    ArrayList<Inventory> invent;
    String nameOfRoom;
    Connection conn;
    int noRoom;
    int numberToys;
    Building build;

    public Gaming_Room(String nameOfRoom, int noRoom, int numberToys, Connection conn,Building build){
        this.build = build;
        this.conn = conn;
        invent = new ArrayList<>();
        this.nameOfRoom = nameOfRoom;
        this.noRoom = noRoom;
        this.numberToys = numberToys;
    }

    public void buyInventory(Inventory inv){
        invent.add(inv);
    }

    public String showInventory(){
        System.out.println(nameOfRoom + ":");
        String output = "";
        for (Inventory inventory : invent) {
            output = output.concat(inventory.toString() + "\n");
            System.out.println(inventory);
        }
        return output;
    }

    public String searchByGroup(String group){
        String output = "";
        for (Inventory inventory : invent) {
            if (inventory.getGroup().equalsIgnoreCase(group)) {
                System.out.println(inventory);
                output = output.concat(inventory.toString() + "\n");
            }
        }
        return output;
    }

    public String searchBySize(String size){
        String output = "";
        for (Inventory inventory : invent) {
            if (inventory.getDesc().getSize().equalsIgnoreCase(size)) {
                System.out.println(inventory);
                output = output.concat(inventory.toString() + "\n");
            }
        }
        return output;
    }

    public String searchByName(String name){
        String output = "";
        for (Inventory inventory : invent) {
            if (inventory.getDesc().getNameToy().equalsIgnoreCase(name)) {
                System.out.println(inventory);
                output = output.concat(inventory.toString() + "\n");
            }
        }
        return output;
    }

    public String sortBySize(){
        invent.sort(Comparator.comparing(Inventory::getSize));
        return showInventory();
    }

    public String sortByPrice(){
        invent.sort(Comparator.comparing(Inventory::getPrice));
        return showInventory();
    }

    public String sortByGroup(){
        invent.sort(Comparator.comparing(Inventory::getGroup));
        return showInventory();
    }

    public String sortByNumber(){
        invent.sort(Comparator.comparing(Inventory::getNumber));
        return showInventory();
    }

    public ArrayList<Inventory> getInvent() {
        return invent;
    }

    public void addNewToy(Inventory obj,String selected) throws SQLException {
        Inventory tempObj = obj;
        String tableName;
        if(selected.equalsIgnoreCase("Sport")){
            tableName = "dbo.SportRoom";
        } else if (selected.equalsIgnoreCase("Toy")) {
            tableName = "dbo.ToysRoom";
        } else if (selected.equalsIgnoreCase("Device")) {
            tableName = "dbo.DeviceRoom";
        }
        else {
            System.out.println("Wrong input");
            return;
        }

        int check = 0;
        for(Inventory i : invent){
            if(i.getDesc().getId() == tempObj.getDesc().getId()){
                i.incNumber();
                check = 1;
            }
        }
        if(check == 0){
            invent.add(tempObj);
        }
        build.getAccounting().reduceBudget(tempObj.getPrice());
        build.getAccounting().addNewToy();
        tableName += noRoom;
        updateDB(tempObj,tableName);
    }

    public void updateDB(Inventory obj,String table) throws SQLException {
        Statement stat;
        try {
            stat = conn.createStatement();
            MyLogger.getLogger().info("Connection to add was set");
        }
        catch (SQLException e){
            MyLogger.getLogger().severe("Cannot connect");
            return;
        }
        ResultSet rs = stat.executeQuery("SELECT * FROM " + table + " WHERE id=" + obj.getDesc().getId());
        if(!rs.isBeforeFirst()){
            if(obj.getGroup().equalsIgnoreCase("Sport")){
                stat.execute("INSERT INTO " + table + " (size,name,price,id,number,quality,sportName) " + "VALUES "
                        + "('" + obj.getSize()+ "','" + obj.getName() +  "',"+ obj.getPrice() + "," + obj.getDesc().getId()
                        + "," + obj.getNumber() + ",'" +  ((Sport)obj).getQuality()+ "','" +((Sport)obj).getSportName() + "')");
            }
            else if(obj.getGroup().equalsIgnoreCase("Toy")){
               stat.execute("INSERT INTO " + table + " (size,name,price,id,number,brand) " + "VALUES "
                        + "('" + obj.getSize() +"','" + obj.getName() + "',"+obj.getPrice() + "," + obj.getDesc().getId()
                        + "," + obj.getNumber() + ",'" + ((Toy)obj).getBrand() + "')");
            }
            else if(obj.getGroup().equalsIgnoreCase("Device")){
                stat.execute("INSERT INTO " + table + " (size,name,price,id,number,rentCost,termMonth) " + "VALUES "
                        + "('" + obj.getSize() +"','" + obj.getName() + "',"+obj.getPrice() + "," + obj.getDesc().getId()
                        + "," + obj.getNumber() + "," + ((Device)obj).getRentCost() + "," + ((Device)obj).getTermMonth() + ")");
            }
        }
        else {
            stat.execute("UPDATE " + table + " SET number=number+1" + " WHERE id=" + obj.getDesc().getId());
        }
    }
}


