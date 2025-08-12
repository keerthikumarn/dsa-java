package com.lld.design.parkinglot;

import java.util.Map;

public class VehicleBasedRateFee implements ParkingFee {

	private static final Map<VehicleSize, Double> RATE_PER_HOUR = Map.of(VehicleSize.SMALL, 15.0, VehicleSize.MEDIUM,
			30.0, VehicleSize.LARGE, 45.0);

	@Override
	public double calculateFee(ParkingTicket parkingTicket) {
		long parkingDuration = parkingTicket.getExitTimestamp() - parkingTicket.getEntryTimestamp();
		long hoursParked = (parkingDuration / (1000 * 60 * 60)) + 1;
		return hoursParked * RATE_PER_HOUR.get(parkingTicket.getVehicle().getSize());
	}

}
