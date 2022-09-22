package repository;

import infrastructure.Infrastructure;
import models.Cart;
import models.CartItem;
import models.Product;
import models.User;

import java.io.FileNotFoundException;
import java.io.IOException;

public class CartRepository {
    Infrastructure infrastructure;

    public CartRepository() {
        this.infrastructure = new Infrastructure("cart.csv");
    }

    public Cart getCart(User user) throws FileNotFoundException {
        return infrastructure.getCart(user);
    }

    public void add(Product product, User user) throws IOException {
        infrastructure.addItemToCart(product, user);
    }

    public void delete(CartItem cartItem, User user) throws IOException {
        infrastructure.deleteItemFromCart(cartItem, user);
    }
}
