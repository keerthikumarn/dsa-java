package com.lld.design.flightticketbooking;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
	private String paymentId;
	private String paymentMethod;
	private double amount;
	private PaymentStatus status;
	
	public void processPayment() {
		status = PaymentStatus.COMPLETED;
	}
}
