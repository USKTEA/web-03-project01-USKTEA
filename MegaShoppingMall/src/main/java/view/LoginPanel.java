package view;

import models.AuthService;
import models.User;
import models.ViewController;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.FileNotFoundException;
import java.util.Optional;

public class LoginPanel extends JPanel {
    private ViewController viewController;
    private JLabel error;

    public LoginPanel(ViewController viewController) {
        this.viewController = viewController;
        this.setLayout(new BorderLayout());

        initLoginPanel();
    }

    private void initLoginPanel() {
        JPanel form = new JPanel();
        form.setLayout(new GridLayout(0, 1));

        JLabel id = new JLabel("아이디");
        JTextField idField = new JTextField(10);
        JLabel password = new JLabel("비밀번호");
        JPasswordField passwordField = new JPasswordField(10);
        JButton dd = new JButton();

        JButton submit = new JButton("로그인");
        submit.addActionListener(event -> {
            String inputId = idField.getText();
            String inputPassword = String.valueOf(passwordField.getPassword());

            try {
                Optional<User> user = new AuthService().findBy(new String[]{inputId, inputPassword});

                if (user.isEmpty()) {
                    if (error == null) {
                        error = new JLabel("계정을 확인해주세요!");
                        form.add(error);
                    }

                    this.setVisible(false);
                    this.setVisible(true);

                    return;
                }

                viewController.setSession(user.get());
                this.removeAll();
                this.add(new MallPanel(viewController));
                this.setVisible(false);
                this.setVisible(true);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        });

        form.add(id);
        form.add(idField);
        form.add(password);
        form.add(passwordField);
        form.add(submit);

        this.add(form);
        this.setVisible(false);
        this.setVisible(true);
    }
}
