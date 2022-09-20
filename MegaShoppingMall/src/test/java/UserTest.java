import constants.Constants;
import models.Product;
import models.Receipt;
import models.User;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class UserTest {
    private final String VALID_ID = Constants.VALID_ID;

    @Test
    void creation() {
        User user = new User();

        assertNotNull(user);
    }

    @Test
    void string() {
        String[] information = new String[]{"megaptera", "1234567890", "1000", "일반회원"};

        User user1 = new User(information);

        assertEquals("아이디: megaptera, 비밀번호: 1234567890, 잔액: 1000, 등급: 일반회원", user1.toString());
    }

    @Test
    void equality() {
        String[] information1 = new String[]{VALID_ID, "2312312312", "2000", "탈퇴한회원"};
        String[] information2 = new String[]{VALID_ID, "1234567890", "1000", "일반회원"};

        User user1 = new User(information1);
        User user2 = new User(information2);

        assertEquals(user2, user1);
    }

    @Test
    void purchaseRequest() {
        User user = new User();
        Optional<Receipt> receipt = user.sendRequest(new Product());

        assertNotNull(receipt);
    }

    @Test
    void billing() throws IOException {
        int money = 100;
        int price = 10;

        User user = new User(money);
        Product product = new Product("테스트상품", price);
        user.pay(new Receipt(product));

        assertEquals(100 - 10, user.balance());
    }
}
