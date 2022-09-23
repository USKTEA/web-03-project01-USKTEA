package view;

import constants.Constants;
import controller.MallController;
import controller.MallPanelController;
import controller.LoginController;
import controller.OrderPanelController;
import controller.Provider;
import controller.CartController;
import models.User;
import repository.OrderRepository;
import repository.UserRepository;
import service.OrderService;
import service.UserService;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;

import java.util.Optional;

import java.io.FileNotFoundException;

public class MainPanel extends JPanel {
    private Provider provider = new Provider();
    private UserRepository userRepository = new UserRepository();
    private LoginController loginController;
    private UserService userService;

    private JPanel buttonPanel;
    private JPanel contentPanel;

    public MainPanel() {
        this.setLayout(new BorderLayout());

        initContentPanel();
        initLoginPanel();
        initButtonPanel();
    }

    private void initContentPanel() {
        contentPanel = new JPanel();
        Color color = new Color(245, 223, 77, 30);
        contentPanel.setBackground(color);

        this.add(contentPanel, BorderLayout.CENTER);
    }

    private void initLoginPanel() {
        userService = new UserService(userRepository);
        loginController = new LoginController(userService);

        contentPanel.add(new LoginPanel(loginController, userService));
    }

    private void initButtonPanel() {
        buttonPanel = new JPanel();
        Color color = new Color(245, 223, 77, 170);
        buttonPanel.setBackground(color);

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
        ImageIcon img = new ImageIcon(Constants.LOGIN_IMG);
        JButton login = new JButton(img);
        login.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 60));
        login.setBorderPainted(false);
        buttonPanel.add(login);


        login.addActionListener(event -> {
            contentPanel.removeAll();
            contentPanel.add(new LoginPanel(loginController, userService));
            contentPanel.setVisible(false);
            contentPanel.setVisible(true);
        });
    }

    private void addShoppingButton() {
        ImageIcon img = new ImageIcon(Constants.SHOP_IMG);
        JButton shop = new JButton(img);
        shop.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 60));
        shop.setBorderPainted(false);
        buttonPanel.add(shop);

        shop.addActionListener(event -> {
            contentPanel.removeAll();

            MallPanelController mallPanelController = new MallPanelController(userService);
            MallController mallcontroller = new MallController();
            MallPanel mallPanel = null;

            try {
                mallPanel = new MallPanel(mallPanelController, mallcontroller);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }

            contentPanel.add(mallPanel);
            contentPanel.setVisible(false);
            contentPanel.setVisible(true);
        });
    }

    private void addCartButton() {
        ImageIcon img = new ImageIcon(Constants.CART_IMG);
        JButton cart = new JButton(img);
        cart.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 60));
        cart.setBorderPainted(false);
        buttonPanel.add(cart);

        cart.addActionListener(event -> {
            Optional<User> session = userService.getSession();

            if (session.isEmpty()) {
                final JDialog frame = new JDialog(new Frame(), "Error", true);

                JPanel error = new JPanel();
                error.add(new JLabel("로그인이 필요한 서비스입니다."));

                frame.getContentPane().add(error);
                frame.setLocationRelativeTo(null);
                frame.pack();
                frame.setVisible(true);

                return;
            }

            contentPanel.removeAll();

            User user = session.get();
            CartController cartController = new CartController(user);

            try {
                contentPanel.add(new CartPanel(cartController));
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }

            contentPanel.setVisible(false);
            contentPanel.setVisible(true);
        });
    }

    private void addOrderButton() throws RuntimeException {
        ImageIcon img = new ImageIcon(Constants.ORDER_IMG);
        JButton order = new JButton(img);
        order.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 60));
        order.setBorderPainted(false);
        buttonPanel.add(order);

        order.addActionListener(event -> {
            contentPanel.removeAll();

            OrderPanel orderPanel = null;

            try {
                User user = userRepository.getSession().get();
                OrderService orderService = new OrderService(new OrderRepository(provider));
                OrderPanelController orderPanelController = new OrderPanelController(orderService, user);
                orderPanel = new OrderPanel(orderPanelController);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }

            provider.subscribe(orderPanel);

            contentPanel.add(orderPanel);
            contentPanel.setVisible(false);
            contentPanel.setVisible(true);
        });
    }

    private void addInfoButton() {
        ImageIcon img = new ImageIcon(Constants.ACCOUNT_IMG);
        JButton account = new JButton(img);
        account.setBorderPainted(false);
        buttonPanel.add(account);

        account.addActionListener(event -> {
            contentPanel.removeAll();
          //  contentPanel.add(new UserPanel(viewController));
            contentPanel.setVisible(false);
            contentPanel.setVisible(true);
        });
    }
}
