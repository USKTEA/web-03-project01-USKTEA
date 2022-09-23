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
        ImageIcon imageIcon = new ImageIcon(Constants.LOGOUT);
        JButton logOut = new JButton(imageIcon);
        logOut.addActionListener(event -> {
            userPanelController.logOut();
            JLabel label = new JLabel("로그아웃 되었습니다!");
            this.add(label, BorderLayout.SOUTH);

            update();
        });

        logOut.setBorder(BorderFactory.createEmptyBorder(300, 0, 0, 0));
        logOut.setOpaque(false);

        this.add(logOut, BorderLayout.CENTER);
    }

    private void update() {
        this.setVisible(false);
        this.setVisible(true);
    }
}
