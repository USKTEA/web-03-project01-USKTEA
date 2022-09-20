package models;

import java.util.List;

// TODO : 상품을 받아와서 화면에 보여줌
// TODO : 품목별로 받을 수 있게 설정하자 추천/일반 - 과일/과자/생필품/의류, 그럼 패널을 변경하는 로직도 필요
public class Mall {
    private List<Product> products;

    public void set(List<Product> products) {
        this.products = products;
    }

    public List<Product> get() {
        return products;
    }
}
