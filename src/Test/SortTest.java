import Building.Gaming_Room;
import Inventory.*;
import org.junit.Assert;
import org.junit.Test;

public class SortTest {
    @Test
    public void TestSortBySize(){
        Gaming_Room room = new Gaming_Room("test",0,3);
        room.buyInventory(new Sport("small","test1",0," "," ",0,1));
        room.buyInventory(new Sport("big","test2",0," "," ",0,1));
        room.buyInventory(new Sport("medium","test3",0," "," ",0,1));
        room.sortBySize();
        for (int i = 0;i < room.getInvent().size() - 1;++i) {
            int temp = room.getInvent().get(i).getSize().compareTo(room.getInvent().get(i+1).getSize());
            Assert.assertFalse(temp > 0);
        }
    }

    @Test
    public void TestSortByPrice(){
        Gaming_Room room = new Gaming_Room("test",0,3);
        room.buyInventory(new Sport("small","test1",100," "," ",0,1));
        room.buyInventory(new Sport("big","test2",25," "," ",0,1));
        room.buyInventory(new Sport("medium","test3",433," "," ",0,1));
        room.sortByPrice();
        for (int i = 0;i < room.getInvent().size() - 1;++i) {
            Assert.assertFalse(room.getInvent().get(i).getPrice() > room.getInvent().get(i+1).getPrice());
        }
    }

    @Test
    public void TestSortByGroup(){
        Gaming_Room room = new Gaming_Room("test",0,3);
        room.buyInventory(new Sport("small","test1",0," "," ",0,1));
        room.buyInventory(new Toy("small","doll",15,43632,"kite",2));
        room.buyInventory(new Sport("medium","test3",0," "," ",0,1));
        room.sortByGroup();
        for (int i = 0;i < room.getInvent().size() - 1;++i) {
            int temp = room.getInvent().get(i).getGroup().compareTo(room.getInvent().get(i+1).getGroup());
            Assert.assertFalse(temp > 0);
        }
    }

    @Test
    public void TestSortByNumber(){
        Gaming_Room room = new Gaming_Room("test",0,3);
        room.buyInventory(new Sport("small","test1",0," "," ",0,7));
        room.buyInventory(new Toy("small","doll",15,43632,"kite",3));
        room.buyInventory(new Sport("medium","test3",0," "," ",0,25));
        room.sortByNumber();
        for (int i = 0;i < room.getInvent().size() - 1;++i) {
            Assert.assertFalse(room.getInvent().get(i).getNumber() > room.getInvent().get(i+1).getNumber());
        }
    }


}
