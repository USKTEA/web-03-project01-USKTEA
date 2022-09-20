package models;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Optional;

public class AccountRepository {
    FileManager fileManager;

    AccountRepository() throws FileNotFoundException {
        fileManager = new FileManager("accounts.csv");
    }

    public Optional<User> getAccount(String[] data) throws FileNotFoundException {
        return fileManager.findAccount(data);
    }

    public void modifyMoney(String id, int balance) throws IOException {
        fileManager.modifyMoney(id, balance);
    }
}
