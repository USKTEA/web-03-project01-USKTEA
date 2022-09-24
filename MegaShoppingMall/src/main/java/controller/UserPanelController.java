package controller;

import models.Service;
import models.User;
import service.OrderService;
import service.UserService;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;

public class UserPanelController {
    private UserService userService;

    public UserPanelController(UserService userService) {
        this.userService = userService;
    }

    public Optional<User> getSession() {
        return userService.getSession();
    }

    public List<Service> myService(User user) throws FileNotFoundException {
        return new OrderService().myService(user);
    }

}
