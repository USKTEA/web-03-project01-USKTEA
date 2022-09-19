import constants.Constants;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class AccountTest {
    private final String VALID_ID = Constants.VALID_ID;

    @Test
    void creation() {
        Account account = new Account();

        assertNotNull(account);
    }

    @Test
    void string() {
        String[] information = new String[]{"megaptera", "1234567890", "1000", "일반회원"};

        Account account1 = new Account(information);

        assertEquals("아이디: megaptera, 비밀번호: 1234567890, 잔액: 1000, 등급: 일반회원", account1.toString());
    }

    @Test
    void equality() {
        String[] information1 = new String[]{VALID_ID, "2312312312", "2000", "탈퇴한회원"};
        String[] information2 = new String[]{VALID_ID, "1234567890", "1000", "일반회원"};

        Account account1 = new Account(information1);
        Account account2 = new Account(information2);

        assertEquals(account2, account1);
    }
}
