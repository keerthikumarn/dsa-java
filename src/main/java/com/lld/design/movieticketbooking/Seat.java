package com.lld.design.movieticketbooking;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Seat {
	
	private String id;
    private int row;
    private int column;
    private SeatType type;
    private double price;
    private SeatStatus status;

}
