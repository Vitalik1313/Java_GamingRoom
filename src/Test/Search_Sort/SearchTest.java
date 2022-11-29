package Search_Sort;

import Building.Building;
import Building.Gaming_Room;
import Inventory.Sport;
import Inventory.Toy;
import Logger.MyLogger;
import SSMS_Con.SSMS;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;

public class SearchTest {
    SSMS connection;
    Building building;


    @Test
    public void TestSearchByGroup(){
        try {
            MyLogger log = new MyLogger();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            connection = new SSMS();
        } catch (
                SQLException | IOException e) {
            throw new RuntimeException(e);
        }
        building = new Building(connection.getConn());

        Gaming_Room room = new Gaming_Room("test",0,3, connection.getConn(), building);
        room.buyInventory(new Sport("small","test1",0," "," ",0,1));
        room.buyInventory(new Toy("small","doll",15,43632,"kite",2));

        Assert.assertNotEquals("",room.searchByGroup("Sport"));
    }

    @Test
    public void TestSearchBySize(){
        try {
            MyLogger log = new MyLogger();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            connection = new SSMS();
        } catch (
                SQLException | IOException e) {
            throw new RuntimeException(e);
        }
        Gaming_Room room = new Gaming_Room("test",0,3,connection.getConn(), building);
        room.buyInventory(new Sport("small","test1",0," "," ",0,1));
        room.buyInventory(new Toy("medium","doll",15,43632,"kite",2));

        Assert.assertNotEquals("",room.searchBySize("SMALL"));

    }

    @Test
    public void TestSearchByName(){
        try {
            MyLogger log = new MyLogger();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            connection = new SSMS();
        } catch (
                SQLException | IOException e) {
            throw new RuntimeException(e);
        }
        Gaming_Room room = new Gaming_Room("test",0,3,connection.getConn(), building);
        room.buyInventory(new Sport("small","test1",0," "," ",0,1));
        room.buyInventory(new Toy("small","doll",15,43632,"kite",2));

        Assert.assertNotEquals("",room.searchByName("DOLL"));
    }
}
