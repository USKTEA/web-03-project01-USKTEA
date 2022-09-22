package view;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderHistoryTest {

    @Test
    void string() {
        OrderHistory orderHistory = new OrderHistory();

        assertEquals("view.OrderHistory", orderHistory.toString());
    }

    @Test
    void equality() {
        OrderHistory orderHistory1 = new OrderHistory();
        OrderHistory orderHistory2 = new OrderHistory();

        assertEquals(orderHistory1, orderHistory2);
    }
}
