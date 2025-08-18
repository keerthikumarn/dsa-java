package com.lld.design.parkinglot;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
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
	
	public Optional<ParkingTicket> parkVehicle(Vehicle vehicle) {
		Optional<ParkingSpot> availableSpot = parkingStrategy.findSpot(floors, vehicle);
		if (availableSpot.isPresent()) {
			ParkingSpot spot = availableSpot.get();
            spot.parkVehicle(vehicle);
            ParkingTicket ticket = new ParkingTicket(vehicle, spot);
            activeTickets.put(vehicle.getPlateNumber(), ticket);
            System.out.printf("%s Parked at %s. Ticket: %s\n", vehicle.getPlateNumber(), spot.getSpotId(), ticket.getTicketId());
            return Optional.of(ticket);
		}
		System.out.println("No available parking space for " + vehicle.getPlateNumber());
		return Optional.empty();
	}
	
	public Optional<Double> unparkVehicle(String licenseNumber) {
        ParkingTicket ticket = activeTickets.remove(licenseNumber);
        if (ticket == null) {
            System.out.println("Ticket not found");
            return Optional.empty();
        }
        ticket.setExitTimestamp();
        ticket.getSpot().removeVehicle();
        activeTickets.remove(ticket.getTicketId());
        Double parkingFee = feeStrategy.calculateFee(ticket);
        return Optional.of(parkingFee);
    }
	
}
