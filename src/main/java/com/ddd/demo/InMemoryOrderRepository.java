package com.ddd.demo;

import java.util.HashMap;
import java.util.Map;

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

}
