package Inventory;

import Inventory.Inventory;

import java.util.Scanner;

public class Toy extends Inventory {
    private String brand;

    public Toy(String size,String name,int price,int id,String brand,int number){
        desc = new Description(size,name,price,id,number);
        this.brand = brand;
        setGroup("Toy");
    }

    @Override
    public String toString() {
        return "Toy - " + desc +
                " brand = '" + brand + '\'' +
                "  ";
    }
    public Toy(){
        setGroup("Toy");
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

        System.out.println("Enter brand:");
        brand = scanString.nextLine();

        desc = new Description(size,nameToy,price,id,1);
    }

    public String getBrand() {
        return brand;
    }
}
