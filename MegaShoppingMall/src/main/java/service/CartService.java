package service;

import models.Cart;
import models.CartItem;
import models.Product;
import models.User;

import repository.CartRepository;

import java.io.FileNotFoundException;
import java.io.IOException;

public class CartService {
    private CartRepository cartRepository;

    public CartService() {
        this.cartRepository = new CartRepository();
    }

    public Cart getCart(User user) throws FileNotFoundException {
        return cartRepository.getCart(user);
    }

    public void add(Product product, User user) throws IOException {
        cartRepository.add(product, user);
    }

    public void delete(CartItem cartItem, User user) throws IOException {
        cartRepository.delete(cartItem, user);
    }
}
