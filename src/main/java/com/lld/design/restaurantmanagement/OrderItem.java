package com.lld.design.restaurantmanagement;

import java.util.ArrayList;
import java.util.List;

public class OrderItem {

	private MenuItem menuItem;
	private Order order;
	private OrderItemState orderItemState;
	private List<OrderObserver> observers = new ArrayList<>();

	public OrderItem(MenuItem menuItem, Order order) {
		this.menuItem = menuItem;
		this.order = order;
		this.state = new OrderedState();
	}

	public void changeState(OrderItemState newState) {
		this.orderItemState = newState;
		System.out.println("Item '" + menuItem.getName() + "' state changed to: " + newState.getStatus());
	}

	public void nextState() {
		this.orderItemState.next(this);
	}

	public void setState(OrderItemState orderItemState) {
		this.orderItemState = orderItemState;
	}

	public void addObserver(OrderObserver observer) {
		this.observers.add(observer);
	}
	
	public void notifyObservers() {
		new ArrayList<>(observers).forEach(observer -> observer.update(this));
	}
	
}
