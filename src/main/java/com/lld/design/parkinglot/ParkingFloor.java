package com.lld.design.parkinglot;

import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class ParkingFloor {

	private int floorNumber;
	private Map<String, ParkingSpot> parkingSpots;

	public ParkingFloor(int floorNumber) {
		this.floorNumber = floorNumber;
		this.parkingSpots = new ConcurrentHashMap<>();
	}

	public void addSpot(ParkingSpot spot) {
		parkingSpots.put(spot.getSpotId(), spot);
	}

	public synchronized Optional<ParkingSpot> findAvailableSpot(Vehicle vehicle) {
		return parkingSpots.values().stream()
				.filter(parkingSpot -> !parkingSpot.isOccupied() && parkingSpot.canFitVehicle(vehicle))
				.sorted(Comparator.comparing(ParkingSpot::getSpotSize)).findFirst();
	}

	public void displayAvailability() {
		Map<VehicleSize, Long> availableSpots = parkingSpots.values().stream()
				.filter(parkingSpot -> !parkingSpot.isOccupied())
				.collect(Collectors.groupingBy(ParkingSpot::getSpotSize, Collectors.counting()));

		for (VehicleSize size : VehicleSize.values()) {
			System.out.printf("  %s spots: %d\n", size, availableSpots.getOrDefault(size, 0L));
		}
	}

}
