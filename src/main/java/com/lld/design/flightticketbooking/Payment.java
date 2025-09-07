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

	public boolean processPayment(double paymentAmount) {
		if (this.amount >= paymentAmount) {
			this.status = PaymentStatus.COMPLETED;
			return true;
		} else {
			this.status = PaymentStatus.FAILED;
			return false;
		}
	}
}
