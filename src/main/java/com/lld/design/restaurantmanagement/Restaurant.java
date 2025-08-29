package com.lld.design.restaurantmanagement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Restaurant {

	private static Restaurant INSTANCE = new Restaurant();
	private Map<Integer, Waiter> waiters = new HashMap<>();
	private Map<Integer, Chef> chefs = new HashMap<>();
	private Map<Integer, Table> tables = new HashMap<>();
	private Menu menu = new Menu();

	private Restaurant() {
	}

	public static Restaurant getInstance() {
		return INSTANCE;
	}

	public void addWaiter(Waiter waiter) {
		waiters.put(waiter.getStaffId(), waiter);
	}

	public Waiter getWaiter(int id) {
		return waiters.get(id);
	}

	public void addChef(Chef chef) {
		chefs.put(chef.getStaffId(), chef);
	}

	public Chef getChef(int id) {
		return chefs.get(id);
	}

	public List<Chef> getAllChefs() {
		return chefs.values().stream().toList();
	}

	public List<Waiter> getAllWaiters() {
		return waiters.values().stream().toList();
	}

	public void addTable(Table table) {
		tables.put(table.getTableId(), table);
	}

	public Menu getMenu() {
		return menu;
	}
}
