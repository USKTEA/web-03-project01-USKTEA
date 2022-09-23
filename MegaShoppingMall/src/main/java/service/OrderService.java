package service;

import models.CartItem;
import models.Order;
import models.User;
import repository.OrderRepository;

import java.util.List;

import java.io.FileNotFoundException;
import java.io.IOException;

public class OrderService {
    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public OrderService() {}

    public void record(Order order) throws IOException {
        orderRepository.record(order);
    }

    public List<Order> getOrders() throws FileNotFoundException {
        return orderRepository.getOrders();
    }

    public void setDelivered(Order order) throws IOException {
        orderRepository.setDelivered(order);
    }

    public void deleteOrder(Order order) throws IOException {
        orderRepository.deleteOrder(order);
    }

    public void order(CartItem cartItem) throws IOException {
        System.out.println(1);
        new OrderRepository().add(cartItem);
    }
}
