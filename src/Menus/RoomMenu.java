package Menus;

import java.util.Scanner;

public class RoomMenu {
    public RoomMenu(){
        System.out.println("\n\tRoom Menu");
        System.out.println("1) Get in first room - 1");
        System.out.println("2) Get in second room - 2");
        System.out.println("3) Get in third room - 3");

        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();


    }
}
