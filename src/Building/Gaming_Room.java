package Building;

import Inventory.Inventory;
import Inventory.Sport;
import java.util.ArrayList;

public class Gaming_Room {
    ArrayList<Inventory> invent;
    String nameOfRoom;
    int noRoom;
    int numberToys;

    public Gaming_Room(String nameOfRoom,int noRoom,int numberToys){
        invent = new ArrayList<>(numberToys);
        this.nameOfRoom = nameOfRoom;
        this.noRoom = noRoom;
        this.numberToys = numberToys;
    }

    public void buyInventory(Inventory inv){
        invent.add(inv);
    }

    public void showInventory(){
        for(int i = 0;i < invent.size();i++) {
            System.out.println(invent.get(i));
        }
    }
}
