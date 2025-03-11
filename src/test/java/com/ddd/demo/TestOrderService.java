package com.ddd.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestOrderService {

	private OrderService orderService;
    private InMemoryOrderRepository orderRepository;

    @BeforeEach
    void setUp() {
        orderRepository = new InMemoryOrderRepository();
        orderService = new OrderService(orderRepository);
    }

    @Test
    void addItemToOrder_addsItemToExistingOrder() {
        String customerId = "customer-123";
        String orderId = orderService.createOrder(customerId);
        orderService.addItemToOrder(orderId, "product-456", 2);
        Order order = orderRepository.findById(orderId);
        assertEquals(1, order.getOrderItems().size());
        assertEquals("product-456", order.getOrderItems().get(0).getProductId());
        assertEquals(2, order.getOrderItems().get(0).getQuantity());
    }

    @Test
    void addItemToOrder_throwsExceptionWhenOrderNotFound() {
        assertThrows(IllegalArgumentException.class, () -> {
            orderService.addItemToOrder("non-existent-order", "product-456", 2);
        });
    }

    @Test
    void completeOrder_completesOrderWithItems() {
        String customerId = "customer-123";
        String orderId = orderService.createOrder(customerId);
        orderService.addItemToOrder(orderId, "product-456", 2);
        orderService.completeOrder(orderId);
        Order order = orderRepository.findById(orderId);
        assertEquals(OrderStatus.COMPLETED, order.getStatus());
    }

    @Test
    void completeOrder_throwsExceptionWhenOrderHasNoItems() {
        String customerId = "customer-123";
        String orderId = orderService.createOrder(customerId);
        assertThrows(IllegalStateException.class, () -> {
            orderService.completeOrder(orderId);
        });
    }

    @Test
    void getAllOrders_returnsOrdersForCustomer() {
        String customerId = "customer-123";
        orderService.createOrder(customerId);
        orderService.createOrder(customerId);
        List<Order> orders = orderService.getAllOrders(customerId);
        assertEquals(2, orders.size());
        assertTrue(orders.stream().allMatch(order -> order.getCustomerId().equals(customerId)));
    }

}
