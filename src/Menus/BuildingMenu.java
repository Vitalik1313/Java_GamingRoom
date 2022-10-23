package Menus;

import Invokers.Srt_SrchInv;
import Reciever.CallerSearch;
import Reciever.CallerSort;

import java.util.Scanner;

public class BuildingMenu {
    public BuildingMenu(){
        CallerSearch search = new CallerSearch();
        CallerSort sort = new CallerSort();
        Srt_SrchInv inv = new Srt_SrchInv(sort,search);

        System.out.println("\n\tBuilding MENU");
        System.out.println("1) List all inventory - 1");
        System.out.println("2) Search - 2");
        System.out.println("3) Sort - 3");

        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();

        if(choice == 1){
            ;
        } else if (choice == 2) {
            inv.callSearchMenu();
        } else if (choice == 3) {
            inv.callSortMenu();
        }
    }
}
