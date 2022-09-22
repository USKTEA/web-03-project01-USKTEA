package controller;

import models.Order;

import java.util.ArrayList;
import java.util.List;

public class Provider implements Observable {
    private List<Observer> observerList = new ArrayList<>();

    @Override
    public void subscribe(Observer observer) {
        if (observerList.contains(observer)) {
            observerList.remove(observer);
            observerList.add(observer);
        }

        observerList.add(observer);
    }

    @Override
    public void notify(List<Order> orderList) {
        observerList.forEach(observer -> observer.updateDisplay(orderList));
    }
}
