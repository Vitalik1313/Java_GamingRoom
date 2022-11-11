import Building.Gaming_Room;
import Inventory.Sport;
import Inventory.Toy;
import org.junit.Assert;
import org.junit.Test;

public class SearchTest {
    @Test
    public void TestSearchByGroup(){
        Gaming_Room room = new Gaming_Room("test",0,3);
        room.buyInventory(new Sport("small","test1",0," "," ",0,1));
        room.buyInventory(new Toy("small","doll",15,43632,"kite",2));

        Assert.assertTrue(room.searchByGroup("Sport"));
        Assert.assertFalse(room.searchByGroup("Device"));
    }

    @Test
    public void TestSearchBySize(){
        Gaming_Room room = new Gaming_Room("test",0,3);
        room.buyInventory(new Sport("small","test1",0," "," ",0,1));
        room.buyInventory(new Toy("medium","doll",15,43632,"kite",2));

        Assert.assertTrue(room.searchBySize("SMALL"));
        Assert.assertFalse(room.searchBySize("big"));
    }

    @Test
    public void TestSearchByName(){
        Gaming_Room room = new Gaming_Room("test",0,3);
        room.buyInventory(new Sport("small","test1",0," "," ",0,1));
        room.buyInventory(new Toy("small","doll",15,43632,"kite",2));

        Assert.assertTrue(room.searchByName("DOLL"));
        Assert.assertFalse(room.searchByName("pen"));
    }
}
