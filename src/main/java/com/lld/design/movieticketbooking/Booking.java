package com.lld.design.movieticketbooking;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Booking {
	
	private String id;
	private User user;
	private Show show;
	private List<Seat> seats;
	private double price;
	private BookingStatus status;

}
