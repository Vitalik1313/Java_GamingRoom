package Reciever;

import Building.Building;
import Interfaces.Command;
import Menus.RoomMenu;

public class CallerRoomMenu implements Command {
    public void execute(Building building){
        new RoomMenu(building);
    }
}
