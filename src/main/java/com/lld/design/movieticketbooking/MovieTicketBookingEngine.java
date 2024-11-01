package com.lld.design.movieticketbooking;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class MovieTicketBookingEngine {

	private static MovieTicketBookingEngine instance;
	private List<Movie> movies;
	private List<Theatre> theaters;
	private Map<String, Show> shows;
	private Map<String, Booking> bookings;
	private static final AtomicLong bookingCounter = new AtomicLong(0);

	private MovieTicketBookingEngine() {
		movies = new ArrayList<>();
		theaters = new ArrayList<>();
		shows = new ConcurrentHashMap<>();
		bookings = new ConcurrentHashMap<>();
	}

	public static synchronized MovieTicketBookingEngine getInstance() {
		if (instance == null) {
			instance = new MovieTicketBookingEngine();
		}
		return instance;
	}

	public void addMovie(Movie movie) {
		this.movies.add(movie);
	}

	public void addTheatre(Theatre theatre) {
		this.theaters.add(theatre);
	}

	public void addShow(Show show) {
		shows.put(show.getId(), show);
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public List<Theatre> getTheaters() {
		return theaters;
	}

	public Map<String, Show> getShows() {
		return shows;
	}

	public Show getShow(String showId) {
		return shows.get(showId);
	}

	public synchronized Booking bookTickets(User user, Show show, List<Seat> selectedSeats) {
		Booking booking = null;
		if (areSeatsAvailable(show, selectedSeats)) {
			markSeatsAsBooked(show, selectedSeats);
			double totalPrice = calculateTotalPrice(selectedSeats);
			String bookingId = generateBookingId();
			booking = new Booking(bookingId, user, show, selectedSeats, totalPrice, BookingStatus.WAITING);
			bookings.put(bookingId, booking);
		}
		return booking;
	}

	public synchronized void confirmBooking(String bookingId) {
		Booking booking = bookings.get(bookingId);
		if (booking != null && booking.getStatus() == BookingStatus.WAITING) {
			booking.setStatus(BookingStatus.CONFIRMED);
		}
	}

	public synchronized void cancelBooking(String bookingId) {
		Booking booking = bookings.get(bookingId);
		if (booking != null && booking.getStatus() != BookingStatus.CANCELLED) {
			booking.setStatus(BookingStatus.CANCELLED);
			markSeatsAsAvailable(booking.getShow(), booking.getSeats());
		}
	}

	private double calculateTotalPrice(List<Seat> selectedSeats) {
		return selectedSeats.stream().mapToDouble(Seat::getPrice).sum();
	}

	private String generateBookingId() {
		long bookingNumber = bookingCounter.incrementAndGet();
		String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
		return "BOOKING_ID_" + timestamp + String.format("%06d", bookingNumber);
	}

	private void markSeatsAsBooked(Show show, List<Seat> selectedSeats) {
		for (Seat seat : selectedSeats) {
			Seat showSeat = show.getSeats().get(seat.getId());
			showSeat.setStatus(SeatStatus.BOOKED);
		}
	}

	private boolean areSeatsAvailable(Show show, List<Seat> selectedSeats) {
		boolean areSeatsAvailable = false;
		for (Seat seat : selectedSeats) {
			Seat showSeat = show.getSeats().get(seat.getId());
			if (showSeat != null || showSeat.getStatus() == SeatStatus.AVAILABLE) {
				areSeatsAvailable = true;
			}
		}
		return areSeatsAvailable;
	}

	private void markSeatsAsAvailable(Show show, List<Seat> seats) {
		for (Seat seat : seats) {
			Seat showSeat = show.getSeats().get(seat.getId());
			showSeat.setStatus(SeatStatus.AVAILABLE);
		}
	}

}
