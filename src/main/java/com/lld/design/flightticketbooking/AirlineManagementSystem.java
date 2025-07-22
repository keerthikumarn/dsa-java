package com.lld.design.flightticketbooking;

import java.util.HashMap;
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
	
	public Aircraft addAircraft(String tailNumber, String model, int totalSeats) {
        Aircraft aircraft = new Aircraft(tailNumber, model, totalSeats);
        aircrafts.put(tailNumber, aircraft);
        return aircraft;
    }

}
