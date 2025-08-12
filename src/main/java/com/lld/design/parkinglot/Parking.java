package com.lld.design.parkinglot;

import java.util.List;
import java.util.Optional;

public interface Parking {
	
	public Optional<ParkingSpot> findSpot(List<ParkingFloor> floors, Vehicle vehicle);
}
