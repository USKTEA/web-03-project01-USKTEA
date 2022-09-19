import java.io.File;
import java.io.FileNotFoundException;
import java.util.Optional;
import java.util.Scanner;

public class FileManager {
    File file;

    public FileManager(String file) {
        this.file = new File(file);
    }


    public Optional<Account> findAccount(String[] data) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);

        String id = data[0];
        String password = data[1];

        while (scanner.hasNextLine()) {
            String[] accountInformation = scanner.nextLine().split(",");
            String accountId = accountInformation[1];
            String accountPassword = accountInformation[2];

            if (id.equals(accountId) && password.equals(accountPassword)) {
                return Optional.of(new Account(accountInformation));
            }
        }

        return Optional.empty();
    }
}
