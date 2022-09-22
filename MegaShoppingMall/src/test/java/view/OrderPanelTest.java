package view;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderPanelTest {

    @Test
    void string() {
        OrderPanel orderPanel = new OrderPanel();

        assertEquals("view.OrderPanel", orderPanel.toString());
    }

    @Test
    void equality() {
        OrderPanel orderPanel1 = new OrderPanel();
        OrderPanel orderPanel2 = new OrderPanel();

        assertEquals(orderPanel1, orderPanel2);
    }
}
