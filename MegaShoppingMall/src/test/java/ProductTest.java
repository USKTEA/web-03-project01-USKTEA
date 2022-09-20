import constants.Constants;
import models.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    private final String PRODUCT_SAMPLE1 = Constants.PRODUCT_SAMPLE1;
    private final String PRODUCT_SAMPLE2 = Constants.PRODUCT_SAMPLE2;

    @Test
    void creation() {
        Product product = new Product();

        assertNotNull(product);
    }

    @Test
    void equality() {
        int price1 = 10;
        int price2 = 20;

        Product product1 = new Product(PRODUCT_SAMPLE1, price1);
        Product product2 = new Product(PRODUCT_SAMPLE1, price2);
        Product product3 = new Product(PRODUCT_SAMPLE2, price1);

        assertEquals(product1, product2);
        assertNotEquals(product1, product3);
    }

}

