package com.lld.design.restaurantmanagement;

public class OrderedState implements OrderItemState {
	
	@Override
	public void next(OrderItem item) {
		item.setState(new PreparingState());
	}

	@Override
	public void prev(OrderItem item) {
		System.out.println("The order is in its root state.");
	}

	@Override
	public String getStatus() {
		return "ORDERED";
	}

}
