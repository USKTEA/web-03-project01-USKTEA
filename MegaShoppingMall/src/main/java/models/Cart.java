package models;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> CartItems;

    public Cart() {
        this.CartItems = new ArrayList<>();
    }

    public Cart(List<CartItem> CartItems) {
        this.CartItems = CartItems;
    }

    public void add(CartItem CartItem) {
        CartItems.add(CartItem);
    }

    public void delete(CartItem CartItem) {
        CartItems.remove(CartItem);
    }

    public boolean has(CartItem CartItem) {
        return CartItems.contains(CartItem);
    }

    public List<CartItem> items() {
        return CartItems;
    }
}
