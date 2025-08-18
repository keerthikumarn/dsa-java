package com.lld.design.parkinglot;

import java.util.Optional;

public class ParkingLotDemo {

	public static void main(String[] args) {
		ParkingLot parkingLot = ParkingLot.getInstance();

		ParkingFloor floor1 = new ParkingFloor(1);
		floor1.addSpot(new ParkingSpot("Floor1-S1", VehicleSize.SMALL));
		floor1.addSpot(new ParkingSpot("Floor1-M1", VehicleSize.MEDIUM));
		floor1.addSpot(new ParkingSpot("Floor1-L1", VehicleSize.LARGE));

		ParkingFloor floor2 = new ParkingFloor(2);
		floor2.addSpot(new ParkingSpot("Floor2-M1", VehicleSize.MEDIUM));
		floor2.addSpot(new ParkingSpot("Floor2-M2", VehicleSize.MEDIUM));

		parkingLot.addFloor(floor1);
		parkingLot.addFloor(floor2);

		// Set parking strategy
		parkingLot.setParkingStrategy(new BestFitParking());

		// 2. Simulate vehicle entries
		System.out.println("\n--- Vehicle Entries ---");
		floor1.displayAvailability();
		floor2.displayAvailability();

		Vehicle bike = new Bike("KA05 NB 4321");
		Vehicle car = new Car("KA01 HG 3456");
		Vehicle lorry = new Lorry("KA41 KJ 3309");

		Optional<ParkingTicket> bikeTicket = parkingLot.parkVehicle(bike);
		Optional<ParkingTicket> carTicket = parkingLot.parkVehicle(car);
		Optional<ParkingTicket> lorryTicket = parkingLot.parkVehicle(lorry);

		// 3. Display parking status
		System.out.println("\n--- Availability after parking ---");
		floor1.displayAvailability();
		floor2.displayAvailability();

		// 3. Simulate another car entry (should go to floor 2)
		Vehicle car2 = new Car("KA41 LK 2233");
		Optional<ParkingTicket> car2TicketOpt = parkingLot.parkVehicle(car2);

		// 4. Simulate a vehicle entry that fails (no available spots)
		Vehicle bike2 = new Bike("KA05 BG 5644");
		Optional<ParkingTicket> failedBikeTicketOpt = parkingLot.parkVehicle(bike2);

	}

}
