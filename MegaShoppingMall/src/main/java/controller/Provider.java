package controller;

import models.Order;

import java.util.ArrayList;
import java.util.List;

public class Provider implements Observable {
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void subscribe(Observer observer) {
        if (observers.contains(observer)) {
            observers.remove(observer);
            observers.add(observer);
        }

        observers.add(observer);
    }


    @Override
    public void notify(List<Order> orders) {
        observers.forEach(observer -> observer.updateDisplay(orders));
    }
}
