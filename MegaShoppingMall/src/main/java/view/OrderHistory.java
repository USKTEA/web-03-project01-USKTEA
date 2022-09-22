package view;

import controller.Observer;
import controller.OrderHistoryController;
import models.Order;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class OrderHistory extends JPanel implements Observer {
    private OrderHistoryController orderHistoryController;

    private JPanel record;
    private JPanel orderInformation;
    private JPanel productInformation;
    private JPanel buttonPanel;

    OrderHistory(OrderHistoryController orderHistoryController) throws FileNotFoundException {
        this.orderHistoryController = orderHistoryController;
        this.setLayout(new BorderLayout());
        this.setOpaque(false);

        updateDisplay(orderHistoryController.getOrderList());
    }

    OrderHistory() {}

    private void addHeader() {
        JPanel header = new JPanel();
        JLabel label = new JLabel("내 주문");
        header.add(label);
        label.setBorder(new EmptyBorder(0, 30, 0, 30));
        label.setHorizontalAlignment(JLabel.CENTER);

        this.add(header, BorderLayout.NORTH);
    }

    @Override
    public void updateDisplay(List<Order> orderList) {
        this.removeAll();

        addHeader();
        JPanel recordPanel = new JPanel(new GridLayout(0, 1));
        recordPanel.setOpaque(false);

        for (Order order : orderList) {
            if (order.delivered() == true) {

                continue;
            }

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date timeInDate = new Date(order.id());
            String timeInFormat = simpleDateFormat.format(timeInDate);

            addOrderPanel(order, timeInFormat);
            addButtonPanel(recordPanel, order);
        }

        addScrollPane(recordPanel);
        update();
    }

    private void addOrderPanel(Order order, String timeInFormat) {
        record = new JPanel();
        record.setBorder(new EmptyBorder(10, 20, 10, 20));
        record.setOpaque(false);

        orderInformation = new JPanel(new GridLayout(0, 1));
        orderInformation.add(new JLabel("주문 날짜: " + timeInFormat));

        productInformation = new JPanel();
        productInformation.add(new JLabel("상품명: " + order.productName()));
        productInformation.add(new JLabel("상품 가격: " + order.productPrice()));

        orderInformation.add(productInformation);
        record.add(orderInformation, BorderLayout.CENTER);
    }

    private void addButtonPanel(JPanel recordPanel, Order order) {
        buttonPanel = new JPanel(new GridLayout(0, 1));

        addReceivedButton(order);
        addCancelButton(order);

        record.add(buttonPanel);
        recordPanel.add(record);
    }

    private void addCancelButton(Order order) {
        JButton cancel = new JButton("주문 취소");
        cancel.addActionListener(event -> {
            try {
                orderHistoryController.deleteOrder(order);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        buttonPanel.add(cancel);
    }

    private void addReceivedButton(Order order) {
        JButton received = new JButton("주문 수령");
        received.addActionListener(event -> {
            try {
                orderHistoryController.setDelivered(order);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        buttonPanel.add(received);
    }

    private void addScrollPane(JPanel recordPanel) {
        JScrollPane scrollPane = new JScrollPane(recordPanel);
        scrollPane.setPreferredSize(new Dimension(400 , 600));
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        this.add(scrollPane, BorderLayout.CENTER);
    }

    private void update() {
        this.setVisible(false);
        this.setVisible(true);
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public boolean equals(Object other) {
        OrderHistory otherOrderHistory = (OrderHistory) other;

        return this.getClass().getSimpleName().equals(otherOrderHistory.getClass().getSimpleName());
    }

    @Override
    public String toString() {
        return this.getClass().getName();
    }
}
