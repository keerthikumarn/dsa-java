package com.lld.design.restaurantmanagement;

public class Bill implements BillService {

	private Order order;

	public Bill(Order order) {
		this.order = order;
	}

	@Override
	public double computeTotal() {
		return order.getTotalAmount();
	}

	@Override
	public String getDescription() {
		return "Bill generated for the order id : " + order.getOrderId();
	}

}
