package Menus;

import Building.Building;

import java.util.Objects;
import java.util.Scanner;

public class SearchMenu {
    public SearchMenu(Building building,int numberRoom) {
        boolean loop = true;
        while (loop) {
            System.out.println("\n\t\t Searching MENU");
            System.out.println("1) Search by group - 1");
            System.out.println("2) Search by size - 2");
            System.out.println("3) Search by name - 3");
            System.out.println("4) Back - 4");
            System.out.println("5) Exit - 5");

            Scanner scan = new Scanner(System.in);
            int choice = scan.nextInt();
            scan.nextLine();
            String searching;


            if (numberRoom == -1) {
                if (choice == 1) {
                    System.out.println("Enter a group:");
                    searching = scan.nextLine();
                    if (Objects.equals(searching, "Device") || Objects.equals(searching, "Sport") || Objects.equals(searching, "Toy")) {
                        building.searchByGroup(searching);
                    }
                } else if (choice == 2) {
                    System.out.println("Enter a size:");
                    searching = scan.nextLine();
                    if (Objects.equals(searching, "small") || Objects.equals(searching, "medium") || Objects.equals(searching, "large")) {
                        building.searchBySize(searching);
                    }
                } else if (choice == 3) {
                    System.out.println("Enter a name:");
                    searching = scan.nextLine();
                    building.searchByName(searching);
                }
            } else {
                if (choice == 1) {
                    System.out.println("Enter a group:");
                    searching = scan.nextLine();
                    if (Objects.equals(searching, "Device") || Objects.equals(searching, "Sport") || Objects.equals(searching, "Toy")) {
                        building.getRooms().get(numberRoom).searchByGroup(searching);
                    }
                } else if (choice == 2) {
                    System.out.println("Enter a size:");
                    searching = scan.nextLine();
                    if (Objects.equals(searching, "small") || Objects.equals(searching, "medium") || Objects.equals(searching, "large")) {
                        building.getRooms().get(numberRoom).searchBySize(searching);
                    }
                } else if (choice == 3) {
                    System.out.println("Enter a name:");
                    searching = scan.nextLine();
                    building.getRooms().get(numberRoom).searchByName(searching);
                }
            }
            if(choice == 5)
                System.exit(0);
            if(choice == 4)
                loop = false;
        }
    }
}
