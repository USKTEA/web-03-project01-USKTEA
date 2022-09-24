package models;

import java.util.Objects;

public class Service {
    private String name;
    private int price;
    private String imagePath;

    public Service(String name, String price, String imagePath) {
        this.name = name;
        this.price = Integer.parseInt(price);
        this.imagePath = imagePath;
    }

    public Service(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public Service() {}

    public Service(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public boolean equals(Object other) {
        Service otherService = (Service) other;
        
        return Objects.equals(name, otherService.name);
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
