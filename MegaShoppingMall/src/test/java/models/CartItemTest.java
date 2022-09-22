package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CartItemTest {

    @Test
    void creation() {
        CartItem cartItem = new CartItem();

        assertNotNull(cartItem);
    }

    @Test
    void equality() {
        int id = 1;

        CartItem cartItem1 = new CartItem(id);
        CartItem cartItem2 = new CartItem(id);

        assertEquals(cartItem1, cartItem2);
    }
}
