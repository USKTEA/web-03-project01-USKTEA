package controller;

import models.Cart;
import models.CartItem;
import models.Order;
import models.Product;
import models.User;
import service.CartService;
import service.PaymentService;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Optional;

public class CartController {
    private CartService cartService;
    private User user;

    public CartController(User user) {
        this.cartService = new CartService();
        this.user = user;
    }

    public Cart getCart() throws FileNotFoundException {
        return cartService.getCart(user);
    }

    public void add(Product product) throws IOException {
        cartService.add(product, user);
    }

    public void delete(CartItem cartItem) throws IOException {
        cartService.delete(cartItem, user);
    }

    public Optional<Order> order(CartItem cartItem) throws IOException {
        Optional<Order> order = new PaymentService().purchase(user, cartItem);

        return order;
    }

    public Optional<Order> orderAll(Cart cart) throws IOException {
        Optional<Order> order = new PaymentService().purchase(user, cart);

        return order;
    }
}
