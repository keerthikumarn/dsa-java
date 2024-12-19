package com.ddd.demo;

public class DomainDriverDesignDemo {

	public static void main(String[] args) {
		InMemoryOrderRepository repository = new InMemoryOrderRepository();
		OrderService orderService = new OrderService(repository);

		// Create a new order
		String orderId = orderService.createOrder("customer-566");
		System.out.println("Order created with ID: " + orderId);

		// Add items to the order
		orderService.addItemToOrder(orderId, "product-123", 2);
		orderService.addItemToOrder(orderId, "product-678", 1);
		System.out.println("Items added to the order.");

		// Complete the order
		orderService.completeOrder(orderId);
		System.out.println("Order completed.");
	}

}
