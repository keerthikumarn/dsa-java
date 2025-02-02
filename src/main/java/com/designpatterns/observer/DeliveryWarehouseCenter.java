package com.designpatterns.observer;

class DeliveryWarehouseCenter implements Observer {
	private String location;

	@Override
	public void update(String location) {
		this.location = location;
		displayLocation();
	}

	public void displayLocation() {
		System.out.println("Notification at Warehouse - Current Location: " + location);
	}
}
