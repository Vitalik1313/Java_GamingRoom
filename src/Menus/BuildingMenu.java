package Menus;

import Building.Building;
import Interfaces.Command2;
import Invokers.Srt_SrchInv;
import Reciever.CallerSearch;
import Reciever.CallerSort;

import java.util.Scanner;

public class BuildingMenu {
    public BuildingMenu(Building building){
        Command2 search = new CallerSearch();
        Command2 sort = new CallerSort();
        Srt_SrchInv inv = new Srt_SrchInv(sort,search);
        boolean loop = true;

        while(loop){
            System.out.println("\n\tBuilding MENU");
            System.out.println("1) List all inventory - 1");
            System.out.println("2) Search - 2");
            System.out.println("3) Sort - 3");
            System.out.println("4) Back - 4");

            System.out.print("Enter choice:");
            Scanner scan = new Scanner(System.in);
            int choice = scan.nextInt();

             if(choice == 1){
                 building.showAllInventory();
             } else if (choice == 2) {
                 inv.callSearchMenu(building,-1);
             } else if (choice == 3) {
                 inv.callSortMenu(building,-1);
             } else if(choice == 4)  {
                 loop = false;
             }
        }
    }
}
