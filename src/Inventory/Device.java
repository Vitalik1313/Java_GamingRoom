package Inventory;

import Inventory.Inventory;

import java.util.Scanner;

public class Device extends Inventory {
    private int rentCost;
    private int termMonth;

    public Device(String size,String name,int price,int rentCost,int termMonth,int id,int number){
        desc = new Description(size,name,price,id,number);
        this.rentCost = rentCost;
        this.termMonth = termMonth;
        setGroup("Device");
    }

    @Override
    public String toString() {
        return "Device - " + desc +
                " rentCost = " + rentCost +
                ", termMonth = " + termMonth;
    }

    public Device(){
        setGroup("Device");
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

        System.out.println("Enter rentCost:");
        rentCost = scanInt.nextInt();
        System.out.println("Enter term:");
        termMonth = scanInt.nextInt();
        desc = new Description(size,nameToy,price,id,1);
    }

    public int getRentCost() {
        return rentCost;
    }

    public int getTermMonth() {
        return termMonth;
    }
}
