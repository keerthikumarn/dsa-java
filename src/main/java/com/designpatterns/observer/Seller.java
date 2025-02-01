package com.designpatterns.observer;

public class Seller implements Observer {

	private String location;

	@Override
	public void update(String location) {
		this.location = location;
		displayLocation();
	}

	private void displayLocation() {
		System.out.println("Notification to seller current location: " + location);
	}

}
