package models;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {

    @Test
    void creation() {
        List<CartItem> items = List.of(
                new CartItem(),
                new CartItem(),
                new CartItem()
        );

        Cart cart = new Cart(items);

        assertEquals(items, cart.items());
    }

    @Test
    void add() {
        Cart cart = new Cart();
        cart.add(new CartItem());

        assertEquals(true, cart.has(new CartItem()));
    }

    @Test
    void delete() {
        Cart cart = new Cart();
        cart.add(new CartItem());
        cart.delete(new CartItem());

        assertEquals(false, cart.has(new CartItem()));
    }
}
