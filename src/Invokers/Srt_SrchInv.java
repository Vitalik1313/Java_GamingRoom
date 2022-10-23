package Invokers;

import Interfaces.Command;

public class Srt_SrchInv {
    Command sortMenu;
    Command searchMenu;

    public Srt_SrchInv(Command sortMenu, Command searchMenu) {
        this.sortMenu = sortMenu;
        this.searchMenu = searchMenu;
    }

    public void callSortMenu(){
        sortMenu.execute();
    }

    public void callSearchMenu(){
        searchMenu.execute();
    }
}
