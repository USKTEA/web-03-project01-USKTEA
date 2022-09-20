package models;

import java.util.Optional;

public class Payment { //TODO order객체도 만들어서 보내야함 어디에? oderRepo
    public Payment() {}

    public Optional<Receipt> checkRequest(Product product, int money, String userId) {
        if (Integer.parseInt(product.price()) > money) {
            return Optional.empty();
        }

        return Optional.of(new Receipt(product, userId));
    }

}
