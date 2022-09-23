package repository;

import controller.Provider;
import infrastructure.FileManager;
import models.CartItem;
import models.Order;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class OrderRepository {
    private Provider provider;
    private FileManager fileManager;
    private List<Order> orders;

    public OrderRepository() throws FileNotFoundException {
        fileManager = new FileManager("orders.csv");
        this.provider = new Provider();

        getOrders();
    }

    public OrderRepository(Provider provider) throws FileNotFoundException {
        fileManager = new FileManager("orders.csv");
        this.provider = provider;

        getOrders();
    }

    public void record(Order order) throws IOException {
        orders.add(order);

        fileManager.recordOrder(order);
        provider.notify(orders);
    }

    public List<Order> getOrders() throws FileNotFoundException {
        orders = fileManager.getOrders();
        provider.notify(orders);

        return orders;
    }

    public void setDelivered(Order delivered) throws IOException {
        for (Order order : orders) {
            if (order.id() == delivered.id()) {
                order.setDelivered();
            }
        }

        fileManager.setDelivered(delivered);
        provider.notify(orders);
    }

    public void deleteOrder(Order order) throws IOException {
        orders.remove(order);

        fileManager.deleteOrder(order);
        provider.notify(orders);
    }

    public void add(CartItem cartItem) throws IOException {
        fileManager.cartItemToOrder(cartItem);
    }
}
