package models;

import java.util.Objects;

public class Order {
    private long id;
    private String productName;
    private String productPrice;
    private String userId;
    private boolean delivered = false;

    public Order(Service service) {
        this.id = System.currentTimeMillis();
        this.productName = service.name();
        this.productPrice = service.price();
    }

    public Order(Service service, String userId) {
        this.id = System.currentTimeMillis();
        this.userId = userId;
        this.productName = service.name();
        this.productPrice = service.price();
    }

    public Order(long id, Service service) {
        this.id = id;
        this.productName = service.name();
        this.productPrice = service.price();
    }

    public Order(long id, String userId, String productName, String productPrice) {
        this.id = id;
        this.userId = userId;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public Order(long id, String productName, String productPrice) {
        this.id = id;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public Order(long id, Service service, String userId) {
        this.id = id;
        this.productName = service.name();
        this.productPrice = service.price();
        this.userId = userId;
    }

    public Order(long id, String userId, String productName, String productPrice, boolean delivered) {
        this.id = id;
        this.userId = userId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.delivered = delivered;
    }

    @Override
    public String toString() {
        return "상품명: " + productName + ", 금액: " + productPrice + "원";
    }

    @Override
    public boolean equals(Object other) {
        Order otherOrder = (Order) other;

        return Objects.equals(id, otherOrder.id());
    }

    public long id() {
        return id;
    }

    public String productName() {
        return productName;
    }

    public String price() {
        return productPrice;
    }

    public int amount() {
        return Integer.parseInt(productPrice);
    }

    public String[] information() {
        return new String[] {Long.toString(id), userId, productName, productPrice, String.valueOf(delivered)};
    }

    public void setDelivered() {
        this.delivered = true;
    }

    public boolean delivered() {
        return delivered;
    }
}
