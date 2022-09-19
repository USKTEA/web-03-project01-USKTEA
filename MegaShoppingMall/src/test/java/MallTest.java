import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MallTest {

    @Test
    void setProducts() {
        Mall mall = new Mall();
        List<Product> mock = List.of(
                new Product(),
                new Product(),
                new Product()
        );

        mall.set(mock);

        assertEquals(mock, mall.get());
    }
}
