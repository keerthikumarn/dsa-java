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

public class TestNearestFitParking {
	private NearestFitParking nearestFitParking;
	private ParkingFloor mockFloor1;
	private ParkingFloor mockFloor2;
	private Vehicle mockVehicle;

	@BeforeEach
	void setUp() {
		nearestFitParking = new NearestFitParking();
		mockFloor1 = mock(ParkingFloor.class);
		mockFloor2 = mock(ParkingFloor.class);
		mockVehicle = mock(Vehicle.class);
	}

	@DisplayName("findSpot should return the first available spot from the first floor")
	@Test
	void findSpotReturnsFirstAvailableSpot() {
		ParkingSpot mockSpot = mock(ParkingSpot.class);
		when(mockFloor1.findAvailableSpot(mockVehicle)).thenReturn(Optional.of(mockSpot));
		when(mockFloor2.findAvailableSpot(mockVehicle)).thenReturn(Optional.empty());

		Optional<ParkingSpot> result = nearestFitParking.findSpot(List.of(mockFloor1, mockFloor2), mockVehicle);

		assertTrue(result.isPresent());
		assertEquals(mockSpot, result.get());
		verify(mockFloor1).findAvailableSpot(mockVehicle);
		verify(mockFloor2, never()).findAvailableSpot(mockVehicle);
	}

	@DisplayName("findSpot should return an empty Optional if no spots are available on any floor")
	@Test
	void findSpotReturnsEmptyWhenNoSpotsAvailable() {
		when(mockFloor1.findAvailableSpot(mockVehicle)).thenReturn(Optional.empty());
		when(mockFloor2.findAvailableSpot(mockVehicle)).thenReturn(Optional.empty());

		Optional<ParkingSpot> result = nearestFitParking.findSpot(List.of(mockFloor1, mockFloor2), mockVehicle);

		assertTrue(result.isEmpty());
		verify(mockFloor1).findAvailableSpot(mockVehicle);
		verify(mockFloor2).findAvailableSpot(mockVehicle);
	}

	@DisplayName("findSpot should return the first available spot from the second floor if the first floor is full")
	@Test
	void findSpotReturnsSpotFromSecondFloorWhenFirstFloorIsFull() {
		ParkingSpot mockSpot = mock(ParkingSpot.class);
		when(mockFloor1.findAvailableSpot(mockVehicle)).thenReturn(Optional.empty());
		when(mockFloor2.findAvailableSpot(mockVehicle)).thenReturn(Optional.of(mockSpot));

		Optional<ParkingSpot> result = nearestFitParking.findSpot(List.of(mockFloor1, mockFloor2), mockVehicle);

		assertTrue(result.isPresent());
		assertEquals(mockSpot, result.get());
		verify(mockFloor1).findAvailableSpot(mockVehicle);
		verify(mockFloor2).findAvailableSpot(mockVehicle);
	}

	@DisplayName("findSpot should return an empty Optional if the list of floors is empty")
	@Test
	void findSpotReturnsEmptyWhenFloorsListIsEmpty() {
		Optional<ParkingSpot> result = nearestFitParking.findSpot(List.of(), mockVehicle);
		assertTrue(result.isEmpty());
	}
}
