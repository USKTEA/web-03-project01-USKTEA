import models.Payment;
import models.Product;
import models.Order;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class PaymentTest {

    @Test
    void simpleCheckRequest() {
        Payment payment = new Payment();

        Optional <Order> receipt = payment.purchase(new Product(), 0, "test");

        assertNotNull(receipt);
    }

    @Test
    void requestSuccess() {
        Payment payment = new Payment();

        int userBalance = 10;

        Optional<Order> receipt = payment.purchase(new Product("테스트상품", 10), userBalance, "test");

        assertEquals("상품명: 테스트상품, 금액: 10원", receipt.get().toString());
    }

    @Test
    void requestFailed() {
        Payment payment = new Payment();

        int userBalance = 10;
        int productPrice = 100;

        Optional<Order> receipt = payment.purchase(new Product("테스트상품", productPrice), userBalance, "test");

        assertEquals(true, receipt.isEmpty());
    }
}
