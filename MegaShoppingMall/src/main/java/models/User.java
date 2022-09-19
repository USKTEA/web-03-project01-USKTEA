package models;

import java.util.Objects;
import java.util.Optional;

// TODO 유저는 상품을 구매하고, 장바구니에 넣을 수 있음, 리뷰를 수정할 수 있음

public class User {
    private String id;
    private String password;
    private int balance;
    private String grade;

    public User(String[] information) {
        this.id = information[0];
        this.password = information[1];
        this.balance = Integer.parseInt(information[2]);
        this.grade = information[3];
    }

    public User() {}

    public User(int balance) {
        this.balance = balance;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public boolean equals(Object other) {
        User otherUser = (User) other;

        return Objects.equals(id, otherUser.id);
    }

    @Override
    public String toString() {
        return "아이디: " + id + ", " + "비밀번호: " + password + ", " + "잔액: " + balance + ", " + "등급: " + grade;
    }

    public Optional<Receipt> sendRequest(Product product) {
        return new Payment().checkRequest(product, balance);
    }

    public void pay(Receipt receipt) {
        balance -= receipt.amount();
    }

    public int balance() {
        return balance;
    }

}
