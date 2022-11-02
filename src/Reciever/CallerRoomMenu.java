package Reciever;

import Building.Building;
import Interfaces.*;
import Menus.RoomMenu;

public class CallerRoomMenu implements Command {
    public void execute(Building building){
        new RoomMenu(building);
    }
}
