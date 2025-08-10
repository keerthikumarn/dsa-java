package com.lld.design.parkinglot;

public enum VehicleSize {

	SMALL, MEDIUM, LARGE;

	public static VehicleSize fromString(String size) {
		switch (size.toUpperCase()) {
		case "SMALL":
			return SMALL;
		case "MEDIUM":
			return MEDIUM;
		case "LARGE":
			return LARGE;
		default:
			throw new IllegalArgumentException("Unknown vehicle size: " + size);
		}
	}

}
