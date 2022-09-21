package controller;

import models.Order;

import java.util.List;

public interface Observable {
    void subscribe(Observer observer);
    void notify(List<Order> orderList);
}
