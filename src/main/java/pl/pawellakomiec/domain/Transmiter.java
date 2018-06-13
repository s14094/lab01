package pl.pawellakomiec.domain;

public class Transmiter {

    private int id;
    private String name;
    private int price;
    private int power;

    public Transmiter(int id, String name, int price, int power) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.power = power;
    }

    public Transmiter(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

}
