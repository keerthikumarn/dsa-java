package com.lld.design.flightticketbooking;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FlightSearch {

	private List<Flight> flights;

	public FlightSearch() {
		flights = new ArrayList<>();
	}

	public void addFlight(Flight flight) {
		flights.add(flight);
	}

	public List<Flight> searchFlights(String source, String destination, LocalDate date) {
		return flights.stream()
				.filter(flight -> flight.getSource().equalsIgnoreCase(source)
						&& flight.getDestination().equalsIgnoreCase(destination)
						&& flight.getDepartureTime().toLocalDate().equals(date))
				.collect(Collectors.toList());
	}

}
