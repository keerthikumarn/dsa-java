package com.lld.design.flightticketbooking;

public class PaymentProcessor {

	public static PaymentProcessor instance;

	public static synchronized PaymentProcessor getInstance() {
		if (instance == null) {
			instance = new PaymentProcessor();
		}
		return instance;
	}
	
	public void processPayment(Payment payment) {
		payment.processPayment();
	}

}
