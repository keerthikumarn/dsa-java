package com.lld.design.restaurantmanagement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class RestaurantManagementSystemFacade {

	private static RestaurantManagementSystemFacade instance = null;
	private static Restaurant restaurant = Restaurant.getInstance();
	private AtomicInteger orderIdCounter;
	private Map<Integer, Order> orders;

	private RestaurantManagementSystemFacade() {
		this.orderIdCounter = new AtomicInteger(1);
		this.orders = new HashMap<>();
	}

	public static RestaurantManagementSystemFacade getInstance() {
		if (instance == null) {
			instance = new RestaurantManagementSystemFacade();
		}
		return instance;
	}

	public Table addTable(int tableId, int capacity) {
		if (capacity <= 0) {
			throw new IllegalArgumentException("Capacity must be greater than 0");
		}
		Table table = new Table(tableId, capacity);
		restaurant.addTable(table);
		return table;
	}

	public Waiter addWaiter(int id, String name) {
		Waiter waiter = new Waiter(id, name);
		restaurant.addWaiter(waiter);
		return waiter;
	}

	public Chef addChef(int id, String name) {
		Chef chef = new Chef(id, name);
		restaurant.addChef(chef);
		return chef;
	}

	public MenuItem addMenuItem(String id, String name, double price) {
		if (price < 0) {
			throw new IllegalArgumentException("Price cannot be negative");
		}
		MenuItem item = new MenuItem(id, name, price);
		restaurant.getMenu().addItem(item);
		return item;
	}

	public Order takeOrder(int tableId, int waiterId, List<String> menuItemIds) {
		Waiter waiter = restaurant.getWaiter(waiterId);
		if (waiter == null) {
			throw new IllegalArgumentException("Invalid waiter ID");
		}
		Chef chef = restaurant.getAllChefs().stream().findFirst()
				.orElseThrow(() -> new IllegalStateException("No chefs available"));
		Order order = new Order(orderIdCounter.getAndIncrement(), tableId);
		for (String itemId : menuItemIds) {
			MenuItem menuItem = restaurant.getMenu().getMenuItem(itemId);
			OrderItem orderItem = new OrderItem(menuItem, order);
			orderItem.addObserver(waiter);
			order.addItem(orderItem);
		}
		Command prepareOrderCommand = new PrepareOrderCommand(order, chef);
		prepareOrderCommand.execute();
		orders.put(order.getOrderId(), order);
		return order;
	}

}
