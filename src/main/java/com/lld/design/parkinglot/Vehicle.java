package com.lld.design.parkinglot;

public abstract class Vehicle {

	private String plateNumber;
	private VehicleSize size;

	public Vehicle(String plateNumber, VehicleSize size) {
		this.plateNumber = plateNumber;
		this.size = size;
	}

	public String getPlateNumber() {
		return plateNumber;
	}

	public VehicleSize getSize() {
		return size;
	}
}
