package com.lld.design.restaurantmanagement;

public class ServiceChargeDecorator extends BillDecorator {

	private double serviceChargePercentage;

	public ServiceChargeDecorator(BillService billService, double serviceChargePercentage) {
		super(billService);
		this.serviceChargePercentage = serviceChargePercentage;
	}

	@Override
	public double computeTotal() {
		double baseTotal = super.computeTotal();
		double serviceCharge = (serviceChargePercentage / 100) * baseTotal;
		return baseTotal + serviceCharge;
	}

	@Override
	public String getDescription() {
		return super.getDescription() + " | Includes Service Charge: " + serviceChargePercentage + "%";
	}

}
