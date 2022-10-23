package Reciever;

import Interfaces.Command;
import Menus.SearchMenu;

public class CallerSearch implements Command {
    @Override
    public void execute() {
        new SearchMenu();
    }
}
