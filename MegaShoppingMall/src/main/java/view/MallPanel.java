package view;

import controller.GameController;
import controller.MallController;
import controller.MallPanelController;
import models.Order;
import models.Product;
import models.User;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;

import java.awt.TextArea;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Optional;

public class MallPanel extends JPanel {
    private MallPanelController mallPanelController;
    private MallController mallcontroller;
    private GameController gameController;

    private JPanel header;
    private JPanel contentPanel;
    private JPanel gamePanel;
    private JTextField submitField;

    public MallPanel(MallPanelController mallPanelController, MallController mallcontroller) throws FileNotFoundException {
        this.mallPanelController = mallPanelController;
        this.mallcontroller = mallcontroller;

        initMallPanel();
    }

    private void initMallPanel() throws FileNotFoundException {
        this.setLayout(new BorderLayout());
        this.setOpaque(false);

        addHeader();
        addContentPanel();
        addProductPanel();
        addGamePanel();
    }

    private void addHeader() {
        String[] userInformation = mallPanelController.userInformation();

        header = new JPanel();
        header.setOpaque(false);
        header.setLayout(new GridLayout(0, 3));
        header.add(new JLabel("ID : " + userInformation[0]));
        header.add(new JLabel("보유 포인트 : " + userInformation[1]));
        header.add(new JLabel("회원 등급 : " + userInformation[2]));
        header.setBorder(new EmptyBorder(10, 10 ,10 ,10));

        this.add(header, BorderLayout.NORTH);
    }

    private void addContentPanel() {
        contentPanel = new JPanel(new GridLayout(0, 1));
        contentPanel.setOpaque(false);

        this.add(contentPanel, BorderLayout.CENTER);
    }

    private void addProductPanel() throws FileNotFoundException {
        JPanel productPanel = new JPanel();
        productPanel.setLayout(new GridLayout(0, 2));

        for (Product product : mallcontroller.products()) {
            JPanel panel = new JPanel();

            ImageIcon img = new ImageIcon(product.image());
            JButton image = new JButton(img);

            JPanel nameAndPrice = new JPanel(new GridLayout(0, 1));
            JLabel name = new JLabel(product.name());
            JLabel price = new JLabel("가격: " + product.price() + "p");

            nameAndPrice.add(name);
            nameAndPrice.add(price);

            JPanel buttonPanel = new JPanel(new GridLayout(0, 1));
            JButton toCart = new JButton("요청리스트에 추가");

            toCart.addActionListener(event -> {
                if (isGuest()) {
                    return;
                }

                try {
                    mallPanelController.toCart(product);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });

            addOrderButton(product, buttonPanel);

            panel.add(image);
            panel.add(nameAndPrice);
            panel.add(buttonPanel);

            buttonPanel.add(toCart);

            productPanel.add(panel);
        }

        addScrollPane(productPanel);
    }

    private void addScrollPane(JPanel productPanel) {
        JScrollPane scrollPane = new JScrollPane(productPanel);
        scrollPane.setPreferredSize(new Dimension(1000 , 600));
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        contentPanel.add(scrollPane);
        contentPanel.setVisible(false);
        contentPanel.setVisible(true);
    }

    private void addGamePanel() {
        gamePanel = new JPanel();
        gamePanel.setBorder(BorderFactory.createEmptyBorder(100, 0, 0, 0));
        gamePanel.setOpaque(false);

        JPanel gameText = new JPanel();
        gameText.setOpaque(false);
        gamePanel.add(gameText);

        gameController = new GameController(gameText);
        gameController.start();

        submitField = new JTextField(10);
        gamePanel.add(submitField);

        addSubmitButton();
        contentPanel.add(gamePanel);
    }

    private void addSubmitButton( ) {
        JButton submit = new JButton("입력");
        submit.addActionListener(event -> {

            int reward = gameController.check(submitField.getText());
            try {
                mallPanelController.send(reward);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            updateGamePanel();
            gameController.start();
            updateHeader();
        });

        gamePanel.add(submit);
    }

    private void updateGamePanel() {
        submitField.setText("");
        gamePanel.setVisible(false);
        gamePanel.setVisible(true);
    }

    private void addOrderButton(Product product, JPanel buttonPanel) {
        JButton order = new JButton("바로 요청");
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
        header.add(new JLabel("보유 포인트 : " + userInformation[1]));
        header.add(new JLabel("회원 등급 : " + userInformation[2]));

        header.setVisible(false);
        header.setVisible(true);
    }
}
