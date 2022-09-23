package view;

import constants.Constants;
import controller.UserPanelController;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class UserPanel extends JPanel {
    private UserPanelController userPanelController;

    public UserPanel(UserPanelController userPanelController) {
        this.userPanelController = userPanelController;
        this.setLayout(new BorderLayout());
        this.setOpaque(false);

        initUserPanel();
    }

    private void initUserPanel() {

    }

    private void update() {
        this.setVisible(false);
        this.setVisible(true);
    }
}
