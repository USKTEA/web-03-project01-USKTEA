package repository;

import infrastructure.Infrastructure;
import models.Session;
import models.User;

import java.util.Optional;

import java.io.IOException;

public class UserRepository {
    private Infrastructure infrastructure;
    private Session session = new Session();

    public UserRepository() {
        infrastructure = new Infrastructure("accounts.csv");
    }

    public Optional<User> getAccount(String[] data) throws IOException {
        return infrastructure.findAccount(data);
    }

    public void modifyMoney(String id, int balance) throws IOException {
        infrastructure.modifyMoney(id, balance);
    }

    public void setSession(User user) {
        session.set(user);
    }

    public Optional<User> getSession() {
        return session.getUser();
    }
}
