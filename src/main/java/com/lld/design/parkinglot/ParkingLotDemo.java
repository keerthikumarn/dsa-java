package com.lld.design.parkinglot;

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
		
		

	}

}
