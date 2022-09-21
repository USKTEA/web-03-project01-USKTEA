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

    OrderHistory(OrderHistoryController orderHistoryController) throws FileNotFoundException {
        this.orderHistoryController = orderHistoryController;
        this.setLayout(new BorderLayout());
        this.setOpaque(false);

        initHeader();
        updateDisplay(orderHistoryController.getOrderList());
    }

    private void initHeader() {
        JLabel header = new JLabel("내 주문");
        header.setBorder(new EmptyBorder(10, 0, 10, 0));
        header.setHorizontalAlignment(JLabel.CENTER);

        this.add(header, BorderLayout.NORTH);
    }

    @Override
    public void updateDisplay(List<Order> orderList) {
        this.removeAll();

        JPanel recordPanel = new JPanel(new GridLayout(0, 1));
        recordPanel.setOpaque(false);

        for (Order order : orderList) {
            if (order.delivered() == true) {
                System.out.println(order.delivered());

                continue;
            }

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date timeInDate = new Date(order.id());
            String timeInFormat = simpleDateFormat.format(timeInDate);

            JPanel record = new JPanel();
            record.setBorder(new EmptyBorder(10, 20, 10, 20));
            record.setOpaque(false);

            JPanel orderInformation = new JPanel(new GridLayout(0, 1));
            orderInformation.add(new JLabel("주문 날짜: " + timeInFormat));

            JPanel productInformation = new JPanel();
            productInformation.add(new JLabel("상품명: " + order.productName()));
            productInformation.add(new JLabel("상품 가격: " + order.productPrice()));

            orderInformation.add(productInformation);
            record.add(orderInformation, BorderLayout.CENTER);

            JPanel buttonPanel = new JPanel(new GridLayout(0, 1));

            JButton received = new JButton("주문 수령");
            received.addActionListener(event -> {
                try {
                    orderHistoryController.setDelivered(order);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });

            JButton cancel = new JButton("주문 취소");
            buttonPanel.add(received);
            buttonPanel.add(cancel);

            record.add(buttonPanel);
            recordPanel.add(record);
        }

        JScrollPane scrollPane = new JScrollPane(recordPanel);
        scrollPane.setPreferredSize(new Dimension(400 , 600));
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        this.add(scrollPane, BorderLayout.CENTER);
        this.setVisible(false);
        this.setVisible(true);
    }
}
