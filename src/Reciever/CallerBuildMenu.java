package Reciever;

import Building.Building;
import Interfaces.Command;
import Menus.BuildingMenu;

public class CallerBuildMenu implements Command {
    @Override
    public void execute(Building building) {
        new BuildingMenu(building);
    }
}
