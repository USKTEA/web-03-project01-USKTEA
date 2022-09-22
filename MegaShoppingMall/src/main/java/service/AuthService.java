package service;

import models.User;
import repository.UserRepository;

import java.io.IOException;
import java.util.Optional;

public class AuthService { //TODO : 유효성 검증만 어딘가에서 받은 데이터로
    public Optional<User> findBy(String[] idAndPassword) throws IOException {
        return new UserRepository().getAccount(idAndPassword);
    }
}
