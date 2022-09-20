package models;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

// TODO : 유저는 상품을 구매하고, 장바구니에 넣을 수 있음, 리뷰를 수정할 수 있음

public class User {
    private String id;
    private String password;
    private int balance;
    private String grade;
    private List<Receipt> receipts;

    public User(String[] information) throws IOException {
        this.id = information[0];
        this.password = information[1];
        this.balance = Integer.parseInt(information[2]);
        this.grade = information[3];

        setReceipts(new ReceiptRepository().getReceipts());
    }

    public User(int balance) {
        this.balance = balance;
    }

    public User() {}

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

    public void setReceipts(List<Receipt> receipts) {
        this.receipts = receipts;
    }

    public void storeReceipt(Receipt receipt) throws IOException {
        receipts.add(receipt);

        new ReceiptRepository().saveReceipt(receipt);
    }

    public List<Receipt> getReceipts() {
        return receipts;
    }

    public Optional<Receipt> sendRequest(Product product) {
        return new Payment().checkRequest(product, balance, id);
    }

    public void pay(Receipt receipt) throws IOException {
        balance -= receipt.amount();

        new AccountRepository().modifyMoney(id, balance);
    }

    public String[] information() {
        return new String[] {id, Integer.toString(balance), grade};
    }

    public int balance() {
        return balance;
    }

    public String id() {
        return id;
    }
}
