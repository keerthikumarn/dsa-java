package com.lld.design.parkinglot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class TestBestFitParking {

	private BestFitParking bestFitParking;
	private ParkingFloor mockFloor1;
	private ParkingFloor mockFloor2;
	private ParkingSpot mockSpot1;
	private ParkingSpot mockSpot2;
	private Vehicle mockVehicle;

	@BeforeEach
	void setUp() {
		bestFitParking = new BestFitParking();
		mockFloor1 = Mockito.mock(ParkingFloor.class);
		mockFloor2 = Mockito.mock(ParkingFloor.class);
		mockSpot1 = Mockito.mock(ParkingSpot.class);
		mockSpot2 = Mockito.mock(ParkingSpot.class);
		mockVehicle = Mockito.mock(Vehicle.class);
	}

	@Test
	void findSpotReturnsBestFitWhenMultipleSpotsAvailable() {
		Mockito.when(mockFloor1.findAvailableSpot(mockVehicle)).thenReturn(Optional.of(mockSpot1));
		Mockito.when(mockFloor2.findAvailableSpot(mockVehicle)).thenReturn(Optional.of(mockSpot2));
		Mockito.when(mockSpot1.getSpotSize()).thenReturn(VehicleSize.MEDIUM);
		Mockito.when(mockSpot2.getSpotSize()).thenReturn(VehicleSize.SMALL);
		Optional<ParkingSpot> result = bestFitParking.findSpot(List.of(mockFloor1, mockFloor2), mockVehicle);
		assertTrue(result.isPresent());
		assertEquals(mockSpot2, result.get());
	}

	@Test
	void findSpotReturnsEmptyWhenNoSpotsAvailable() {
		Mockito.when(mockFloor1.findAvailableSpot(mockVehicle)).thenReturn(Optional.empty());
		Mockito.when(mockFloor2.findAvailableSpot(mockVehicle)).thenReturn(Optional.empty());
		Optional<ParkingSpot> result = bestFitParking.findSpot(List.of(mockFloor1, mockFloor2), mockVehicle);
		assertTrue(result.isEmpty());
	}

	@Test
	void findSpotReturnsSpotFromFirstFloorWhenOnlyOneSpotAvailable() {
		Mockito.when(mockFloor1.findAvailableSpot(mockVehicle)).thenReturn(Optional.of(mockSpot1));
		Mockito.when(mockFloor2.findAvailableSpot(mockVehicle)).thenReturn(Optional.empty());
		Optional<ParkingSpot> result = bestFitParking.findSpot(List.of(mockFloor1, mockFloor2), mockVehicle);
		assertTrue(result.isPresent());
		assertEquals(mockSpot1, result.get());
	}

	@Test
	void findSpotReturnsEmptyWhenNoFloorsProvided() {
		Optional<ParkingSpot> result = bestFitParking.findSpot(List.of(), mockVehicle);
		assertTrue(result.isEmpty());
	}
}
