package com.lld.design.flightticketbooking;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestAirlineManagementSystem {

	private AirlineManagementSystem airlineManagementSystem;

	@BeforeEach
	void setUp() {
		airlineManagementSystem = new AirlineManagementSystem();
	}

	void addSampleData() {
		airlineManagementSystem.addAircraft("A123", "Boeing 737", 180);
		airlineManagementSystem.addAircraft("B456", "Airbus A320", 200);
		airlineManagementSystem.addPassenger("John Doe", "john.doe@example.com");
		airlineManagementSystem.addPassenger("Jane Smith", "jane.smith@example.com");
		airlineManagementSystem.addFlight("New York", "Los Angeles", LocalDateTime.of(2023, 10, 15, 10, 0),
				LocalDateTime.of(2023, 10, 15, 14, 0), "A123");
	}

	@Test
	void addPassengerShouldAddPassengerSuccessfully() {
		Passenger passenger = airlineManagementSystem.addPassenger("Alice", "alice@example.com");
		assertNotNull(passenger);
		assertEquals("Alice", passenger.getName());
		assertEquals("alice@example.com", passenger.getEmail());
	}

	@Test
	void addFlightShouldAddFlightSuccessfully() {
		airlineManagementSystem.addAircraft("A123", "Boeing 737", 180);
		Flight flight = airlineManagementSystem.addFlight("New York", "Los Angeles",
				LocalDateTime.of(2023, 10, 15, 10, 0), LocalDateTime.of(2023, 10, 15, 14, 0), "A123");
		assertNotNull(flight);
		assertEquals("New York", flight.getSource());
		assertEquals("Los Angeles", flight.getDestination());
	}

	@Test
	void searchFlightsShouldReturnMatchingFlights() {
	    addSampleData();
	    List<Flight> flights = airlineManagementSystem.searchFlights("New York", "Los Angeles",
	            LocalDate.of(2023, 10, 15));
	    assertNotNull(flights);
	    assertEquals(1, flights.size());
	    assertEquals("New York", flights.get(0).getSource());
	    assertEquals("Los Angeles", flights.get(0).getDestination());
	}

	@Test
	void processPaymentShouldHandlePaymentSuccessfully() {
		Payment payment = new Payment("12345", "CreditCard Payment", 300.0, PaymentStatus.PENDING);
		assertDoesNotThrow(() -> airlineManagementSystem.processPayment(payment));
	}

}
