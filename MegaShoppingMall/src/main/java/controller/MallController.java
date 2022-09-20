package controller;

import models.Product;
import models.Receipt;
import models.User;
import models.UserRepository;

import java.io.IOException;
import java.util.Optional;

public class MallController {
    UserRepository userRepository;
    Optional<User> session;
    User user;

    public MallController(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.session = userRepository.getSession();
    }

    public String[] userInformation() {
        if (session.isEmpty()) {
            return new String[] {"Guest", "-", "방문 고객"};
        }

        return session.get().information();
    }

    public Optional<Receipt> purchase(Product product) { // purchase // 서비스를 요청하자
        user = session.get();

        Optional<Receipt> receipt = user.sendRequest(product);

        if (receipt.isEmpty()) {
            return Optional.empty();
        }

        return receipt;
    }

    public Optional<User> getSession() {
        return userRepository.getSession();
    }

    public void paymentRequest(Receipt receipt) throws IOException {
        user = session.get();
        user.pay(receipt);
    }

    public void storeReceipt(Receipt receipt) throws IOException {
        user = session.get();

    //    receiptService.storeReceipt(receipt);
    }
}
