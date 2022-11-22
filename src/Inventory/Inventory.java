package Inventory;

public abstract class Inventory {
    Description desc;
    private String group;

    public Description getDesc(){
        return this.desc;
    }
    public String getSize(){return desc.getSize();}
    public String getName() {return desc.getNameToy();}
    public String getGroup(){
        return group;
    }
    public int getPrice(){return desc.getPrice();}
    public int getNumber(){return desc.getNumber();}
    public void setGroup(String group) {
        this.group = group;
    }
    public void incNumber(){desc.incNumber();}

}
