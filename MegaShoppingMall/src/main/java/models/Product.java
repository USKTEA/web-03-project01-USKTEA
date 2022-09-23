package models;

import java.util.Objects;

public class Product {
    private String name;
    private int price;
    private String imagePath;

    public Product(String name, String price, String imagePath) {
        this.name = name;
        this.price = Integer.parseInt(price);
        this.imagePath = imagePath;
    }

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public Product() {}

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public boolean equals(Object other) {
        Product otherProduct = (Product) other;
        
        return Objects.equals(name, otherProduct.name);
    }

    public String name() {
        return name;
    }

    public String price() {
        return Integer.toString(price);
    }

    public String image() {
        return imagePath;
    }
}
