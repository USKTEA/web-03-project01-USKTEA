package models;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Optional;
import java.util.Scanner;

public class FileManager {
    File file;
    Scanner scanner;

    public FileManager(String filePath) throws FileNotFoundException {
        this.file = new File(filePath);
        this.scanner = new Scanner(file);
    }

    public Optional<User> findAccount(String[] data) {
        String id = data[0];
        String password = data[1];

        while (scanner.hasNextLine()) {
            String information = scanner.nextLine();

            if (information.equals("")) {
                continue;
            }

            String[] accountInformation = information.split(",");
            String accountId = accountInformation[0];
            String accountPassword = accountInformation[1];

            if (id.equals(accountId) && password.equals(accountPassword)) {
                return Optional.of(new User(accountInformation));
            }
        }

        return Optional.empty();
    }

    public void modifyMoney(String id, int balance) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();

        while (scanner.hasNextLine()) {
            String[] information = scanner.nextLine().split(",");

            if (information[0].equals(id)) {
                information[2] = Integer.toString(balance);
            }

            stringBuffer.append(String.join(",", information) + "\n");
        }

        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(String.valueOf(stringBuffer));
        fileWriter.close();
    }
}
