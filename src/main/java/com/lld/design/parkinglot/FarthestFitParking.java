package com.lld.design.parkinglot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class FarthestFitParking implements Parking {

	@Override
	public Optional<ParkingSpot> findSpot(List<ParkingFloor> floors, Vehicle vehicle) {
		if (floors == null || vehicle == null) {
			return Optional.empty();
		}

		// Iterate over the floors in reverse order directly
		for (int idx = floors.size() - 1; idx >= 0; idx--) {
			ParkingFloor floor = floors.get(idx);
			Optional<ParkingSpot> spot = floor.findAvailableSpot(vehicle);
			if (spot.isPresent()) {
				return spot;
			}
		}

		return Optional.empty();
	}
}
