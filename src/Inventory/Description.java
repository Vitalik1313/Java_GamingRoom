package Inventory;

public class Description {
    private String size;
    private String nameToy;
    private int price;
    private int id;
    private int number;

    public Description(String size, String nameToy, int price,int id,int number) {
        this.size = size;
        this.nameToy = nameToy;
        this.price = price;
        this.id = id;
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Description{" +
                "size='" + size + '\'' +
                ", nameToy='" + nameToy + '\'' +
                ", price=" + price +
                ", id=" + id +
                ", number=" + number +
                '}';
    }
}
