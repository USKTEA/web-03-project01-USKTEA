package repository;

import infrastructure.FileManager;
import models.Cart;
import models.CartItem;
import models.Service;
import models.User;

import java.io.FileNotFoundException;
import java.io.IOException;

public class CartRepository {
    FileManager fileManager;

    public CartRepository() {
        this.fileManager = new FileManager("cart.csv");
    }

    public Cart getCart(User user) throws FileNotFoundException {
        return fileManager.getCart(user);
    }

    public void add(Service service, User user) throws IOException {
        fileManager.addItemToCart(service, user);
    }

    public void delete(CartItem cartItem) throws IOException {
        fileManager.deleteItemFromCart(cartItem);
    }
}
