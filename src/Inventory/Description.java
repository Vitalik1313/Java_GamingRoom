package Inventory;

public class Description {
    private String size;
    private final String nameToy;
    private final int price;
    private final int id;
    private  int number;

    public Description(String size, String nameToy, int price,int id,int number) {
        this.size = size;
        this.nameToy = nameToy;
        this.price = price;
        this.id = id;
        this.number = number;
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


    public int getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "|||Description: " +
                "size='" + size + '\'' +
                ", nameToy='" + nameToy + '\'' +
                ", price=" + price +
                ", id=" + id +
                ", number=" + number + "|||";
    }

    public void incNumber(){
        number++;
    }
}
