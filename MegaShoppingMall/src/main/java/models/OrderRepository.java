package models;

import java.io.IOException;
import java.util.List;

public class OrderRepository {
    private FileManager fileManager;

    OrderRepository() throws IOException {
        fileManager = new FileManager("orders.csv");
    }

    public void saveReceipt(Order order) throws IOException {
        fileManager.storeReceipt(order);
    }

    public List<Order> getReceipts() {
        return fileManager.getReceipts();
    }
}
