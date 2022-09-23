package repository;

import controller.Provider;
import infrastructure.Infrastructure;
import models.CartItem;
import models.Order;
import models.User;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class OrderRepository {
    private Provider provider;
    private Infrastructure infrastructure;
    private List<Order> orders;

    public OrderRepository() throws FileNotFoundException {
        infrastructure = new Infrastructure("orders.csv");
        this.provider = new Provider();

        getOrders();
    }

    public OrderRepository(Provider provider) throws FileNotFoundException {
        infrastructure = new Infrastructure("orders.csv");
        this.provider = provider;

        getOrders();
    }

    public void record(Order order) throws IOException {
        orders.add(order);

        infrastructure.recordOrder(order);
        provider.notify(orders);
    }

    public List<Order> getOrders() throws FileNotFoundException {
        orders = infrastructure.getOrders();
        provider.notify(orders);

        return orders;
    }

    public void setDelivered(Order delivered) throws IOException {
        for (Order order : orders) {
            if (order.id() == delivered.id()) {
                order.setDelivered();
            }
        }

        infrastructure.setDelivered(delivered);
        provider.notify(orders);
    }

    public void deleteOrder(Order order) throws IOException {
        orders.remove(order);

        infrastructure.deleteOrder(order);
        provider.notify(orders);
    }

    public void add(CartItem cartItem) throws IOException {
        infrastructure.cartItemToOrder(cartItem);
    }
}
