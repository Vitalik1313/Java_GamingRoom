package Menus;

import Building.Building;

import java.util.Objects;
import java.util.Scanner;

public class SortMenu {
    private boolean loop = true;

    public SortMenu(Building building, int numberRoom) {
        while (loop) {
            System.out.println("\n\t\t Sorting MENU");
            System.out.println("1) Sort by size - 1");
            System.out.println("2) Sort by price - 2");
            System.out.println("3) Sort by group - 3");
            System.out.println("4) Sort by number - 4");
            System.out.println("5) Back - 5");

            Scanner scan = new Scanner(System.in);
            int choice = scan.nextInt();
            processChoice(choice,building,numberRoom);
        }
    }

    public void processChoice(int choice, Building building,int numberRoom){
        if (numberRoom == -1) {
            if (choice == 1) {
                System.out.println("Sorted by size:");
                building.sortBySize();
            } else if (choice == 2) {
                System.out.println("Sorted by price");
                building.sortByPrice();
            } else if (choice == 3) {
                System.out.println("Sorted by group");
                building.sortByGroup();
            } else if (choice == 4) {
                System.out.println("Sorted by number of toys");
                building.sortByNumber();
            }
        } else {
            if (choice == 1) {
                System.out.println("Sorted by size:");
                building.getRooms().get(numberRoom).sortBySize();
            } else if (choice == 2) {
                System.out.println("Sorted by price:");
                building.getRooms().get(numberRoom).sortByPrice();
            } else if (choice == 3) {
                System.out.println("Sorted by group:");
                building.getRooms().get(numberRoom).sortByGroup();
            } else if (choice == 4) {
                System.out.println("Sorted by number of toys");
                building.getRooms().get(numberRoom).sortByNumber();
            }
        }
        if (choice >= 6 || choice <=0) {
            System.out.println("\n\t See you soon!");
            System.exit(0);
        }
        if (choice == 5)
            loop = false;
    }
}
