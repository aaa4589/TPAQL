package anwer.TP3part1;

import anwer.TP3.Order;
import anwer.TP3.OrderController;
import anwer.TP3.OrderDao;
import anwer.TP3.OrderService;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class OrderControllerTest {

    @Test
    void testCreateOrder() {
        // Arrange
        OrderDao orderDaoMock = mock(OrderDao.class);
        OrderService orderService = new OrderService(orderDaoMock);
        OrderController orderController = new OrderController(orderService);

        Order order = new Order(1, "New laptop");

        // Act
        orderController.createOrder(order);

        // Assert
        verify(orderDaoMock).saveOrder(order); // Vérifie que saveOrder est appelé
    }
}

