package Inventory;

import Inventory.Inventory;

public class Device extends Inventory {
    private int rentCost;
    private int termMonth;

    Device(String size,String name,int price,int rentCost,int termMonth){
        desc.setNameToy(name);
        desc.setPrice(price);
        desc.setSize(size);
        this.rentCost = rentCost;
        this.termMonth = termMonth;
    }

    public int getRentCost() {
        return rentCost;
    }
}
