package view;

import models.Mall;
import models.Product;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

public class MallPanel extends JPanel {
    Mall mall;
    List<Product> products = new ArrayList<>();

    public MallPanel() {
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
        this.setLayout(new GridLayout(0, 1));

        for (Product product : mall.get()) {
            JPanel panel = new JPanel();
            JLabel name = new JLabel(product.name());
            JLabel price = new JLabel("가격: " + product.price());
            JButton button = new JButton("구매");

            panel.add(name);
            panel.add(price);
            panel.add(button);

            this.add(panel);
        }
    }
}
