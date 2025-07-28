package com.lld.design.flightticketbooking;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AirlineManagementSystem {

	private Map<String, Flight> flights;
	private Map<String, Aircraft> aircrafts;
	private Map<String, Passenger> passengers;
	private FlightSearch flightSearch;
	private FlightBookingManager bookingManager;
	private PaymentProcessor paymentProcessor;

	public AirlineManagementSystem() {
		flights = new HashMap<>();
		aircrafts = new HashMap<>();
		passengers = new HashMap<>();
		flightSearch = new FlightSearch();
		bookingManager = FlightBookingManager.getInstance();
		paymentProcessor = PaymentProcessor.getInstance();
	}

	public Passenger addPassenger(String name, String email) {
		Passenger passenger = new Passenger(name, email);
		passengers.put(passenger.getId(), passenger);
		return passenger;
	}

	public Flight addFlight(String source, String destination, LocalDateTime departure, LocalDateTime arrival,
			String aircraftNumber) {
		Aircraft aircraft = aircrafts.get(aircraftNumber);
		Flight flight = new Flight(source, destination, aircraftNumber, departure, arrival, null, aircraft, null, null);
		flights.put(flight.getFlightNumber(), flight);
		flightSearch.addFlight(flight);
		return flight;
	}

	public Aircraft addAircraft(String tailNumber, String model, int totalSeats) {
		Aircraft aircraft = new Aircraft(tailNumber, model, totalSeats);
		aircrafts.put(tailNumber, aircraft);
		return aircraft;
	}

	public List<Flight> searchFlights(String source, String destination, LocalDate date) {
		return flightSearch.searchFlights(source, destination, date);
	}

	public FlightBooking bookFlight(String flightNumber, String passengerId, Seat seat, double price) {
		Flight flight = flights.get(flightNumber);
		Passenger passenger = passengers.get(passengerId);
		return bookingManager.createBooking(flight, passenger, seat, price);
	}

	public void cancelBooking(String bookingNumber) {
		bookingManager.cancelBooking(bookingNumber);
	}

	public void processPayment(Payment payment) {
		paymentProcessor.processPayment(payment);
	}

}
