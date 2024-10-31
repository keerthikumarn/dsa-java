package com.lld.design.carrentalsystem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class RentalEngine {

	private static RentalEngine rentalEngine;
	private Map<String, Car> cars;
	private Map<String, Reservation> reservations;
	private PaymentProcess paymentProcessor;

	private RentalEngine() {
		this.cars = new ConcurrentHashMap<>();
		this.reservations = new ConcurrentHashMap<String, Reservation>();
		this.paymentProcessor = new CreditCardPayment();
	}

	public static synchronized RentalEngine getInstance() {
		if (rentalEngine == null) {
			rentalEngine = new RentalEngine();
		}
		return rentalEngine;
	}

	public void addCar(Car car) {
		this.cars.put(car.getLicenseNumber(), car);
	}

	public void removeCar(String licenseNumber) {
		this.cars.remove(licenseNumber);
	}

	public List<Car> searchCars(String make, String model, LocalDate startDate, LocalDate endDate) {
		List<Car> availableCars = new ArrayList<>();
		for (Car car : cars.values()) {
			if (car.getYearOfMake().equalsIgnoreCase(make) && car.getModel().equalsIgnoreCase(model)) {
				if (isCarAvailable(car, startDate, endDate)) {
					availableCars.add(car);
				}
			}
		}
		return availableCars;
	}

	private boolean isCarAvailable(Car car, LocalDate startDate, LocalDate endDate) {
		for (Reservation reservation : reservations.values()) {
			if (reservation.getCar().equals(car)) {
				if (startDate.isBefore(reservation.getEndDate()) && endDate.isAfter(reservation.getStartDate())) {
					return false;
				}
			}
		}
		return true;
	}

	public synchronized Reservation makeReservation(Customer customer, Car car, LocalDate startDate,
			LocalDate endDate) {
		if (isCarAvailable(car, startDate, endDate)) {
			String reservationId = generateReservationId();
			Reservation reservation = new Reservation(reservationId, customer, car, startDate, endDate);
			reservations.put(reservationId, reservation);
			car.setAvailable(false);
			return reservation;
		}
		return null;
	}

	public synchronized void cancelReservation(String reservationId) {
		Reservation reservation = reservations.remove(reservationId);
		if (reservation != null) {
			reservation.getCar().setAvailable(true);
		}
	}

	public boolean processPayment(Reservation reservation) {
		return paymentProcessor.processPayment(reservation.getTotalPrice());
	}

	private String generateReservationId() {
		return "Booking_" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
	}
}
