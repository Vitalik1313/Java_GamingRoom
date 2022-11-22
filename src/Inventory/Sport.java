package Inventory;

import Inventory.Inventory;
import org.junit.Ignore;

import java.util.Scanner;

public class Sport extends Inventory {
    private String sportName;
    private String quality;

    public Sport(String size,String name,int price,String sportName,String quality,int id,int number){
        desc = new Description(size,name,price,id,number);
        this.sportName = sportName;
        this.quality = quality;
        setGroup("Sport");
    }


    public Sport(){
        setGroup("Sport");
        String size, nameToy;
        int price, id;
        Scanner scanInt = new Scanner(System.in);
        Scanner scanString = new Scanner(System.in);
        System.out.println("Enter size:");
        size = scanString.nextLine();
        System.out.println("Enter name:");
        nameToy = scanString.nextLine();
        System.out.println("Enter price:");
        price = scanInt.nextInt();
        System.out.println("Enter ID:");
        id = scanInt.nextInt();

        System.out.println("Enter quality:");
        quality = scanString.nextLine();
        System.out.println("Enter sport name:");
        sportName = scanString.nextLine();
        desc = new Description(size,nameToy,price,id,1);
    }

    @Override
    public String toString() {
        return "Sport - " + desc +
                " sportName = '" + sportName  + '\'' +
                ", quality = '" + quality + '\'';
    }

    public String getSportName() {
        return sportName;
    }

    public String getQuality() {
        return quality;
    }
}
