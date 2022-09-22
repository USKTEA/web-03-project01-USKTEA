package repository;

import infrastructure.Infrastructure;
import models.Cart;
import models.User;

import java.io.FileNotFoundException;

public class CartRepository {
    Infrastructure infrastructure;

    public CartRepository() {
        this.infrastructure = new Infrastructure("cart.csv");
    }

    public Cart getCart(User user) throws FileNotFoundException {
        return infrastructure.getCart(user);
    }
}
