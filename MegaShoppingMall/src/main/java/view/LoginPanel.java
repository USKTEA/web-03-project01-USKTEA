package view;

import controller.MallController;
import models.AuthService;
import models.User;
import controller.LoginController;
import models.UserRepository;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.IOException;
import java.util.Optional;
import java.io.FileNotFoundException;

public class LoginPanel extends JPanel { //TODO session 살아있으면 렌더링 안되게
    private LoginController loginController;
    
    private JPanel form;
    private JLabel error;
    private JPasswordField passwordField;
    private JTextField idField;
    private UserRepository userRepository;

    public LoginPanel(LoginController loginController, UserRepository userRepository) {
        this.loginController = loginController;
        this.userRepository = userRepository;
        this.setLayout(new BorderLayout());

        initLoginPanel();
    }

    private void initLoginPanel() {
        initForm();
        addIdForm();
        addPasswordForm();
        addSubmitButton(idField, passwordField);
    }

    private void initForm() {
        form = new JPanel();
        form.setLayout(new GridLayout(0, 1));

        this.add(form);
    }

    private void addPasswordForm() {
        JLabel passwordLabel = new JLabel("비밀번호");
        passwordField = new JPasswordField(10);
        form.add(passwordLabel);
        form.add(passwordField);
    }

    private void addIdForm() {
        JLabel idLabel = new JLabel("아이디");
        idField = new JTextField(10);
        form.add(idLabel);
        form.add(idField);
    }

    private void addSubmitButton(JTextField idField, JPasswordField passwordField) {
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

                setUserSession(user.get());
                showMallPanel();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        form.add(submit);
    }

    private void showMallPanel() {
        MallController mallController = new MallController(userRepository);
        MallPanel mallPanel = new MallPanel(mallController);

        this.removeAll();
        this.add(mallPanel);
        this.setVisible(false);
        this.setVisible(true);
    }

    private void setUserSession(User user) {
        loginController.setSession(user);
    }
}
