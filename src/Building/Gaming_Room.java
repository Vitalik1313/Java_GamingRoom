package Building;

import Inventory.Inventory;
import Inventory.Sport;

import java.util.*;

public class Gaming_Room {
    ArrayList<Inventory> invent;
    String nameOfRoom;
    int noRoom;
    int numberToys;

    public Gaming_Room(String nameOfRoom,int noRoom,int numberToys){
        invent = new ArrayList<>();
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

    public void searchByGroup(String group){
        for(int i = 0;i < invent.size();i++){
            if(Objects.equals(invent.get(i).getGroup(), group)){
                System.out.println(invent.get(i));
            }
        }
    }

    public void searchBySize(String size){
        for(int i = 0;i < invent.size();i++){
            if(Objects.equals(invent.get(i).getDesc().getSize(), size)){
                System.out.println(invent.get(i));
            }
        }
    }

    public void searchByName(String name){
        for(int i = 0;i < invent.size();i++){
            if(Objects.equals(invent.get(i).getDesc().getNameToy(), name)){
                System.out.println(invent.get(i));
            }
        }
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

}
