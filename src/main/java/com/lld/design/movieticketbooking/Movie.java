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
public class Movie {
	
	private String id;
	private String title;
	private int durationInMinutes;

}
