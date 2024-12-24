package com.ddd.demo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InMemoryOrderRepository implements OrderRepository {

	private final Map<String, Order> orderStore = new HashMap<>();

	@Override
	public void save(Order order) {
		orderStore.put(order.getOrderId(), order);
	}

	@Override
	public Order findById(String orderId) {
		return orderStore.get(orderId);
	}

	@Override
	public List<Order> getAllOrders(String customerId) {
		return orderStore.values().stream().filter(order -> order.getCustomerId().equals(customerId))
				.collect(Collectors.toList());
	}

}
