package models;

import java.io.FileNotFoundException;
import java.util.Optional;

public class AccountRepository {
    FileManager fileManager;

    AccountRepository() {
        fileManager = new FileManager("accounts.csv");
    }

    public Optional<User> getAccount(String[] data) throws FileNotFoundException {
        return fileManager.findAccount(data);
    }
}
