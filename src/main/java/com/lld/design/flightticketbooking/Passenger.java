package com.lld.design.flightticketbooking;

import java.util.UUID;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Passenger {

	private String id;
	private String name;
	private String email;

	public Passenger(String name, String email) {
		this.id = UUID.randomUUID().toString();
		this.name = name;
		this.email = email;
	}
}
