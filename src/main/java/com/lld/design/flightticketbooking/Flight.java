package com.lld.design.flightticketbooking;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
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

	public Flight(String source, String destination, LocalDateTime departureTime, LocalDateTime arrivalTime,
			FlightStatus status, Aircraft aircraft) {
		this.source = source;
		this.destination = destination;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.status = status;
		this.aircraft = aircraft;
		this.flightNumber = aircraft.getTailNumber() + "-" + departureTime.toLocalDate().toString();
		//this.seats = aircraft.getTotalSeats();
		this.availableSeats = getAvailableSeats();
	}

	public boolean isSeatAvailable(String seatNumber) {
		Seat seat = seats.get(seatNumber);
		return seat != null && seat.getStatus() == SeatStatus.AVAILABLE;
	}

	public synchronized void reserveSeat(String seatNo) {
		Seat seat = seats.get(seatNo);
		if (seat == null) {
			throw new IllegalArgumentException("Invalid seat number");
		}
		seat.reserve();
	}

	public synchronized void releaseSeat(String seatNo) {
		Seat seat = seats.get(seatNo);
		if (seat != null) {
			seat.release();
		}
	}

	public String getSource() {
		return source;
	}

	public String getDestination() {
		return destination;
	}

	public LocalDateTime getDepartureTime() {
		return departureTime;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public LocalDateTime getArrivalTime() {
		return arrivalTime;
	}

	public List<Seat> getAvailableSeats() {
		return availableSeats;
	}
}
