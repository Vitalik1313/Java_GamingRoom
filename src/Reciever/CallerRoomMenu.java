package Reciever;

import Interfaces.*;
import Menus.RoomMenu;

public class CallerRoomMenu implements Command {
    public void execute(){
        new RoomMenu();
    }
}
