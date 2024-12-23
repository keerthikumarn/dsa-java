package com.ddd.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class Order {

	private final String orderId;
	private final String customerId;
	private final List<OrderItem> orderItems;
	private OrderStatus status;

	public Order(String customerId) {
		this.orderId = UUID.randomUUID().toString();
		this.customerId = customerId;
		this.orderItems = new ArrayList<>();
		this.status = OrderStatus.CREATED;
	}

	public void addItem(String productId, int quantity) {
		this.orderItems.add(new OrderItem(productId, quantity));
	}

	public void completeOrder() {
		if (this.orderItems.isEmpty()) {
			throw new IllegalStateException("Cannot complete an order with no items.");
		}
		this.status = OrderStatus.COMPLETED;
	}

	public String getOrderId() {
		return orderId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public List<OrderItem> getOrderItems() {
		return Collections.unmodifiableList(orderItems);
	}

	public OrderStatus getStatus() {
		return status;
	}

}
