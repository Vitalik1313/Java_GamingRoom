package Reciever;

import Building.Building;
import Interfaces.Command2;
import Menus.SortMenu;

public class CallerSort implements Command2 {
    @Override
    public void execute(Building building,int numberRoom) {
        new SortMenu(building,numberRoom);
    }
}
