package Inventory;

import Inventory.Inventory;

public class Device extends Inventory {
    private int rentCost;
    private int termMonth;

    public Device(String size,String name,int price,int rentCost,int termMonth,int id,int number){
        desc = new Description(size,name,price,id,number);
        this.rentCost = rentCost;
        this.termMonth = termMonth;
        setGroup("Device");
    }

    public int getRentCost() {
        return rentCost;
    }

    @Override
    public String toString() {
        return "Device - " + desc +
                " rentCost = " + rentCost +
                ", termMonth = " + termMonth;
    }
}
