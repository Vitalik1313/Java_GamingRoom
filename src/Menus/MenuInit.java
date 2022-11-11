package Menus;

import Building.Building;
import Invokers.MainMenuInv;
import Reciever.CallerBuildMenu;
import Reciever.CallerRoomMenu;

import java.util.Scanner;

public class MenuInit {
    public MenuInit(Building building) {
        CallerBuildMenu buildMenu = new CallerBuildMenu();
        CallerRoomMenu roomMenu = new CallerRoomMenu();
        MainMenuInv invoker = new MainMenuInv(roomMenu,buildMenu);

        while(true) {
            System.out.println("\t\t\t\tMENU");
            System.out.println("1)To interact with whole building - 1");
            System.out.println("2)To interact with certain building - 2");
            System.out.println("3)To get information about budget - 3");
            System.out.println("4)Exit - 4");
            System.out.print("Enter choice:");

            Scanner scan = new Scanner(System.in);
            int choice = scan.nextInt();

            if (choice == 1) {
                invoker.callBuildingMenu(building);
            } else if (choice == 2) {
                invoker.callRoomMenu(building);
            }else if(choice == 3){
                building.budgetInfo();
            } else {
                System.out.println("\n\tSee you soon!");
                System.exit(0);
            }
        }
    }
}
