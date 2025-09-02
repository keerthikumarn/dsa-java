package com.lld.design.restaurantmanagement;

public class PrepareOrderCommand implements Command{
	
	private Order order;
	private Chef chef;
	
	public PrepareOrderCommand(Order order, Chef chef) {
		this.order = order;
		this.chef = chef;
	}
	
	@Override
	public void execute() {
		chef.prepareOrder(order);
	}

}
