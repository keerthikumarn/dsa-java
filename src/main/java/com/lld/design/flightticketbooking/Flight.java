package com.lld.design.flightticketbooking;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import com.lld.design.concertbooking.Seat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Flight {

	private String flightNumber;
	private String source;
	private String destination;
	private LocalDateTime departureTime;
	private LocalDateTime arrivalTime;
	private FlightStatus status;
	private Aircraft aircraft;
	private Map<String, Seat> seats;
	private List<Seat> availableSeats;
	
	
}
