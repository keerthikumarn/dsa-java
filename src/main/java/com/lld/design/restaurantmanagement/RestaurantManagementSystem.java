package com.lld.design.restaurantmanagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

import com.lld.design.flightticketbooking.Payment;

public class RestaurantManagementSystem {

	private static RestaurantManagementSystem instance;
	private Map<String, MenuItem> menu;
	Map<Integer, Order> orders;
	private Map<Integer, Payment> payments;
	private List<Staff> staff;
	private Map<Integer, Table> tables;

	private RestaurantManagementSystem() {
		menu = new ConcurrentHashMap<>();
		orders = new ConcurrentHashMap<>();
		payments = new ConcurrentHashMap<>();
		staff = new CopyOnWriteArrayList<>();
		tables = new ConcurrentHashMap<>();
	}

	public static synchronized RestaurantManagementSystem getInstance() {
		if (instance == null) {
			instance = new RestaurantManagementSystem();
		}
		return instance;
	}

	public MenuItem addMenuItem(String id, String name, double price) {
		MenuItem item = new MenuItem(id, name, price);
		menu.put(name, item);
		return item;
	}

	public void removeMenuItem(String itemName) {
		menu.remove(itemName);
	}

	public List<MenuItem> getMenu() {
		return new ArrayList<>(menu.values());
	}

	public void addTable(int tableId, int capacity) {
		tables.put(tableId, new Table(tableId, capacity));
	}

	public Table reserveTable(int tableId) {
		Table table = tables.get(tableId);
		if (table == null) {
			throw new IllegalArgumentException("Invalid table ID");
		}
		table.reserve();
		return table;
	}

	public Order placeOrder(int tableId, List<OrderItem> items) {
		Table table = tables.get(tableId);
		if (table == null || !table.isAvailable()) {
			throw new IllegalStateException("Table not reserved or invalid");
		}
		Order order = new Order(table.getTableId(), items);
		orders.put(order.getOrderId(), order);
		return order;
	}

	public void markOrderPreparing(String orderId) {
		Order order = orders.get(orderId);
		notifyKitchen(order);
	}

	public Bill getBill(String orderId) {
		Order order = orders.get(orderId);
		if (order.getStatus() == OrderStatus.PAID) {
			throw new IllegalStateException("Order already paid");
		}
		order.markPaid();
		return new Bill(order.getOrderId(), order.getTotalAmount());
	}

	public void makePayment(Bill bill, Payment payment) {
		if (bill == null) {
			throw new NullPointerException("Bill cannot be null");
		}
		if (payment == null) {
			throw new NullPointerException("Payment cannot be null");
		}
		Order order = orders.get(bill.getOrderId());
		if (order == null) {
			throw new IllegalArgumentException("Order not found for the given bill");
		}
		if (payment.processPayment(bill.getTotalAmount())) {
			bill.markPaymentCompleted();
			order.markPaid();
		} else {
			bill.markPaymentFailed();
			throw new IllegalStateException("Insufficient payment amount");
		}
	}

	public void markOrderReady(String orderId) {
		Order order = orders.get(orderId);
		order.markReady();
		notifyStaff(order);
	}

	private void notifyStaff(Order order) {
		System.out.println("Staff notified about order ID: " + order.getOrderId());
	}

	private void notifyKitchen(Order order) {
		System.out.println("Kitchen notified about order ID: " + order.getOrderId());
	}
}
