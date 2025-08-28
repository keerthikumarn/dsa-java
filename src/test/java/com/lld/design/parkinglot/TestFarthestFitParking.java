package com.lld.design.parkinglot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TestFarthestFitParking {

	private FarthestFitParking farthestFitParking;
	private ParkingFloor mockFloor1;
	private ParkingFloor mockFloor2;
	private Vehicle mockVehicle;

	@BeforeEach
	void setUp() {
		farthestFitParking = new FarthestFitParking();
		mockFloor1 = mock(ParkingFloor.class);
		mockFloor2 = mock(ParkingFloor.class);
		mockVehicle = mock(Vehicle.class);
	}

	@DisplayName("findSpot should return an empty Optional if no spots are available on any floor")
	@Test
	void findSpotReturnsEmptyWhenNoSpotsAvailable() {
		when(mockFloor1.findAvailableSpot(mockVehicle)).thenReturn(Optional.empty());
		when(mockFloor2.findAvailableSpot(mockVehicle)).thenReturn(Optional.empty());

		Optional<ParkingSpot> result = farthestFitParking.findSpot(List.of(mockFloor1, mockFloor2), mockVehicle);

		assertTrue(result.isEmpty());
		verify(mockFloor1).findAvailableSpot(mockVehicle);
		verify(mockFloor2).findAvailableSpot(mockVehicle);
	}

	@DisplayName("findSpot should return an empty Optional if the list of floors is empty")
	@Test
	void findSpotReturnsEmptyWhenFloorsListIsEmpty() {
		Optional<ParkingSpot> result = farthestFitParking.findSpot(List.of(), mockVehicle);

		assertTrue(result.isEmpty());
	}

	@DisplayName("findSpot should return an empty Optional when the vehicle is null")
	@Test
	void findSpotReturnsEmptyWhenVehicleIsNull() {
		Optional<ParkingSpot> result = farthestFitParking.findSpot(List.of(mockFloor1, mockFloor2), null);
		assertTrue(result.isEmpty());
		verify(mockFloor1, never()).findAvailableSpot(null);
		verify(mockFloor2, never()).findAvailableSpot(null);
	}

	@DisplayName("findSpot should handle null floors list gracefully")
	@Test
	void findSpotHandlesNullFloorsListGracefully() {
		Optional<ParkingSpot> result = farthestFitParking.findSpot(null, mockVehicle);

		assertTrue(result.isEmpty());
	}

}
