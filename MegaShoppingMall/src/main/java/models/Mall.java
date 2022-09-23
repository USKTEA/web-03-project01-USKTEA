package models;

import java.util.List;

public class Mall {
    private List<Product> products;

    public Mall(List<Product> products) {
        this.products = products;
    }

    public List<Product> products() {
        return products;
    }
}
