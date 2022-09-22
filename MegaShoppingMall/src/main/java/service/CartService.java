package service;

import models.Cart;
import models.User;

import repository.CartRepository;

import java.io.FileNotFoundException;

public class CartService {
    private CartRepository cartRepository;

    public CartService() {
        this.cartRepository = new CartRepository();
    }

    public Cart getCart(User user) throws FileNotFoundException {
        return cartRepository.getCart(user);
    }
}
