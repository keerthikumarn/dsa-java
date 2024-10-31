package com.lld.design.carrentalsystem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
	
	private String model;
	private String yearOfMake;
	private String licenseNumber;
	private double rentPerDay;
	private boolean available;
	private int year;

}
