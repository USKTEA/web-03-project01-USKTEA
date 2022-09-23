package repository;

import infrastructure.FileManager;
import models.Session;
import models.User;

import java.util.Optional;

import java.io.IOException;

public class UserRepository {
    private FileManager fileManager;
    private Session session = new Session();

    public UserRepository() {
        fileManager = new FileManager("accounts.csv");
    }

    public Optional<User> getAccount(String[] data) throws IOException {
        return fileManager.findAccount(data);
    }

    public void modifyMoney(String id, int balance) throws IOException {
        fileManager.modifyMoney(id, balance);
    }

    public void setSession(User user) {
        session.set(user);
    }

    public Optional<User> getSession() {
        return session.getUser();
    }
}
