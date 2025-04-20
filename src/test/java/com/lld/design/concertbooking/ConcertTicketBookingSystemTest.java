package com.lld.design.concertbooking;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class ConcertTicketBookingSystemTest {

	private ConcertTicketBookingSystem bookingSystem;
	private Concert concert;
	private User user;
	private List<Seat> seats;

	@BeforeEach
	void setup() {
		bookingSystem = ConcertTicketBookingSystem.getInstance();
		seats = generateSeats(10);
		concert = new Concert("C001", "Artist 1", "Venue 1", LocalDateTime.now().plusDays(10), seats);
		bookingSystem.addConcert(concert);
	}

	@Test
	void bookingFailsWhenSeatIsAlreadyBooked() {
		seats.get(0).book();
		List<Seat> selectedSeats = List.of(seats.get(0));
		Executable bookingAction = () -> bookingSystem.bookTickets(user, concert, selectedSeats);
		assertThrows(SeatNotAvailableException.class, bookingAction);
	}

	@Test
	void bookingSucceedsForAvailableSeats() {
		List<Seat> selectedSeats = List.of(seats.get(0), seats.get(1));
		Booking booking = bookingSystem.bookTickets(user, concert, selectedSeats);
		assertNotNull(booking);
		assertEquals(BookingStatus.CONFIRMED, booking.getStatus());
		assertEquals(2, booking.getSeats().size());
	}

	@Test
	void cancelBookingReleasesSeats() {
		List<Seat> selectedSeats = List.of(seats.get(0), seats.get(1));
		Booking booking = bookingSystem.bookTickets(user, concert, selectedSeats);
		bookingSystem.cancelBooking(booking.getId());
		assertEquals(SeatStatus.AVAILABLE, seats.get(0).getStatus());
		assertEquals(SeatStatus.AVAILABLE, seats.get(1).getStatus());
	}

	@Test
	void searchReturnsMatchingConcerts() {
		List<Concert> results = bookingSystem.searchConcerts("Artist 1", "Venue 1", concert.getDateTime());
		assertEquals(1, results.size());
		assertEquals("Artist 1", results.get(0).getArtist());
	}

	@Test
	void searchReturnsEmptyForNonMatchingCriteria() {
		List<Concert> results = bookingSystem.searchConcerts("Nonexistent Artist", "Venue 1", concert.getDateTime());
		assertTrue(results.isEmpty());
	}

	private List<Seat> generateSeats(int numberOfSeats) {
		List<Seat> seats = new ArrayList<>();
		for (int i = 1; i <= numberOfSeats; i++) {
			seats.add(new Seat("S" + i, "S" + i, SeatType.REGULAR, 50.0));
		}
		return seats;
	}

}
