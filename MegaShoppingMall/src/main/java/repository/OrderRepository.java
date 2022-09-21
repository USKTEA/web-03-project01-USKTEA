package repository;

import models.FileManager;
import models.Order;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OrderRepository {
    private FileManager fileManager;
    private List<Order> orderList = new ArrayList<>();

    OrderRepository() {
        fileManager = new FileManager("orders.csv");
    }

    public void record(Order order) throws IOException {
        orderList.add(order);

        fileManager.storeReceipt(order);
    }

    public List<Order> getOrders() {
        orderList = fileManager.getReceipts();

        return orderList;
    }
}
