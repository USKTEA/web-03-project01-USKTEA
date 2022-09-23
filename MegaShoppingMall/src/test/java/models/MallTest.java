package models;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MallTest {

    @Test
    void mallProducts() {
        List<Product> mock = List.of(
                new Product(),
                new Product(),
                new Product()
        );

        Mall mall = new Mall(mock);

        mall.products();

        assertEquals(mock, mall.products());
    }
}
