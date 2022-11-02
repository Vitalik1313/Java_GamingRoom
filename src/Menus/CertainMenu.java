package Menus;

import Building.Building;
import Interfaces.Command2;
import Invokers.Srt_SrchInv;
import Reciever.CallerSearch;
import Reciever.CallerSort;

import java.util.Scanner;

public class CertainMenu {
    private int numberRoom;
    private Command2 sortMenu = new CallerSort();
    private Command2 searchMenu = new CallerSearch();

    Srt_SrchInv inv = new Srt_SrchInv(sortMenu,searchMenu);
    public CertainMenu(int numberRoom, Building building){
        boolean loop = true;
        this.numberRoom = numberRoom;

        while(loop) {
            System.out.println("\t\tROOM MENU");
            System.out.println("1) Show room's inventory - 1");
            System.out.println("2) Search - 2");
            System.out.println("3) Sort - 3");
            System.out.println("4) Back - 4");

            Scanner scan = new Scanner(System.in);
            int choice = scan.nextInt();

            if (choice == 1) {
                building.showInventoryInRoom(numberRoom);
            } else if (choice == 2) {
                inv.callSearchMenu(building, numberRoom);
            } else if (choice == 3) {
                inv.callSortMenu(building, numberRoom);
            }
            else if(choice == 4){
                loop = false;
            }
        }
    }
}
