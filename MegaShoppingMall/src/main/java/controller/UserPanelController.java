package controller;

import repository.UserRepository;

public class UserPanelController {
    private UserRepository userRepository;

    public UserPanelController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
