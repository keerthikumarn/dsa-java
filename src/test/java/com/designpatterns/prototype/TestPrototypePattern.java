package com.designpatterns.prototype;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestPrototypePattern {

	private Vehicle vehicle;

	@BeforeEach
	void setUp() {
		vehicle = new Vehicle();
	}

	@Test
	void testCloneCreateDeepCopy() throws CloneNotSupportedException {
		vehicle.insertData();
		Vehicle clonedVehicle = (Vehicle) vehicle.clone();
		clonedVehicle.getVehicleList().add("Honda new Amaze");
		assertEquals(5, vehicle.getVehicleList().size());
		assertEquals(6, clonedVehicle.getVehicleList().size());
	}

	@Test
	void cloneRemovesElementFromClonedList() throws CloneNotSupportedException {
		vehicle.insertData();
		Vehicle clonedVehicle = (Vehicle) vehicle.clone();
		List<String> clonedList = clonedVehicle.getVehicleList();
		clonedList.remove("Audi A4");

		assertFalse(clonedList.contains("Audi A4"));
		assertTrue(vehicle.getVehicleList().contains("Audi A4"));
	}

	@Test
	void insertDataAddsVehicles() {
		vehicle.insertData();
		List<String> vehicleList = vehicle.getVehicleList();

		assertEquals(5, vehicleList.size());
		assertTrue(vehicleList.contains("Mahindra XUV 700"));
		assertTrue(vehicleList.contains("Audi A4"));
		assertTrue(vehicleList.contains("Hyundai Alcazar"));
		assertTrue(vehicleList.contains("Maruti Brezza"));
		assertTrue(vehicleList.contains("Tata Harrier"));
	}

	@Test
	void cloneEmptyVehicleList() throws CloneNotSupportedException {
		Vehicle clonedVehicle = (Vehicle) vehicle.clone();
		List<String> clonedList = clonedVehicle.getVehicleList();

		assertTrue(clonedList.isEmpty());
		assertNotSame(vehicle.getVehicleList(), clonedList);
	}
}
