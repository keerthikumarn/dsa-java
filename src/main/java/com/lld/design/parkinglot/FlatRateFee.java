package com.lld.design.parkinglot;

public class FlatRateFee implements ParkingFee {

	private static final double RATE_PER_HOUR = 15.0;

	@Override
	public double calculateFee(ParkingTicket ticket) {
		long parkingDuration = ticket.getExitTimestamp() - ticket.getEntryTimestamp();
		long hoursParked = (parkingDuration / (1000 * 60 * 60)) + 1;
		return hoursParked * RATE_PER_HOUR;
	}

}