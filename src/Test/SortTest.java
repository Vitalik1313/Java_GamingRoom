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
}
