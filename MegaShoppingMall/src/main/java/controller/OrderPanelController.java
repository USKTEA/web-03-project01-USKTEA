package controller;

import models.CartItem;
import models.Order;
import models.User;
import service.OrderService;
import service.UserService;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class OrderPanelController {
    private OrderService orderService;
    private User user;

    public OrderPanelController(OrderService orderService, User user) {
        this.orderService = orderService;
        this.user = user;
    }

    public OrderPanelController(OrderService orderService) {
        this.orderService = orderService;
    }

    public OrderPanelController() {
    }

    public List<Order> getOrderList() throws FileNotFoundException {
        return orderService.getOrders();
    }

    public void setDelivered(Order order) throws IOException {
        orderService.setDelivered(order);
    }

    public void deleteOrder(Order order) throws IOException {
        orderService.deleteOrder(order);

        new UserService().refund(user, order);
    }

    public void order(CartItem cartItem) throws IOException {
        new OrderService().order(cartItem);
    }
}
