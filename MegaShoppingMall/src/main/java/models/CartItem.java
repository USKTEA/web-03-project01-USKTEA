package models;

public class CartItem {
    private long id;
    private String name;
    private String price;
    private String userId;

    public CartItem(long id, Service service) {
        this.id = id;
        this.name = service.name();
        this.price = service.price();
    }

    public CartItem(String id, String name, String price, String userId) {
        this.id = Long.parseLong(id);
        this.name = name;
        this.price = price;
        this.userId = userId;
    }

    CartItem() {}

    public CartItem(long id) {
        this.id = id;
    }

    public String name() {
        return name;
    }

    public String price() {
        return price;
    }

    public long id() {
        return id;
    }

    public String userId() {
        return userId;
    }

    public boolean equals(Object other) {
        CartItem otherCartItem = (CartItem) other;

        return this.id == otherCartItem.id();
    }
}
