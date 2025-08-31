package com.lld.design.restaurantmanagement;

public abstract class BillDecorator implements BillService {

	protected BillService billService;

	public BillDecorator(BillService billService) {
		this.billService = billService;
	}

	@Override
	public double computeTotal() {
		return billService.computeTotal();
	}

	@Override
	public String getDescription() {
		return billService.getDescription();
	}

}
