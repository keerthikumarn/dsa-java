package com.ddd.demo;

public class OrderService {
	private final OrderRepository orderRepository;

	public OrderService(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	public String createOrder(String customerId) {
		Order order = new Order(customerId);
		orderRepository.save(order);
		return order.getOrderId();
	}

	public void addItemToOrder(String orderId, String productId, int quantity) {
		Order order = orderRepository.findById(orderId);
		if (order == null) {
			throw new IllegalArgumentException("Order not found.");
		}
		order.addItem(productId, quantity);
		orderRepository.save(order);
	}

	public void completeOrder(String orderId) {
		Order order = orderRepository.findById(orderId);
		if (order == null) {
			throw new IllegalArgumentException("Order not found.");
		}
		order.completeOrder();
		orderRepository.save(order);
	}
}
