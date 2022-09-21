package repository;

import models.FileManager;
import models.Order;

import java.io.IOException;
import java.util.List;

public class OrderRepository {
    private FileManager fileManager;

    OrderRepository() {
        fileManager = new FileManager("orders.csv");
    }

    public void record(Order order) throws IOException {
        fileManager.storeReceipt(order);
    }

    public List<Order> getOrders() {
        return fileManager.getReceipts();
    }
}
