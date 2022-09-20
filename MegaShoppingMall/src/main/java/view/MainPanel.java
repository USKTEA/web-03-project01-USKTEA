package view;

import controller.MallController;
import controller.LoginController;
import models.UserRepository;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.io.IOException;

public class MainPanel extends JPanel {
    private JPanel buttonPanel;
    private JPanel contentPanel;
    private UserRepository userRepository = new UserRepository();
    private LoginController loginController;

    public MainPanel() throws IOException {
        this.setLayout(new BorderLayout());

        initContentPanel();
        initButtonPanel();
        initLoginPanel();
    }

    private void initContentPanel() {
        contentPanel = new JPanel();
        contentPanel.setBackground(Color.GRAY);

        this.add(contentPanel, BorderLayout.CENTER);
    }

    private void initLoginPanel() {
        loginController = new LoginController(userRepository);

        contentPanel.add(new LoginPanel(loginController, userRepository));
    }

    private void initButtonPanel() {
        buttonPanel = new JPanel();

        addLoginButton();
        addShoppingButton();
        addCartButton();
        addOrderButton();
        addInfoButton();

        this.add(buttonPanel, BorderLayout.SOUTH);
        this.setVisible(false);
        this.setVisible(true);
    }

    private void addLoginButton() {
        JButton login = new JButton("로그인");
        buttonPanel.add(login);

        login.addActionListener(event -> {
            contentPanel.removeAll();
            contentPanel.add(new LoginPanel(loginController, userRepository));
            contentPanel.setVisible(false);
            contentPanel.setVisible(true);
        });
    }

    private void addShoppingButton() {
        JButton shop = new JButton("쇼핑몰");
        buttonPanel.add(shop);

        shop.addActionListener(event -> {
            contentPanel.removeAll();
            contentPanel.add(new MallPanel(new MallController(userRepository)));
            contentPanel.setVisible(false);
            contentPanel.setVisible(true);
        });
    }

    private void addCartButton() {
        JButton cart = new JButton("장바구니");
        buttonPanel.add(cart);

        cart.addActionListener(event -> {
            contentPanel.removeAll();
            // contentPanel.add(new LoginPanel(viewController));
            contentPanel.setVisible(false);
            contentPanel.setVisible(true);
        });
    }

    private void addOrderButton() {
        JButton order = new JButton("주문확인");
        buttonPanel.add(order);

        order.addActionListener(event -> {
            contentPanel.removeAll();
           // contentPanel.add(new LoginPanel(viewController));
            contentPanel.setVisible(false);
            contentPanel.setVisible(true);
        });
    }

    private void addInfoButton() {
        JButton information = new JButton("내 정보");
        buttonPanel.add(information);

        information.addActionListener(event -> {
            contentPanel.removeAll();
          //  contentPanel.add(new UserPanel(viewController));
            contentPanel.setVisible(false);
            contentPanel.setVisible(true);
        });
    }
}
