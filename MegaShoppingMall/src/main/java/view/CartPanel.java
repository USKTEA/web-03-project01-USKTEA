package view;

import controller.CartController;

import models.Cart;
import models.Product;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import java.util.List;

import java.io.FileNotFoundException;

public class CartPanel extends JPanel {
    private JPanel record;
    private JPanel productInformation;
    private JPanel buttonPanel;
    private JPanel detailPanel;

    public CartPanel(CartController cartController) throws FileNotFoundException {
        this.setLayout(new BorderLayout());
        this.setOpaque(false);

        updateDisplay(cartController.getCart());
    }

    private void addHeader() {
        JPanel header = new JPanel();

        JLabel label = new JLabel("장바구니");
        label.setBorder(new EmptyBorder(0, 30, 0, 30));
        label.setHorizontalAlignment(JLabel.CENTER);

        header.add(label);
        this.add(header, BorderLayout.NORTH);
    }

    public void updateDisplay(Cart cart) {
        this.removeAll();

        addHeader();

        JPanel recordPanel = new JPanel(new GridLayout(0, 1));
        recordPanel.setOpaque(false);

        for (Product product : cart.list()) {
            addProductPanel(product);
            addButtonPanel(recordPanel, product);
        }

        addScrollPane(recordPanel);
        addControlPanel();
        addCartDetail(cart);
        addOrderButton();

        update();
    }

    private void addProductPanel(Product product) {
        record = new JPanel();
        record.setBorder(new EmptyBorder(10, 20, 10, 20));
        record.setOpaque(false);

        productInformation = new JPanel(new GridLayout(0, 1));
        productInformation.add(new JLabel("상품명: " + product.name()));
        productInformation.add(new JLabel("상품 가격: " + product.price()));

        record.add(productInformation, BorderLayout.CENTER);
    }

    private void addButtonPanel(JPanel recordPanel, Product product) {
        buttonPanel = new JPanel(new GridLayout(0, 1));

        addReceivedButton(product);

        JButton orderOne = new JButton("바로 구매");
        orderOne.addActionListener(event -> {
            //  cartController.purchase(product);
        });

        buttonPanel.add(orderOne);
        record.add(buttonPanel);
        recordPanel.add(record);
    }

    private void addReceivedButton(Product product) {
        JButton received = new JButton("삭제");
        received.addActionListener(event -> {
            //    cartController.deleteProduct(product);
        });

        buttonPanel.add(received);
    }

    private void addScrollPane(JPanel recordPanel) {
        JScrollPane scrollPane = new JScrollPane(recordPanel);
        scrollPane.setPreferredSize(new Dimension(400 , 600));
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        this.add(scrollPane, BorderLayout.CENTER);
    }

    private void addControlPanel() {
        detailPanel = new JPanel(new GridLayout(0, 1));

        this.add(detailPanel, BorderLayout.PAGE_END);
    }

    private void addCartDetail(Cart cart) {
        List<Product> list = cart.list();

        int listSum = list.stream()
                .map(Product::price)
                .map(price -> Integer.parseInt(price))
                .reduce(0, (a, b) -> a + b);

        JPanel cartDetail = new JPanel();
        JLabel totalCount = new JLabel("총 수량: " + list.size() + "개");
        JLabel totalAmount = new JLabel(" 합계: " + listSum + "원");

        cartDetail.add(totalCount);
        cartDetail.add(totalAmount);

        detailPanel.add(cartDetail);
    }

    private void addOrderButton() {
        JButton orderAll = new JButton("주문 하기");

        detailPanel.add(orderAll);
    }

    private void update() {
        this.setVisible(false);
        this.setVisible(true);
    }
}
