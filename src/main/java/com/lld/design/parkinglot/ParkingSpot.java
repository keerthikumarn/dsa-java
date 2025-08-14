package com.lld.design.parkinglot;

public class ParkingSpot {

	private String spotId;
	private boolean isOccupied;
	private Vehicle parkedVehicle;
	private VehicleSize spotSize;

	public ParkingSpot(String spotId, VehicleSize spotSize) {
		this.spotId = spotId;
		this.isOccupied = false;
		this.parkedVehicle = null;
		this.spotSize = spotSize;
	}

	public String getSpotId() {
		return spotId;
	}

	public VehicleSize getSpotSize() {
		return spotSize;
	}

	public synchronized boolean isAvailable() {
		return !isOccupied;
	}

	public boolean isOccupied() {
		return isOccupied;
	}

}
