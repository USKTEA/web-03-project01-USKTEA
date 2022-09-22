package models;

import models.Product;
import models.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    void string() {
        Order order = new Order(new Product("테스트상품", 10));

        assertEquals("상품명: 테스트상품, 금액: 10원", order.toString());
    }

    @Test
    void equality() {
        long id = 1;

        Order order1 = new Order(id, new Product());
        Order order2 = new Order(id, new Product());

        assertEquals(order1, order2);
    }

    @Test
    void information() {
        Order order = new Order(1, "testId", "testProduct", "100");

        assertArrayEquals(new String[] {"1", "testId", "testProduct", "100", "false"}, order.information());
    }
}
