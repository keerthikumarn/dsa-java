package com.lld.design.flightticketbooking;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

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
}
