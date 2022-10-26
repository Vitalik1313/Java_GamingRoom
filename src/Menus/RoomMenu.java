package Menus;

import java.util.Scanner;

public class RoomMenu {
    public RoomMenu(){

        boolean loop = true;

        while(loop){
            System.out.println("\n\tRoom Menu");
            System.out.println("1) Get in first room - 1");
            System.out.println("2) Get in second room - 2");
            System.out.println("3) Get in third room - 3");
            System.out.println("4) Back - 4");
            System.out.print("Enter choice:");
            Scanner scan = new Scanner(System.in);
            int choice = scan.nextInt();

            if(choice == 1){
                System.out.println("Room 1 menu is under maintenance");
            } else if (choice == 2) {
                System.out.println("Room 2 menu is under maintenance");
            } else if (choice == 3) {
                System.out.println("Room 3 menu is under maintenance");
            } else if(choice == 4)  {
                loop = false;
            }


        }



    }
}
