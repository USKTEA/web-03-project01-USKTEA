package view;

import models.Mall;
import models.Product;
import models.Receipt;
import models.User;
import models.ViewController;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MallPanel extends JPanel { // TODO session
    Mall mall;
    ViewController viewController;
    List<Product> products = new ArrayList<>();

    JPanel header;

    public MallPanel(ViewController viewController) {
        this.viewController = viewController;
        this.mall = new Mall();

        addProduct();
        initMallPanel();
    }

    private void addProduct() { // 임시데이터
        for (int i = 0; i < 12; i += 1) {
            products.add(new Product("상품", 100));
        }

        mall.set(products);
    }

    private void initMallPanel() {
        this.setLayout(new BorderLayout());

        addHeader();
        addProductPanel();
    }

    private void addHeader() {
        String[] userInformation = viewController.userInformation();

        header = new JPanel();
        header.setLayout(new GridLayout(0, 3));
        header.add(new JLabel("ID : " + userInformation[0]));
        header.add(new JLabel("보유 금액 : " + userInformation[1]));
        header.add(new JLabel("회원 등급 : " + userInformation[2]));

        this.add(header, BorderLayout.PAGE_START);
    }

    private void addProductPanel() {
        JPanel productPanel = new JPanel();
        productPanel.setLayout(new GridLayout(0, 2));

        this.add(productPanel, BorderLayout.CENTER);

        for (Product product : mall.get()) {
            JPanel panel = new JPanel();
            JLabel name = new JLabel(product.name());
            JLabel price = new JLabel("가격: " + product.price());
            JButton button = new JButton("구매");
            button.addActionListener(event -> {
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

            panel.add(name);
            panel.add(price);
            panel.add(button);

            productPanel.add(panel);
        }
    }

    private boolean isGuest() {
        Optional<User> user = viewController.checkLogin();

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
        Optional<Receipt> receipt = viewController.purchaseRequest(product);

        if (receipt.isEmpty()) {
            final JDialog frame = new JDialog(new Frame(), "Error", true);

            JPanel error = new JPanel();
            error.add(new JLabel("보유 금액이 부족합니다."));

            frame.getContentPane().add(error);
            frame.setLocationRelativeTo(null);
            frame.pack();
            frame.setVisible(true);

            return;
        }

        viewController.sendReceipt(receipt.get());
        updateHeader();
    }

    private void updateHeader() {
        String[] userInformation = viewController.userInformation();

        header.removeAll();
        header.add(new JLabel("ID : " + userInformation[0]));
        header.add(new JLabel("보유 금액 : " + userInformation[1]));
        header.add(new JLabel("회원 등급 : " + userInformation[2]));

        header.setVisible(false);
        header.setVisible(true);
    }
}
