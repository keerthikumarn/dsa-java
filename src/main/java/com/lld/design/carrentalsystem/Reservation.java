package com.lld.design.carrentalsystem;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import lombok.Data;

@Data
public class Reservation {

	private final String reservationId;
	private final Customer customer;
	private final Car car;
	private LocalDate startDate;
	private LocalDate endDate;
	private final double totalPrice;

	public Reservation(String reservationId, Customer customer, Car car, LocalDate startDate, 
			LocalDate endDate) {
		this.reservationId = reservationId;
		this.customer = customer;
		this.car = car;
		this.startDate = startDate;
		this.endDate = endDate;
		this.totalPrice = calculateTotalPrice();
	}

	private double calculateTotalPrice() {
		long daysRented = ChronoUnit.DAYS.between(startDate, endDate) + 1;
		return car.getRentPerDay() * daysRented;
	}
}
