package Inventory;

import Inventory.Inventory;

public class Toy extends Inventory {
    private String brand;

    Toy(String size,String name,int price,String brand){
        desc.setNameToy(name);
        desc.setPrice(price);
        desc.setSize(size);
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }
}
