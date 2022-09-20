package controller;

import models.User;
import models.UserRepository;

public class LoginController {
    UserRepository userRepository;

    public LoginController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void setSession(User user) {
        userRepository.setSession(user);
    }
}
