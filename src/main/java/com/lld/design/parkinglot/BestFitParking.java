package com.lld.design.parkinglot;

import java.util.List;
import java.util.Optional;

public class BestFitParking implements Parking {

	@Override
	public Optional<ParkingSpot> findSpot(List<ParkingFloor> floors, Vehicle vehicle) {
		Optional<ParkingSpot> bestSpot = Optional.empty();
		for (ParkingFloor floor : floors) {
			Optional<ParkingSpot> spotOnCurrentFloor = floor.findAvailableSpot(vehicle);
			if (spotOnCurrentFloor.isPresent()) {
				if (bestSpot.isEmpty()) {
					bestSpot = spotOnCurrentFloor;
				} else {
					if (spotOnCurrentFloor.get().getSpotSize().ordinal() < bestSpot.get().getSpotSize().ordinal()) {
						bestSpot = spotOnCurrentFloor;
					}
				}
			}
		}
		return bestSpot;
	}

}
