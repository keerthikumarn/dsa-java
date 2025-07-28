package com.lld.design.flightticketbooking;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.lld.design.concertbooking.Booking;

public class FlightBookingManager {

	private static FlightBookingManager instance;
	private Map<String, FlightBooking> bookings;
	private Object lock = new Object();

	private FlightBookingManager() {
		this.bookings = new HashMap<>();
	}

	public static FlightBookingManager getInstance() {
		if (instance == null) {
			synchronized (FlightBookingManager.class) {
				if (instance == null) {
					instance = new FlightBookingManager();
				}
			}
		}
		return instance;
	}

	public FlightBooking createBooking(Flight flight, Passenger passenger, Seat seat, double price) {
		String bookingNumber = UUID.randomUUID().toString();
		FlightBooking booking = new FlightBooking(flight, passenger, seat, price);
		synchronized (lock) {
			bookings.put(bookingNumber, booking);
		}
		return booking;
	}

	public void cancelBooking(String bookingNumber) {
		synchronized (lock) {
			FlightBooking booking = bookings.stream()
			        .filter(b -> b.getId().equals(bookingId))
			        .findFirst()
			        .orElseThrow(() -> new IllegalArgumentException("Booking not found or already canceled"));

			    bookings.remove(booking);
		}
	}

}
