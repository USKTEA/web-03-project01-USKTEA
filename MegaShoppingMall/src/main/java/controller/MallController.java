package controller;

import service.PaymentService;
import models.Product;
import models.Order;
import models.User;
import service.UserService;

import java.io.IOException;
import java.util.Optional;

public class MallController {
    private UserService userService;
    private Optional<User> session;
    private User user;

    public MallController(UserService userService) {
        this.userService = userService;
        this.session = userService.getSession();
    }

    public String[] userInformation() {
        if (session.isEmpty()) {
            return new String[] {"Guest", "-", "방문 고객"};
        }

        return session.get().information();
    }

    public Optional<Order> purchase(Product product) { // purchase // 서비스를 요청하자
        user = session.get();

        Optional<Order> bill = new PaymentService().purchase(user, product);

        if (bill.isEmpty()) {
            return Optional.empty();
        }

        return bill;
    }

    public void paymentRequest(Order order) throws IOException {
        userService.purchase(user, order);
    }

    public void storeReceipt(Order order) throws IOException {

    //    receiptService.storeReceipt(receipt);
    }

    public Optional<User> getSession() {
        return session;
    }
}
