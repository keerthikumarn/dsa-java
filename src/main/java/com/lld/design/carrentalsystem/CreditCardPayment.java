package com.lld.design.carrentalsystem;

public class CreditCardPayment implements PaymentProcess {

	@Override
	public boolean processPayment(double amount) {
		return true;
	}

}
