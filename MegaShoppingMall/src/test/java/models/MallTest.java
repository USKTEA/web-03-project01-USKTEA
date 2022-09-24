package models;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MallTest {

    @Test
    void mallProducts() {
        List<Service> mock = List.of(
                new Service(),
                new Service(),
                new Service()
        );

        Mall mall = new Mall(mock);

        mall.products();

        assertEquals(mock, mall.products());
    }
}
