package com.lld.design.flightticketbooking;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import com.lld.design.concertbooking.Seat;

public class Flight {

	private final String flightNumber;
	private final String source;
	private final String destination;
	private final LocalDateTime departureTime;
	private final LocalDateTime arrivalTime;
	private final FlightStatus status;
	private final Aircraft aircraft;
	private final Map<String, Seat> seats;
	private final List<Seat> availableSeats;
}
