package models;

import view.MallPanel;

import javax.swing.JPanel;

public class ViewController {
    MallPanel mallPanel;

    public void toShop(JPanel contentPanel) {
        contentPanel.removeAll();

        contentPanel.add(new MallPanel());
        contentPanel.setVisible(false);
        contentPanel.setVisible(true);
    }
}
