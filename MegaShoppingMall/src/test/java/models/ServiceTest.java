package models;

import constants.Constants;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ServiceTest {
    private final String PRODUCT_SAMPLE1 = Constants.PRODUCT_SAMPLE1;
    private final String PRODUCT_SAMPLE2 = Constants.PRODUCT_SAMPLE2;

    @Test
    void creation() {
        Service service = new Service();

        assertNotNull(service);
    }

    @Test
    void equality() {
        int price1 = 10;
        int price2 = 20;

        Service service1 = new Service(PRODUCT_SAMPLE1, price1);
        Service service2 = new Service(PRODUCT_SAMPLE1, price2);
        Service service3 = new Service(PRODUCT_SAMPLE2, price1);

        assertEquals(service1, service2);
        assertNotEquals(service1, service3);
    }
}
