package com.lld.design.parkinglot;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

class TestParkingLot {

	private ParkingLot parkingLot;
	private ParkingFloor mockFloor;
	private Vehicle mockVehicle;
	private ParkingSpot mockSpot;
	private ParkingTicket mockTicket;

	@BeforeEach
	void setUp() {
		parkingLot = ParkingLot.getInstance();
		mockFloor = Mockito.mock(ParkingFloor.class);
		mockVehicle = Mockito.mock(Vehicle.class);
		mockSpot = Mockito.mock(ParkingSpot.class);
		mockTicket = Mockito.mock(ParkingTicket.class);
		parkingLot.addFloor(mockFloor);
	}

	@Test
	void parkVehicleSuccessfullyWhenSpotIsAvailable() {
		Mockito.when(mockVehicle.getPlateNumber()).thenReturn("ABC123");
		Mockito.when(mockFloor.findAvailableSpot(Mockito.any(Vehicle.class))).thenReturn(Optional.of(mockSpot));
		Mockito.when(mockSpot.getSpotId()).thenReturn("Spot1");
		Optional<ParkingTicket> ticket = parkingLot.parkVehicle(mockVehicle);
		assertTrue(ticket.isPresent());
		assertEquals("ABC123", ticket.get().getVehicle().getPlateNumber());
		Mockito.verify(mockSpot).parkVehicle(mockVehicle);
	}

	@Test
	void parkVehicleFailsWhenNoSpotIsAvailable() {
		Mockito.when(mockFloor.findAvailableSpot(Mockito.any(Vehicle.class))).thenReturn(Optional.empty());
		Optional<ParkingTicket> ticket = parkingLot.parkVehicle(mockVehicle);
		assertFalse(ticket.isPresent());
	}

	@Test
	void unparkVehicleFailsWhenTicketNotFound() {
		Optional<Double> fee = parkingLot.unparkVehicle("INVALID123");
		assertFalse(fee.isPresent());
	}
}
