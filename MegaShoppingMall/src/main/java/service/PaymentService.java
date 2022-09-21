package service;

import models.Order;
import models.Payment;
import models.Product;
import models.User;

import java.util.Optional;

public class PaymentService {
    Payment payment = new Payment();

    public Optional<Order> purchase(User user, Product product) {
        return payment.purchase(product, user.balance(), user.id());
    }
}
