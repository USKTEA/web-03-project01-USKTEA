package models;

import repository.OrderRepository;
import repository.UserRepository;
import service.OrderService;
import service.UserService;
import java.util.Optional;
import java.io.IOException;

public class Payment {
    public Optional<Order> purchase(Product product, User user) throws IOException {
        if (Integer.parseInt(product.price()) > user.balance()) {
            return Optional.empty();
        }

        Optional<Order> order = Optional.of(new Order(product, user.id()));

        receivePayment(user, order.get());
        recordOrder(order.get());

        return order;
    }

    private void recordOrder(Order order) throws IOException {
        OrderService orderService = new OrderService(new OrderRepository());
        orderService.record(order);
    }

    public void receivePayment(User user, Order order) throws IOException {
        UserService userService = new UserService(new UserRepository());
        userService.purchase(user, order);
    }
}
