import models.Product;
import models.Receipt;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReceiptTest {

    @Test
    void string() {
        Receipt receipt = new Receipt(new Product("테스트상품", 10));

        assertEquals("상품명: 테스트상품, 금액: 10원", receipt.toString());
    }

    @Test
    void equality() {
        long id = 1;

        Receipt receipt1 = new Receipt(id, new Product());
        Receipt receipt2 = new Receipt(id, new Product());

        assertEquals(receipt1, receipt2);
    }

    @Test
    void information() {
        Receipt receipt = new Receipt(1, "testProduct", "100", "testId");

        assertArrayEquals(new String[] {"1", "testId", "testProduct", "100"}, receipt.information());
    }
}
