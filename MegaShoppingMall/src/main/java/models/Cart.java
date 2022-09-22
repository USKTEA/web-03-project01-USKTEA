package models;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    List<Product> list;

    public Cart() {
        this.list = new ArrayList<>();
    }

    public Cart(List<Product> productList) {
        this.list = productList;
    }

    public void add(Product product) {
        list.add(product);
    }

    public void delete(Product product) {
        list.remove(product);
    }

    public boolean has(Product product) {
        return list.contains(product);
    }

    public List<Product> list() {
        return list;
    }
}
