package com.lld.design.restaurantmanagement;

public class ServiceOrderCommand implements Command {
	
	private Order order;
	private Waiter waiter;
	
	public ServiceOrderCommand(Order order, Waiter waiter) {
		this.order = order;
		this.waiter = waiter;
	}

	@Override
	public void execute() {
		waiter.serveOrder(order);
	}	

}
