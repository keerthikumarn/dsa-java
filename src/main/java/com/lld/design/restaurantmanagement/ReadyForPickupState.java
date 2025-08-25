package com.lld.design.restaurantmanagement;

public class ReadyForPickupState implements OrderItemState {

	@Override
	public void next(OrderItem item) {
		item.notifyObservers();
	}

	@Override
	public void prev(OrderItem item) {
		item.setState(new PreparingState());
	}

	@Override
	public String getStatus() {
		return "READY_FOR_PICKUP";
	}

}
