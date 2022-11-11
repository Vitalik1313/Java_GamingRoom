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
        System.out.println(nameOfRoom + ":");
        for(int i = 0;i < invent.size();i++) {
            System.out.println(invent.get(i));
        }
    }

    public boolean searchByGroup(String group){
        boolean founded = false;
        for(int i = 0;i < invent.size();i++){
            if(invent.get(i).getGroup().equalsIgnoreCase(group)){
                System.out.println(invent.get(i));
                founded = true;
            }
        }
        return founded;
    }

    public boolean searchBySize(String size){
        boolean founded = false;
        for(int i = 0;i < invent.size();i++){
            if(invent.get(i).getDesc().getSize().equalsIgnoreCase(size)){
                System.out.println(invent.get(i));
                founded = true;
            }
        }
        return founded;
    }

    public boolean searchByName(String name){
        boolean founded = false;
        for(int i = 0;i < invent.size();i++){
            if(invent.get(i).getDesc().getNameToy().equalsIgnoreCase(name)){
                System.out.println(invent.get(i));
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
}
