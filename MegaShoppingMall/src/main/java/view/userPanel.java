package view;

import models.ViewController;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;

public class userPanel extends JPanel {
    private ViewController viewController;

    public userPanel(ViewController viewController) {
        this.viewController = viewController;

        initUserPanel();
    }

    private void initUserPanel() {
        this.setLayout(new BorderLayout());
        this.add(new JLabel("내 정보"), BorderLayout.PAGE_START);

        JPanel userInformationPanel = new JPanel(new GridLayout(0, 2));

    }
}
