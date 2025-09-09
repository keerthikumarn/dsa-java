package com.lld.design.restaurantmanagement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.lld.design.flightticketbooking.Payment;

class TestRestaurantManagementSystem {

	private RestaurantManagementSystem restaurantManagementSystem;
	private Bill bill;
	private Payment payment;
	private Order order;

	@BeforeEach
	void setUp() {
		restaurantManagementSystem = RestaurantManagementSystem.getInstance();
		order = mock(Order.class);
		bill = mock(Bill.class);
		payment = mock(Payment.class);
		when(bill.getOrderId()).thenReturn(1);
		when(bill.getTotalAmount()).thenReturn(100.0);
		when(order.getOrderId()).thenReturn(1);
		restaurantManagementSystem.orders.put(1, order);
	}

	@DisplayName("makePayment should complete payment when processPayment returns true")
	@Test
	void makePaymentCompletesPayment() {
		when(payment.processPayment(100.0)).thenReturn(true);
		restaurantManagementSystem.makePayment(bill, payment);
		verify(bill).markPaymentCompleted();
		verify(order).markPaid();
	}

	@DisplayName("makePayment should throw RuntimeException when processPayment returns false")
	@Test
	void makePaymentThrowsExceptionOnFailedPayment() {
		when(payment.processPayment(100.0)).thenReturn(false);
		RuntimeException exception = assertThrows(RuntimeException.class,
				() -> restaurantManagementSystem.makePayment(bill, payment));
		assertEquals("Payment failed for the orderId: 1", exception.getMessage());
		verify(bill).markPaymentFailed();
		verify(order, never()).markPaid();
	}

	@DisplayName("makePayment should throw IllegalArgumentException when order is not found")
	@Test
	void makePaymentThrowsExceptionWhenOrderNotFound() {
		restaurantManagementSystem.orders.clear();
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
				() -> restaurantManagementSystem.makePayment(bill, payment));
		assertEquals("Order not found for the given bill", exception.getMessage());
	}

}
