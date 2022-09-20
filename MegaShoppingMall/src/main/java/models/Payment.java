package models;

import java.util.Optional;

public class Payment { //TODO order객체도 만들어서 보내야함 어디에? orderRepo
    public Optional<Receipt> checkRequest(Product product, int balance, String userId) {
        if (Integer.parseInt(product.price()) > balance) {
            return Optional.empty();
        }

        return Optional.of(new Receipt(product, userId));
    }
}
