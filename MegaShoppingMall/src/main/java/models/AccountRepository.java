package models;

import java.io.IOException;
import java.util.Optional;

public class AccountRepository {
    private FileManager fileManager;

    AccountRepository() throws IOException {
        fileManager = new FileManager("accounts.csv");
    }

    public Optional<User> getAccount(String[] data) throws IOException {
        return fileManager.findAccount(data);
    }

    public void modifyMoney(String id, int balance) throws IOException {
        fileManager.modifyMoney(id, balance);
    }
}
