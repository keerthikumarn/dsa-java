package com.lld.design.carrentalsystem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

	private String name;
	private String contactInfo;
	private String driversLicenseNumber;
}
