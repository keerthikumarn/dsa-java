package com.lld.design.carrentalsystem;

import java.time.LocalDate;
import java.util.List;

public class CarRentalSystem {

	public static void main(String[] args) {
		RentalEngine rentalEngine = RentalEngine.getInstance();
		rentalEngine.addCar(new Car("Maruti Brezza", "2021", "KA05FV1234", 2500.00, true, 2024));
		rentalEngine.addCar(new Car("Mahindra XUV 700", "2020", "KA05BG6678", 3000.00, false, 2024));
		rentalEngine.addCar(new Car("Hyundai Creta", "2022", "KA05TY9890", 2000.00, true, 2024));

		Customer customer1 = new Customer("Keerthi Kumar N", "keerthi@no-reply.com", "DL1234");

		LocalDate startDate = LocalDate.now();
		LocalDate endDate = startDate.plusDays(3);
		
		List<Car> availableCars = rentalEngine.searchCars("2021", "Maruti Brezza", startDate, endDate);
		
		if (!availableCars.isEmpty()) {
            Car selectedCar = availableCars.get(0);
            Reservation reservation = rentalEngine.makeReservation(customer1, selectedCar, startDate, endDate);
            if (reservation != null) {
                boolean paymentSuccess = rentalEngine.processPayment(reservation);
                if (paymentSuccess) {
                    System.out.println("Reservation successful. Reservation ID: " + reservation.getReservationId());
                } else {
                    System.out.println("Payment failed. Reservation canceled.");
                    rentalEngine.cancelReservation(reservation.getReservationId());
                }
            } else {
                System.out.println("Selected car is not available for the given dates.");
            }
        } else {
            System.out.println("No available cars found for the given criteria.");
        }
	}

}