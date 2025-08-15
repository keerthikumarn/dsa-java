package com.lld.design.parkinglot;

import java.util.List;
import java.util.Optional;

public class NearestFitParking implements Parking {

	@Override
	public Optional<ParkingSpot> findSpot(List<ParkingFloor> floors, Vehicle vehicle) {
		for(ParkingFloor floor : floors) {
			Optional<ParkingSpot> spotOnCurrentFloor = floor.findAvailableSpot(vehicle);
			if (spotOnCurrentFloor.isPresent()) {
				return spotOnCurrentFloor;
			}
		}
		return Optional.empty();
	}

}
