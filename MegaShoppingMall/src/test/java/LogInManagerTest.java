import constants.Constants;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LogInManagerTest {
    private final String INVALID_ID = Constants.INVALID_ID;
    private final String INVALID_PASSWORD = Constants.INVALID_PASSWORD;
    private final String VALID_ID = Constants.VALID_ID;
    private final String VALID_PASSWORD = Constants.VALID_PASSWORD;

    @Test
    void noAccountFound() throws FileNotFoundException {
        LogInManager logInManager = new LogInManager();
        Optional<Account> optionalAccount = logInManager.findBy(new String[]{INVALID_ID, INVALID_PASSWORD});

        assertEquals(true, optionalAccount.isEmpty());
    }

    @Test
    void accountFound() throws FileNotFoundException {
        LogInManager logInManager = new LogInManager();
        Optional<Account> optionalAccount = logInManager.findBy(new String[]{VALID_ID, VALID_PASSWORD});

        assertEquals(true, optionalAccount.isPresent());
    }

    @Test
    void validateAccount() throws FileNotFoundException {
        LogInManager logInManager = new LogInManager();

        Optional<Account> optionalAccount = logInManager.findBy(new String[]{VALID_ID, VALID_PASSWORD});

        String[] information = new String[]{VALID_ID, VALID_PASSWORD, "1000", "일반회원"};

        Account account = new Account(information);

        assertEquals(optionalAccount.get(), account);
    }
}
