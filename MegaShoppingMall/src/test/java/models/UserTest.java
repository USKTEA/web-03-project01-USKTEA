package models;

import constants.Constants;
import models.Product;
import models.Order;
import models.User;
import org.junit.jupiter.api.Test;

import java.io.IOException;

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
    void string() throws IOException {
        String[] information = new String[]{"megaptera", "1234567890", "1000", "일반회원"};

        User user1 = new User(information);

        assertEquals("아이디: megaptera, 비밀번호: 1234567890, 잔액: 1000, 등급: 일반회원", user1.toString());
    }

    @Test
    void equality() throws IOException {
        String[] information1 = new String[]{VALID_ID, "2312312312", "2000", "탈퇴한회원"};
        String[] information2 = new String[]{VALID_ID, "1234567890", "1000", "일반회원"};

        User user1 = new User(information1);
        User user2 = new User(information2);

        assertEquals(user2, user1);
    }

    @Test
    void billing() throws IOException {
        int money = 100;
        int price = 10;

        User user = new User(money);
        Product product = new Product("테스트상품", price);
        user.pay(new Order(product));

        assertEquals(100 - 10, user.balance());
    }
}
