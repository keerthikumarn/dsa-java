package com.ddd.demo;

import java.util.List;

public interface OrderRepository {
	void save(Order order);

	Order findById(String orderId);
	
	List<Order> getAllOrders(String customerId);
}