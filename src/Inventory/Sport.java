package Inventory;

import Inventory.Inventory;

public class Sport extends Inventory {
    private String sportName;
    private String quality;

    Sport(String size,String name,int price,String sportName,String quality){
        desc.setNameToy(name);
        desc.setPrice(price);
        desc.setSize(size);
        this.sportName = sportName;
        this.quality = quality;
    }
}
