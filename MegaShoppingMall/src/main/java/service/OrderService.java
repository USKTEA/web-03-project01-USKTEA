package service;

import models.Order;
import repository.OrderRepository;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class OrderService {
    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void record(Order order) throws IOException {
        orderRepository.record(order);
    }

    public List<Order> getOrderList() throws FileNotFoundException {
        return orderRepository.getOrders();
    }

    public void setDelivered(Order order) throws IOException {
        orderRepository.setDelivered(order);
    }

    public void deleteOrder(Order order) throws IOException {
        orderRepository.deleteOrder(order);
    }
}
