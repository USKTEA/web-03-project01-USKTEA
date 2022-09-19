import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReceiptTest {

    @Test
    void string() {
        Receipt receipt = new Receipt(new Product("테스트상품", 10));

        assertEquals("상품명: 테스트상품, 금액: 10원", receipt.toString());
    }
}
