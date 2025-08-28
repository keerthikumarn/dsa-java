package com.lld.design.restaurantmanagement;

import java.util.ArrayList;
import java.util.List;

public class Order {

	private int orderId;
	private int tableId;
	private List<OrderItem> items = new ArrayList<>();

	public Order(int orderId, int tableId) {
		this.orderId = orderId;
		this.tableId = tableId;
	}

	public void addItem(OrderItem item) {
		this.items.add(item);
	}

	public double getTotalAmount() {
		return items.stream().mapToDouble(item -> item.getMenuItem().getPrice()).sum();
	}

	public int getOrderId() {
		return orderId;
	}

	public int getTableId() {
		return tableId;
	}

	public List<OrderItem> getOrderItems() {
		return items;
	}

}
