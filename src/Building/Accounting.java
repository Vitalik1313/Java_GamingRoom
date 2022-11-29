package Building;

public class Accounting {
    private final int maxBudget;
    private final int maxNumberToys;
    private int curBudget;
    private int curNumberToys;

    public Accounting(){
        maxBudget = 20000;
        maxNumberToys = 70;
        curBudget = maxBudget;
        curNumberToys = 0;
    }

    public int getCurBudget() {
        return curBudget;
    }

    public int getCurNumberToys() {
        return curNumberToys;
    }

    public int getMaxNumberToys() {
        return maxNumberToys;
    }

    public void reduceBudget(int price){
        curBudget = curBudget - price;
    }

    public void addNewToy(){
        curNumberToys++;
    }

    @Override
    public String toString() {
        return "\n\tACCOUNTING" +
                "\nmaxBudget = " + maxBudget +
                "\nmaxNumberToys = " + maxNumberToys +
                "\ncurBudget = " + curBudget +
                "\ncurNumberToys = " + curNumberToys;
    }

    public int getMaxBudget() {
        return maxBudget;
    }
}
