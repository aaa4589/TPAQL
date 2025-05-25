package anwer.TP3part1;

import anwer.TP3.Product;
import anwer.TP3.ProductApiClient;
import anwer.TP3.ProductService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class ProductServiceTest {

    @Test
    void testGetProduct_Success() throws Exception {
        // Arrange
        ProductApiClient apiClientMock = mock(ProductApiClient.class);
        Product expectedProduct = new Product("p1", "Phone");

        when(apiClientMock.getProduct("p1")).thenReturn(expectedProduct);

        ProductService productService = new ProductService(apiClientMock);

        // Act
        Product product = productService.getProduct("p1");

        // Assert
        assertEquals(expectedProduct, product);
        verify(apiClientMock).getProduct("p1");
    }

    @Test
    void testGetProduct_ApiFailure() throws Exception {
        // Arrange
        ProductApiClient apiClientMock = mock(ProductApiClient.class);
        when(apiClientMock.getProduct("p2")).thenThrow(new RuntimeException("API Error"));

        ProductService productService = new ProductService(apiClientMock);

        // Act + Assert
        assertThrows(RuntimeException.class, () -> {
            productService.getProduct("p2");
        });

        verify(apiClientMock).getProduct("p2");
    }
}
