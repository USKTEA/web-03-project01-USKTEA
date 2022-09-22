package view;

import controller.MallController;
import controller.LoginController;
import controller.OrderHistoryController;
import controller.Provider;
import repository.OrderRepository;
import repository.UserRepository;
import service.OrderService;
import service.UserService;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.io.FileNotFoundException;

public class MainPanel extends JPanel {
    private Provider provider = new Provider();
    private UserRepository userRepository = new UserRepository();
    private LoginController loginController;
    private UserService userService;

    private JPanel buttonPanel;
    private JPanel contentPanel;

    public MainPanel() throws FileNotFoundException {
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
        userService = new UserService(userRepository);
        loginController = new LoginController(userService);

        contentPanel.add(new LoginPanel(loginController, userService));
    }

    private void initButtonPanel() throws FileNotFoundException {
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
            contentPanel.add(new LoginPanel(loginController, userService));
            contentPanel.setVisible(false);
            contentPanel.setVisible(true);
        });
    }

    private void addShoppingButton() {
        JButton shop = new JButton("쇼핑몰");
        buttonPanel.add(shop);

        shop.addActionListener(event -> {
            contentPanel.removeAll();
            contentPanel.add(new MallPanel(new MallController(userService)));
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

    private void addOrderButton() throws FileNotFoundException {
        JButton order = new JButton("주문 확인");
        buttonPanel.add(order);

        OrderService orderService = new OrderService(new OrderRepository(provider));
        OrderHistoryController orderHistoryController = new OrderHistoryController(userService, orderService);

        order.addActionListener(event -> {
            contentPanel.removeAll();

            OrderHistory orderHistory = null;

            try {
                orderHistory = new OrderHistory(orderHistoryController);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }

            provider.subscribe(orderHistory);

            contentPanel.add(orderHistory);
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
