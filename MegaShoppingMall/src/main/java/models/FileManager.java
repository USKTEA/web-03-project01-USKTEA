package models;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class FileManager {
    private File file;
    private Scanner scanner;

    public FileManager(String filePath) throws IOException {
        this.file = new File(filePath);
        this.scanner = new Scanner(file);
    }

    public Optional<User> findAccount(String[] data) throws IOException {
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

    public void storeReceipt(Receipt receipt) throws IOException {
        FileWriter fileWriter = new FileWriter(file, true);
        String[] information = receipt.information();

        fileWriter.write(information[0] + "," + information[1] + "," + information[2] + "," + information[3] + "\n");
        fileWriter.close();
    }

    public List<Receipt> getReceipts() {
        List<Receipt> receipts = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String[] words = scanner.nextLine().split(",");

            Receipt receipt = new Receipt(Long.parseLong(words[0]), words[1], words[2]);
            receipts.add(receipt);
        }

        return receipts;
    }
}
