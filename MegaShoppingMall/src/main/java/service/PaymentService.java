package service;

import models.Order;
import models.Payment;
import models.Product;
import models.User;
import java.util.Optional;
import java.io.IOException;

public class PaymentService {
    public Optional<Order> purchase(User user, Product product) throws IOException {
       return new Payment().purchase(product, user);
    }
}
