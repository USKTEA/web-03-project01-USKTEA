package view;

import controller.UserPanelController;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;

public class UserPanel extends JPanel {
    private UserPanelController userPanelController;

    public UserPanel(UserPanelController userPanelController) {
        this.userPanelController = userPanelController;

        initUserPanel();
    }

    private void initUserPanel() {
        this.setLayout(new BorderLayout());
        this.add(new JLabel("내 정보"), BorderLayout.PAGE_START);

        JPanel userInformationPanel = new JPanel(new GridLayout(0, 2));

    }
}
