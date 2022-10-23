package Invokers;

import Interfaces.Command;

public class MainMenuInv {
    Command roomsMenu;
    Command buildingMenu;
    Command exit;

    public MainMenuInv(Command roomsMenu, Command buildingMenu, Command exit) {
        this.roomsMenu = roomsMenu;
        this.buildingMenu = buildingMenu;
        this.exit = exit;
    }

    public void callRoomMenu(){
        roomsMenu.execute();
    }

    public void callBuildingMenu(){
        buildingMenu.execute();
    }

    public void callExit(){
        exit.execute();
    }
}
