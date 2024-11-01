package com.lld.design.movieticketbooking;

import java.time.LocalDateTime;
import java.util.Map;

public class Show {
	
	private String id;
    private Movie movie;
    private Theater theater;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Map<String, Seat> seats;

}
