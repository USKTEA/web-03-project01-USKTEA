package models;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {

    @Test
    void creation() {
        List<Product> productList = List.of(
                new Product(),
                new Product(),
                new Product()
        );

        Cart cart = new Cart(productList);

        assertEquals(productList, cart.list);
    }

    @Test
    void add() {
        Cart cart = new Cart();
        cart.add(new Product());

        assertEquals(true, cart.has(new Product()));
    }

    @Test
    void delete() {
        Cart cart = new Cart();
        cart.add(new Product());
        cart.delete(new Product());

        assertEquals(false, cart.has(new Product()));
    }
}
