package Inventory;

public class Description {
    private String size;
    private String nameToy;
    private int price;

    public Description(String size, String nameToy, int price) {
        this.size = size;
        this.nameToy = nameToy;
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getNameToy() {
        return nameToy;
    }

    public void setNameToy(String nameToy) {
        this.nameToy = nameToy;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Description getDesc(){
        return this;
    }
}
