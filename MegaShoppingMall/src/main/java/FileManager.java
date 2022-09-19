import java.io.File;
import java.io.FileNotFoundException;
import java.util.Optional;
import java.util.Scanner;

public class FileManager {
    File file;

    public FileManager(String file) {
        this.file = new File(file);
    }


    public Optional<User> findAccount(String[] data) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);

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
}
