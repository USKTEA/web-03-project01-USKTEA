public class Receipt { //TODO id로 구매기록 확인하는 기능 추가?
    int id;
    String productName;
    String productPrice;

    public Receipt(Product product) {
        id = (int) System.currentTimeMillis();
        productName = product.name();
        productPrice = product.price();
    }

    @Override
    public String toString() {
        return "상품명: " + productName + ", 금액: " + productPrice + "원";
    }

    public int amount() {
        return Integer.parseInt(productPrice);
    }
}
