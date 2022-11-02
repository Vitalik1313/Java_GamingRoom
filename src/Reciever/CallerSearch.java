package Reciever;

import Building.Building;
import Interfaces.Command;
import Interfaces.Command2;
import Menus.SearchMenu;

public class CallerSearch implements Command2 {
    @Override
    public void execute(Building building,int numberRoom) {
        new SearchMenu(building,numberRoom);
    }
}
