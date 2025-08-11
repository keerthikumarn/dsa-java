package com.lld.design.parkinglot;

import java.util.Date;
import java.util.UUID;

import lombok.Getter;

@Getter
public class ParkingTicket {

	private String ticketId;
	private Vehicle vehicle;
	private ParkingSpot spot;
	private long entryTimestamp;
	private long exitTimestamp;

	public ParkingTicket(Vehicle vehicle, ParkingSpot spot) {
		this.ticketId = UUID.randomUUID().toString();
		this.vehicle = vehicle;
		this.spot = spot;
		this.entryTimestamp = new Date().getTime();
	}

	public void setExitTimestamp() {
		this.exitTimestamp = new Date().getTime();
	}

}
