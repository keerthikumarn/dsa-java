package com.lld.design.restaurantmanagement;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

import com.lld.design.flightticketbooking.Payment;

public class RestaurantManagementSystem {

	private static RestaurantManagementSystem instance;
	private Map<String, MenuItem> menu;
	private Map<String, Order> orders;
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
	
	public MenuItem getMenuItem(String name) {
		return menu.get(name);
	}

}
