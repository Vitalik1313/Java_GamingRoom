package Building;

import java.util.Arrays;
import java.util.List;

public class Building {
    List<Gaming_Room> rooms = Arrays.asList(new Gaming_Room[3]);
    private final int maxBudget;
    private final int maxNumberToys;
    private int curBudget;

    Building(){
        maxBudget = 5000;
        maxNumberToys = 50;
        curBudget = maxBudget;
    }

    public void changeBudget(int price){
        curBudget=-price;
    }
}
