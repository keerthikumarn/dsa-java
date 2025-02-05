package com.designpatterns.prototype;

import java.util.ArrayList;
import java.util.List;

public class Vehicle implements Cloneable {

	private List<String> vehicleList;

	public Vehicle() {
		this.vehicleList = new ArrayList<>();
	}

	public Vehicle(List<String> vehicleList) {
		this.vehicleList = vehicleList;
	}

	public void insertData() {
		vehicleList.add("Mahindra XUV 700");
		vehicleList.add("Audi A4");
		vehicleList.add("Hyundai Alcazar");
		vehicleList.add("Maruti Brezza");
		vehicleList.add("Tata Harrier");
	}

	public List<String> getVehicleList() {
		return this.vehicleList;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		List<String> vehicleList = new ArrayList<String>();
		for (String vehicle : this.getVehicleList()) {
			vehicleList.add(vehicle);
		}
		return new Vehicle(vehicleList);
	}
}
