import java.util.List;

// TODO : 상품을 받아와서 화면에 보여줌

public class Mall {
    List<Product> products;

    public void set(List<Product> products) {
        this.products = products;
    }

    public List<Product> get() { //TODO 상품정보 받는거, 패널에 그리드로 출력
        return products;
    }
}
