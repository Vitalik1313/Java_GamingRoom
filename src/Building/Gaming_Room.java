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

    public void showInventory(){
        System.out.println(nameOfRoom + ":");
        for (Inventory inventory : invent) {
            System.out.println(inventory);
        }
    }

    public boolean searchByGroup(String group){
        boolean founded = false;
        for (Inventory inventory : invent) {
            if (inventory.getGroup().equalsIgnoreCase(group)) {
                System.out.println(inventory);
                founded = true;
            }
        }
        return founded;
    }

    public boolean searchBySize(String size){
        boolean founded = false;
        for (Inventory inventory : invent) {
            if (inventory.getDesc().getSize().equalsIgnoreCase(size)) {
                System.out.println(inventory);
                founded = true;
            }
        }
        return founded;
    }

    public boolean searchByName(String name){
        boolean founded = false;
        for (Inventory inventory : invent) {
            if (inventory.getDesc().getNameToy().equalsIgnoreCase(name)) {
                System.out.println(inventory);
                founded = true;
            }
        }
        return founded;
    }

    public void sortBySize(){
        invent.sort(Comparator.comparing(Inventory::getSize));
    }

    public void sortByPrice(){
        invent.sort(Comparator.comparing(Inventory::getPrice));
    }

    public void sortByGroup(){
        invent.sort(Comparator.comparing(Inventory::getGroup));
    }

    public void sortByNumber(){invent.sort(Comparator.comparing(Inventory::getNumber));}

    public ArrayList<Inventory> getInvent() {
        return invent;
    }

    public void addNewToy() throws SQLException {
        System.out.println("\tADD MENU");
        System.out.println("1 - add Sport to Inventory");
        System.out.println("2 - add Toy to Inventory");
        System.out.println("3 - add Device to Inventory");
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter choice:");
        int choice = scan.nextInt();

        Inventory tempObj;
        String tableName;
        if(choice == 1){
            tableName = "dbo.SportRoom";
            tempObj = new Sport();

        } else if (choice == 2) {
            tableName = "dbo.ToysRoom";
            tempObj = new Toy();

        } else if (choice == 3) {
            tableName = "dbo.DeviceRoom";
            tempObj = new Device();

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


