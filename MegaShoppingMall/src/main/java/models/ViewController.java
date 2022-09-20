package models;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Optional;

public class ViewController {
    private Session session = new Session();

    public void setSession(User user) {
        session.set(user);
    }

    public String[] userInformation() {
        Optional<User> user = session.getUser();

        if (user.isEmpty()) {
            return new String[] {"Guest", "-", "방문 고객"};
        }

        return user.get().information();
    }

    public Optional<User> checkLogin() {
        Optional<User> user = session.getUser();

        if (user.isEmpty()) {
            return Optional.empty();
        }

        return user;
    }

    public Optional<Receipt> purchaseRequest(Product product) {
        Optional<User> user = session.getUser();

        Optional<Receipt> receipt = user.get().sendRequest(product);

        if (receipt.isEmpty()) {
            return Optional.empty();
        }

        return receipt;
    }

    public void paymentRequest(Receipt receipt) throws IOException {
        User user = session.getUser().get();
        user.pay(receipt);
    }

    public void storeReceipt(Receipt receipt) throws IOException {
        User user = session.getUser().get();
        user.storeReceipt(receipt);
    }
}
