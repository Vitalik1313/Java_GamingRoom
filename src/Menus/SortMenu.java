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
            System.out.println("4) Back - 4");

            Scanner scan = new Scanner(System.in);
            int choice = scan.nextInt();

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
                }
            }
            if (choice == 5)
                System.exit(0);
            if (choice == 4)
                loop = false;
        }
    }
}
