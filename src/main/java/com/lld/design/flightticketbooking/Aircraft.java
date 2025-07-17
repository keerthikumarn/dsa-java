package com.lld.design.flightticketbooking;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Aircraft {
	private String tailNumber;
	private String model;
	private int totalSeats;
}
