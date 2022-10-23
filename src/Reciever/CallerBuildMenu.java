package Reciever;

import Interfaces.Command;
import Menus.BuildingMenu;

public class CallerBuildMenu implements Command {
    @Override
    public void execute() {
        new BuildingMenu();
    }
}
