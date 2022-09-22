package repository;

import controller.Provider;
import infrastructure.Infrastructure;
import models.Order;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class OrderRepository {
    private Provider provider;
    private Infrastructure infrastructure;
    private List<Order> orderList;

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
        orderList.add(order);

        infrastructure.recordOrder(order);
        provider.notify(orderList);
    }

    public List<Order> getOrders() throws FileNotFoundException {
        orderList = infrastructure.getOrders();
        provider.notify(orderList);

        return orderList;
    }

    public void setDelivered(Order delivered) throws IOException {
        for (Order order : orderList) {
            if (order.id() == delivered.id()) {
                order.setDelivered();
            }
        }

        infrastructure.setDelivered(delivered);
        provider.notify(orderList);
    }
}
