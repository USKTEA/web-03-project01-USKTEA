package view;

import models.ViewController;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;

public class MainPanel extends JPanel {
    JPanel buttonPanel;
    JPanel contentPanel;
    ViewController viewController;

    public MainPanel() {
        this.viewController = new ViewController();
        this.setLayout(new BorderLayout());

        initContentPanel();
        addButtonPanel();
        initLoginPanel();
    }

    private void initContentPanel() {
        contentPanel = new JPanel();
        contentPanel.setBackground(Color.GRAY);

        this.add(contentPanel, BorderLayout.CENTER);
    }

    private void initLoginPanel() {
        contentPanel.add(new LoginPanel(viewController));
    }

    private void addButtonPanel() {
        buttonPanel = new JPanel();
        JButton login = new JButton("로그인");
        JButton shop = new JButton("쇼핑몰");
        JButton review = new JButton("장바구니");
        JButton user = new JButton("내 정보");

        buttonPanel.add(login);
        login.addActionListener(event -> {
            contentPanel.removeAll();
            contentPanel.add(new LoginPanel(viewController));
            contentPanel.setVisible(false);
            contentPanel.setVisible(true);
        });

        buttonPanel.add(shop);
        shop.addActionListener(event -> {
            contentPanel.removeAll();
            contentPanel.add(new MallPanel(viewController));
            contentPanel.setVisible(false);
            contentPanel.setVisible(true);
        });

        buttonPanel.add(review);
        buttonPanel.add(user);

        this.add(buttonPanel, BorderLayout.SOUTH);
        this.setVisible(false);
        this.setVisible(true);
    }
}
