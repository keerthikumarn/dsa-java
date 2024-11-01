package com.lld.design.movieticketbooking;

import java.time.LocalDateTime;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Show {
	
	private String id;
    private Movie movie;
    private Theatre theatre;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Map<String, Seat> seats;

}
