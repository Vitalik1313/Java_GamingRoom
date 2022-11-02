package Inventory;

import Inventory.Inventory;

public class Sport extends Inventory {
    private String sportName;
    private String quality;

    public Sport(String size,String name,int price,String sportName,String quality,int id,int number){
        desc = new Description(size,name,price,id,number);
        this.sportName = sportName;
        this.quality = quality;
        setGroup("Sport");
    }

    @Override
    public String toString() {
        return "Sport{" +
                "sportName='" + sportName + '\'' +
                ", quality='" + quality + '\'' +
                ", desc=" + desc +
                '}';
    }

}
