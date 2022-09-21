package controller;

import models.User;
import service.UserService;

public class LoginController { // TODO : MVC 중개자로 수정?
    private UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    public void setSession(User user) {
        userService.setSession(user);
    }
}
