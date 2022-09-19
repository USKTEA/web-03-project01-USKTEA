package view;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;

public class ContentPanel extends JPanel {
    JPanel buttonPanel;

    ContentPanel() {
        initContentPanel();
    }

    private void initContentPanel() {
        this.setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel(new CardLayout());
        this.add(mainPanel, BorderLayout.CENTER);
        mainPanel.setBackground(Color.GRAY);

        addButtonPanel();
    }

    private void addButtonPanel() {
        buttonPanel = new JPanel();
        JButton login = new JButton("로그인");
        JButton shop = new JButton("쇼핑몰");
        JButton review = new JButton("장바구니");
        JButton user = new JButton("내 정보");

        buttonPanel.add(login);
        buttonPanel.add(shop);
        buttonPanel.add(review);
        buttonPanel.add(user);

        this.add(buttonPanel, BorderLayout.SOUTH);
        this.setVisible(false);
        this.setVisible(true);
    }
}
