package com.designpatterns.saga;

public class FlightBookingService extends Service<String> {

	@Override
	public String getName() {
		return "Booking a flight !!";
	}

}
