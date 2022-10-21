import java.nio.file.Path;

public abstract class Inventory {
    Description desc;

    public void setDesc(String size,String name,int price) {
        this.desc = new Description(size,name,price);
    }
    public Description getDesc(){
        return this.desc;
    }
}
