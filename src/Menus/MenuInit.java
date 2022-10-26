package Menus;

import Invokers.MainMenuInv;
import Reciever.CallerBuildMenu;
import Reciever.CallerRoomMenu;
import Reciever.ExitCaller;

import java.util.Scanner;

public class MenuInit {
    public MenuInit(){
        CallerBuildMenu buildMenu = new CallerBuildMenu();
        CallerRoomMenu roomMenu = new CallerRoomMenu();
        ExitCaller exit = new ExitCaller();
        MainMenuInv invoker = new MainMenuInv(roomMenu,buildMenu,exit);


        while(true) {
            System.out.println("\t\tMENU");
            System.out.println("1)To interact with whole building - 1");
            System.out.println("2)To interact with certain building - 2");
            System.out.println("3)Exit - 3");
            System.out.print("Enter choice:");

            Scanner scan = new Scanner(System.in);
            int choice = scan.nextInt();

            if (choice == 1) {
                invoker.callBuildingMenu();
            } else if (choice == 2) {
                invoker.callRoomMenu();
            } else {
                invoker.callExit();
            }
        }
    }
}
