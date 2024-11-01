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
public class Theatre {
	
	private String id;
	private String name;
	private String location;
	private List<Show> shows;

}
