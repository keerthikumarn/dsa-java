package com.lld.design.restaurantmanagement;

import java.util.HashMap;
import java.util.Map;

public class Menu {

	private Map<String, MenuItem> item = new HashMap<>();

	public void addItem(MenuItem menuItem) {
		item.put(menuItem.getId(), menuItem);
	}

	public MenuItem getMenuItem(String id) {
		MenuItem item = this.item.get(id);
		if (item == null) {
			throw new IllegalArgumentException("Menu item with ID " + id + " not found.");
		}
		return item;
	}

}
