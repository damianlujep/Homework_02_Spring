package pl.coderslab.model;

public class Product {
    private String name;
    private double price;
    private long id;

    public Product() {
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Product(String name, double price, long id) {
        this.name = name;
        this.price = price;
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
