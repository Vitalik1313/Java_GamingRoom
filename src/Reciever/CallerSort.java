package Reciever;

import Interfaces.Command;
import Menus.SortMenu;

public class CallerSort implements Command {
    @Override
    public void execute() {
        new SortMenu();
    }
}
