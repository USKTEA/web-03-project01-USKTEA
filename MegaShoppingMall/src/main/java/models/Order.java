package models;

import java.util.Objects;

public class Order { //TODO id로 구매기록 확인하는 기능 추가?
    private long id;
    private String productName;
    private String productPrice;
    private String userId;

    public Order(Product product) {
        this.id = System.currentTimeMillis();
        productName = product.name();
        productPrice = product.price();
    }

    public Order(Product product, String userId) {
        this.id = System.currentTimeMillis();
        this.userId = userId;
        productName = product.name();
        productPrice = product.price();
    }

    public Order(long id, Product product) {
        this.id = id;
        productName = product.name();
        productPrice = product.price();
    }

    public Order(long id, String productName, String productPrice, String userId) {
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

    public Order(int orderId, Product product, String userId) {
        this.id = orderId;
        this.productName = product.name();
        this.productPrice = product.price();
        this.userId = userId;
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

    private long id() {
        return id;
    }

    public int amount() {
        return Integer.parseInt(productPrice);
    }

    public String[] information() {
        return new String[] {Long.toString(id), userId, productName, productPrice};
    }
}
