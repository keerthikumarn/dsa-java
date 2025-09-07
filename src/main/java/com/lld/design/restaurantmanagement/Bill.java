package com.lld.design.restaurantmanagement;

public class Bill implements BillService {

	private Order order;
	private int orderId;
	private double totalAmount;
	private boolean paymentCompleted;

	public Bill(Order order) {
		this.order = order;
	}

	public Bill(int orderId, double totalAmount) {
		this.orderId = orderId;
		this.totalAmount = totalAmount;
		this.paymentCompleted = false;
	}

	@Override
	public double computeTotal() {
		return order.getTotalAmount();
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Order getOrder() {
		return order;
	}

	public int getOrderId() {
		return orderId;
	}

	public void markPaymentCompleted() {
		this.paymentCompleted = true;
	}

	public boolean isPaymentCompleted() {
		return paymentCompleted;
	}

	public void markPaymentFailed() {
		this.paymentCompleted = false;
	}

	@Override
	public String getDescription() {
		return order != null ? "Bill generated for the order id : " + order.getOrderId()
				: "Bill generated for the order id : " + orderId;
	}

}
