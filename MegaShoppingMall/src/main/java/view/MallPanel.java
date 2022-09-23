package view;

import controller.MallController;
import controller.MallPanelController;
import models.Order;
import models.Product;
import models.User;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;

import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Optional;

public class MallPanel extends JPanel {
    private MallPanelController mallPanelController;
    private MallController mallcontroller;

    private JPanel header;

    public MallPanel(MallPanelController mallPanelController, MallController mallcontroller) throws FileNotFoundException {
        this.mallPanelController = mallPanelController;
        this.mallcontroller = mallcontroller;

        initMallPanel();
    }

    private void initMallPanel() throws FileNotFoundException {
        this.setLayout(new BorderLayout());

        addHeader();
        addCartItemPanel();
    }

    private void addHeader() {
        String[] userInformation = mallPanelController.userInformation();

        header = new JPanel();
        header.setLayout(new GridLayout(0, 3));
        header.add(new JLabel("ID : " + userInformation[0]));
        header.add(new JLabel("보유 금액 : " + userInformation[1]));
        header.add(new JLabel("회원 등급 : " + userInformation[2]));
        header.setBorder(new EmptyBorder(10, 10 ,10 ,10));

        this.add(header, BorderLayout.NORTH);
    }

    private void addCartItemPanel() throws FileNotFoundException {
        JPanel CartItemPanel = new JPanel();
        CartItemPanel.setLayout(new GridLayout(0, 2));

        this.add(CartItemPanel, BorderLayout.CENTER);

        for (Product product : mallcontroller.products()) {
            JPanel panel = new JPanel();

            ImageIcon img = new ImageIcon(product.image());
            JButton image = new JButton(img);

            JLabel price = new JLabel("가격: " + product.price() + " 원");

            JPanel buttonPanel = new JPanel(new GridLayout(0, 1));
            JButton toCart = new JButton("장바구니");

            toCart.addActionListener(event -> {
                try {
                    mallPanelController.toCart(product);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });

            addOrderButton(product, buttonPanel);

            panel.add(image);
            panel.add(price);
            panel.add(buttonPanel);

            buttonPanel.add(toCart);

            CartItemPanel.add(panel);
        }
    }

    private void addOrderButton(Product product, JPanel buttonPanel) {
        JButton order = new JButton("주문");
        order.addActionListener(event -> {
            if (isGuest()) {
                return;
            }

            try {
                purchase(product);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        buttonPanel.add(order);
    }

    private boolean isGuest() {
        Optional<User> user = mallPanelController.getSession();

        if (user.isEmpty()) {
            final JDialog frame = new JDialog(new Frame(), "Error", true);
            JPanel error = new JPanel();
            error.add(new JLabel("로그인이 필요한 서비스입니다."));

            frame.getContentPane().add(error);
            frame.setLocationRelativeTo(null);
            frame.pack();
            frame.setVisible(true);

            return true;
        }

        return false;
    }

    private void purchase(Product product) throws IOException {
        Optional<Order> order = mallPanelController.purchase(product);

        if (order.isEmpty()) {
            final JDialog frame = new JDialog(new Frame(), "Error", true);

            JPanel error = new JPanel();
            error.add(new JLabel("보유 금액이 부족합니다."));

            frame.getContentPane().add(error);
            frame.setLocationRelativeTo(null);
            frame.pack();
            frame.setVisible(true);

            return;
        }

        updateHeader();
    }

    private void updateHeader() {
        header.removeAll();

        String[] userInformation = mallPanelController.userInformation();

        header.add(new JLabel("ID : " + userInformation[0]));
        header.add(new JLabel("보유 금액 : " + userInformation[1]));
        header.add(new JLabel("회원 등급 : " + userInformation[2]));

        header.setVisible(false);
        header.setVisible(true);
    }
}
