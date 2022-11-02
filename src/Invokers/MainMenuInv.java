package Invokers;

import Building.Building;
import Interfaces.Command;

public class MainMenuInv {
    Command roomsMenu;
    Command buildingMenu;

    public MainMenuInv(Command roomsMenu, Command buildingMenu) {
        this.roomsMenu = roomsMenu;
        this.buildingMenu = buildingMenu;
    }

    public void callRoomMenu(Building building){
        roomsMenu.execute(building);
    }

    public void callBuildingMenu(Building building){
        buildingMenu.execute(building);
    }

}
