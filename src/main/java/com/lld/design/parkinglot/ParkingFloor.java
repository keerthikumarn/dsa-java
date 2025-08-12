package com.lld.design.parkinglot;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

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

}
