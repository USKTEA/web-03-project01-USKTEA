package service;

import models.User;
import repository.UserRepository;

import java.util.Optional;

import java.io.IOException;

public class AuthService {
    public Optional<User> findBy(String[] idAndPassword) throws IOException {
        return new UserRepository().getAccount(idAndPassword);
    }
}
