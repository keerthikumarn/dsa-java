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

	public void reserve() {
		if (this.status == SeatStatus.AVAILABLE) {
			this.status = SeatStatus.RESERVED;
		} else {
			throw new IllegalStateException("Seat is not available for reservation.");
		}
	}

	public void release() {
		if (this.status == SeatStatus.RESERVED) {
			this.status = SeatStatus.AVAILABLE;
		} else {
			throw new IllegalStateException("Seat is not reserved, cannot release.");
		}
	}

	public synchronized void book() {
		if (this.status == SeatStatus.AVAILABLE) {
			this.status = SeatStatus.BOOKED;
		} else {
			throw new IllegalStateException("Seat is not available for booking.");
		}
	}
}
