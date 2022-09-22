package controller;

import models.Cart;
import models.User;
import service.CartService;

import java.io.FileNotFoundException;

public class CartController {
    CartService cartService;
    User user;

    public CartController(User user) {
        this.cartService = new CartService();
        this.user = user;
    }

    public Cart getCart() throws FileNotFoundException {
        return cartService.getCart(user);
    }
}
