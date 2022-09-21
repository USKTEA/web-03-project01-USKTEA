package service;

import models.Order;
import repository.OrderRepository;

import java.io.IOException;

public class OrderService {
    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void record(Order order) throws IOException {
        orderRepository.record(order);
    }
}
