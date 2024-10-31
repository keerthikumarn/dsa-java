package com.lld.design.carrentalsystem;

public class CashPayment implements PaymentProcess {

	@Override
	public boolean processPayment(double amount) {
		return true;
	}

}
