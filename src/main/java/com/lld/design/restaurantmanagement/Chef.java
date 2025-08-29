package com.lld.design.restaurantmanagement;

public class Chef extends Staff {

	public Chef(int staffId, String name) {
		super(staffId, name);
	}

	public void prepareOrder(Order order) {
		System.out.println(
				"Chef " + this.getName() + " received order " + order.getOrderId() + " and is starting preparation.");
		order.getOrderItems().forEach(item -> {
			item.changeState(new PreparingState());
		});
	}

}
