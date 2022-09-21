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

    public FileManager(String filePath) {
        this.file = new File(filePath);
    }

    public Optional<User> findAccount(String[] idAndEmail) throws IOException {
        scanner = new Scanner(file);

        String id = idAndEmail[0];
        String password = idAndEmail[1];

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
        scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String[] information = scanner.nextLine().split(",");;

            if (information[0].equals(id)) {
                information[2] = Integer.toString(balance);
            }

            stringBuffer.append(String.join(",", information) + "\n");
        }

        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(String.valueOf(stringBuffer));
        fileWriter.close();
    }

    public void storeReceipt(Order order) throws IOException {
        FileWriter fileWriter = new FileWriter(file, true);
        String[] information = order.information();

        fileWriter.write(information[0] + "," + information[1] + "," + information[2] + "," + information[3] + "\n");
        fileWriter.close();
    }

    public List<Order> getReceipts() {
        List<Order> orders = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String[] words = scanner.nextLine().split(",");

            Order order = new Order(Long.parseLong(words[0]), words[1], words[2]);
            orders.add(order);
        }

        return orders;
    }
}
