import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class PaymentTest {

    @Test
    void simpleCheckRequest() {
        Payment payment = new Payment();

        Optional <Receipt> receipt = payment.checkRequest(new Product(), 0);

        assertNotNull(receipt);
    }

    @Test
    void requestSuccess() {
        Payment payment = new Payment();

        int userBalance = 10;

        Optional<Receipt> receipt = payment.checkRequest(new Product("테스트상품", 10), userBalance);

        assertEquals("상품명: 테스트상품, 금액: 10원", receipt.get().toString());
    }

    @Test
    void requestFailed() {
        Payment payment = new Payment();

        int userBalance = 10;
        int productPrice = 100;

        Optional<Receipt> receipt = payment.checkRequest(new Product("테스트상품", productPrice), userBalance);

        assertEquals(true, receipt.isEmpty());
    }
}
