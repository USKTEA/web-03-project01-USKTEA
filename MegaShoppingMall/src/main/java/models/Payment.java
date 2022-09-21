package models;

import java.util.Optional;

public class Payment {
    public Optional<Order> purchase(Product product, int balance, String userId) {
        if (Integer.parseInt(product.price()) > balance) {
            return Optional.empty();
        }

        return Optional.of(new Order(product, userId));
    }
}
