package controller;

import models.Order;
import service.OrderService;
import service.UserService;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class OrderHistoryController {
    private UserService userService;
    private OrderService orderService;

    public OrderHistoryController(UserService userService, OrderService orderService) {
        this.userService = userService;
        this.orderService = orderService;
    }

    public List<Order> getOrderList() throws FileNotFoundException {
        return orderService.getOrderList();
    }

    public void setDelivered(Order order) throws IOException {
        orderService.setDelivered(order);
    }

    public void deleteOrder(Order order) throws IOException {
        orderService.deleteOrder(order);
    }
}
