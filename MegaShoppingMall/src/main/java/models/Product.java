package models;

import java.util.Objects;

public class Product {
    private String name;
    private int price;

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
}
