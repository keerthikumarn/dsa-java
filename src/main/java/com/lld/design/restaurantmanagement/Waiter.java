package com.lld.design.restaurantmanagement;

public class Waiter extends Staff implements OrderObserver {

	public Waiter(int staffId, String name) {
		super(staffId, name);
	}

	@Override
	public void update(OrderItem order) {
		System.out.println("WAITER: " + getName() + " NOTIFIED: Item '" + order.getMenuItem().getName() + "' for table "
				+ order.getOrder().getTableId() + " is READY FOR PICKUP.");
	}

	public void serveOrder(Order order) {
		System.out.println("Waiter " + getName() + " is serving order " + order.getOrderId());
		order.getOrderItems().forEach(item -> {
			item.changeState(new ServedState());
		});
	}

}
