package com.lld.design.restaurantmanagement;

public class TaxDecorator extends BillDecorator {

	private final double taxRate;

	public TaxDecorator(BillService billService, double taxRate) {
		super(billService);
		this.taxRate = taxRate;
	}

	@Override
	public double computeTotal() {
		return super.computeTotal() * (1 + taxRate);
	}

	@Override
	public String getDescription() {
		return super.getDescription() + ", Tax @" + (taxRate * 100) + "%";
	}

}
