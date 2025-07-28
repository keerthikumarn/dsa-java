package com.lld.design.flightticketbooking;

import java.util.UUID;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FlightBooking {
	private String id;
    private Flight flight;
    private Passenger passenger;
    private Seat seat;
    private double price;
    private FlightBookingStatus status;
    
    public FlightBooking(Flight flight, Passenger passenger, Seat seat, double price) {
        this.id = UUID.randomUUID().toString();
        this.flight = flight;
        this.passenger = passenger;
        this.seat = seat;
        this.price = price;
        this.status = FlightBookingStatus.CONFIRMED;
    }
    
    public void cancelBooking() {
    	this.status = FlightBookingStatus.CANCELLED;
    	seat.release();
    }
    
	public String getId() {
		return id;
	}
}
