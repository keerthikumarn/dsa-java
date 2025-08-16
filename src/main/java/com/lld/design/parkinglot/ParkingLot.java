package com.lld.design.parkinglot;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ParkingLot {

	private static ParkingLot instance;
	private List<ParkingFloor> floors = new ArrayList<>();
	private Map<String, ParkingTicket> activeTickets;
	private ParkingFee feeStrategy;
	private Parking parkingStrategy;

	private ParkingLot() {
		this.feeStrategy = new FlatRateFee();
		this.parkingStrategy = new BestFitParking();
		this.activeTickets = new ConcurrentHashMap<>();
	}

	public static synchronized ParkingLot getInstance() {
		if (instance == null) {
			instance = new ParkingLot();
		}
		return instance;
	}

	public void addFloor(ParkingFloor floor) {
		floors.add(floor);
	}
	
	public void setParkingStrategy(Parking parkingStrategy) {
		this.parkingStrategy = parkingStrategy;
	}
}
