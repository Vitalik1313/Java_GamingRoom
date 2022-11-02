package Invokers;

import Building.Building;
import Interfaces.Command2;

public class Srt_SrchInv {
    Command2 sortMenu;
    Command2 searchMenu;

    public Srt_SrchInv(Command2 sortMenu, Command2 searchMenu) {
        this.sortMenu = sortMenu;
        this.searchMenu = searchMenu;
    }

    public void callSortMenu(Building building, int numberRoom){
        sortMenu.execute(building,numberRoom);
    }

    public void callSearchMenu(Building building, int numberRoom){
        searchMenu.execute(building,numberRoom);
    }
}
