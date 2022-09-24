package models;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class PaymentTest {

    @Test
    void simpleCheckRequest() throws IOException {
        Payment payment = new Payment();

        Optional <Order> order = payment.purchase(new Service(), new User());

        assertNotNull(order);
    }

    @Test
    void purchaseSuccess() throws IOException {
        Payment payment = new Payment();

        int userBalance = 10;

        Optional<Order> order = payment.purchase(new Service("테스트상품", 10), new User(userBalance));

        assertEquals("상품명: 테스트상품, 금액: 10원", order.get().toString());
    }

    @Test
    void purchaseFailed() throws IOException {
        Payment payment = new Payment();

        int userBalance = 10;
        int productPrice = 100;

        Optional<Order> order = payment.purchase(new Service("테스트상품", productPrice), new User(userBalance));

        assertEquals(true, order.isEmpty());
    }

    @Test
    void modifyUserMoney() throws IOException {
        Payment payment = new Payment();

        User user = new User("test", 100);
        Service service = new Service("테스트", 10);

        payment.receivePayment(user, new Order(service, user.id()));

        assertEquals(90, user.balance());
    }
}
