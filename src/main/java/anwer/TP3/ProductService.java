package anwer.TP3;


public class ProductService {

    private final ProductApiClient client;

    public ProductService(ProductApiClient client) {
        this.client = client;
    }

    public Product getProduct(String productId) {
        return client.getProduct(productId);
    }
}
