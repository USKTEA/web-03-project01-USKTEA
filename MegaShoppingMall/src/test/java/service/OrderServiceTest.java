package service;

import controller.Provider;
import models.Order;
import org.junit.jupiter.api.Test;
import repository.OrderRepository;
import service.OrderService;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {
    @Test
    void delivered() throws IOException {
        boolean delivered = false;

        Order order = new Order(1, "testId", "testProduct", "testPrice", delivered);

        OrderService orderService = new OrderService(new OrderRepository(new Provider()));
        orderService.record(order);
        orderService.setDelivered(order);

        assertEquals(true, order.delivered());
    }
}
