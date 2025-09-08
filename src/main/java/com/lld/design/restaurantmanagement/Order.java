package com.lld.design.restaurantmanagement;

import java.util.ArrayList;
import java.util.List;

public class Order {

	private int orderId;
	private int tableId;
	private List<OrderItem> orderItems = new ArrayList<>();
	private boolean isReady = false;
	private OrderStatus status = OrderStatus.NEW;

	public Order(int orderId, int tableId) {
		this.orderId = orderId;
		this.tableId = tableId;
	}

	public Order(int tableId, List<OrderItem> orderItems) {
		this.tableId = tableId;
		this.orderItems = orderItems;
	}

	public void addItem(OrderItem item) {
		this.orderItems.add(item);
	}

	public double getTotalAmount() {
		return orderItems.stream().mapToDouble(item -> item.getMenuItem().getPrice()).sum();
	}

	public int getOrderId() {
		return orderId;
	}

	public int getTableId() {
		return tableId;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void markReady() {
		this.isReady = true;
		this.status = OrderStatus.READY;
	}
	
	public void markPaid() {
        this.status = OrderStatus.PAID;
    }

	public boolean isReady() {
		return isReady;
	}

	public OrderStatus getStatus() {
		return status;
	}

}
