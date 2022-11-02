package Inventory;

import Inventory.Inventory;

public class Toy extends Inventory {
    private String brand;

    public Toy(String size,String name,int price,int id,String brand,int number){
        desc = new Description(size,name,price,id,number);
        this.brand = brand;
        setGroup("Toy");
    }

    public String getBrand() {
        return brand;
    }

    @Override
    public String toString() {
        return "Toy{" +
                "brand='" + brand + '\'' +
                ", desc=" + desc +
                '}';
    }


}
