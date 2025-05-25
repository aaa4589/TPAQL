package anwer.TP3;

public class Order {
    private int id;
    private String productName;

    public Order() {}

    public Order(int id, String productName) {
        this.id = id;
        this.productName = productName;
    }

    public int getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
