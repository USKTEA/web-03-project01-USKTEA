package view;

import constants.Constants;
import controller.MallController;
import controller.MallPanelController;
import service.AuthService;
import models.User;
import controller.LoginController;
import service.UserService;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridLayout;

import java.awt.TextArea;
import java.util.Optional;

import java.io.IOException;
import java.io.FileNotFoundException;

public class LoginPanel extends JPanel { //TODO session 살아있으면 렌더링 안되게
    private LoginController loginController;
    private UserService userService;

    private JPanel form;
    private JLabel error;
    private JPasswordField passwordField;
    private JTextField idField;
    private JButton loginButton;
    private JPanel buttonPanel;

    public LoginPanel(LoginController loginController, UserService userService, JButton loginButton, JPanel buttonPanel) {
        this.loginController = loginController;
        this.userService = userService;
        this.loginButton = loginButton;
        this.buttonPanel = buttonPanel;

        this.setLayout(new BorderLayout());
        this.setOpaque(false);

        initLoginPanel();
    }


    private void initLoginPanel() {
        addTitle();
        initForm();
        addIdForm();
        addPasswordForm();
        addSubmitButton(idField, passwordField);
    }

    private void addTitle() {
        ImageIcon imageIcon = new ImageIcon(Constants.TITLE);
        JPanel title = new JPanel();
        title.setOpaque(false);
        title.setBorder(BorderFactory.createEmptyBorder(150, 0, 0, 0));
        JLabel label = new JLabel(imageIcon);
        title.add(label);
        this.add(title, BorderLayout.NORTH);
    }

    private void initForm() {
        form = new JPanel();
        form.setLayout(new GridLayout(0, 1));
        form.setBorder(BorderFactory.createEmptyBorder(100, 100, 100 ,100));
        this.add(form, BorderLayout.CENTER);
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
                        error = new JLabel("아이디 혹은 비밀번호가 맞지 않습니다.");
                        form.add(error);
                    }

                    this.setVisible(false);
                    this.setVisible(true);

                    return;
                }

                ImageIcon imageIcon = new ImageIcon(Constants.LOGOUT);
                loginButton.setIcon(imageIcon);

                setUserSession(user.get());
                changeButton();
                showMallPanel();
                initPopUp();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        form.add(submit);
    }

    private void initPopUp() {
        final JDialog frame = new JDialog(new Frame(), "Error", true);

        JPanel information = new JPanel();
        TextArea textArea = new TextArea();
        textArea.append("화면 하단에 있는 미니게임(과제)을 작성하면 포인트를 획득할 수 있습니다" +
                "\n" + "획득한 포인트로 여러 가지 요청해봅시다.");
        information.add(textArea);

        frame.getContentPane().add(information);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }

    private void changeButton() {
        ImageIcon imageIcon = new ImageIcon(Constants.LOGOUT);
        loginButton = new JButton(imageIcon);
        buttonPanel.setVisible(false);
        buttonPanel.setVisible(true);
    }

    private void showMallPanel() throws FileNotFoundException {
        MallPanelController mallPanelController = new MallPanelController(userService);
        MallController mallController = new MallController();
        MallPanel mallPanel = new MallPanel(mallPanelController, mallController);

        this.removeAll();
        this.add(mallPanel);
        this.setVisible(false);
        this.setVisible(true);
    }

    private void setUserSession(User user) {
        loginController.setSession(user);
    }
}
