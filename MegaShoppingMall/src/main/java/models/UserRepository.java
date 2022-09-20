package models;

import java.io.IOException;
import java.util.Optional;

public class UserRepository {
    private FileManager fileManager;
    private Session session = new Session();

    public UserRepository() throws IOException {
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
