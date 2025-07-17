package com.lld.design.flightticketbooking;

import lombok.Data;

@Data
public class Seat {
	private String seatNumber;
	private SeatType type;
	private SeatStatus status;
	
	public Seat(String seatNumber, SeatType type) {
		this.seatNumber = seatNumber;
		this.type = type;
		this.status = SeatStatus.AVAILABLE;
	}
}
