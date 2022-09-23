package controller;

import models.Order;

import java.util.List;

public interface Observer {
    void updateDisplay(List<Order> orders);
}
