package com.masking.demo;

import java.util.Map;

public class MaskingDemo {

	public static void main(String[] args) {
		EmployeeService service = new EmployeeService();
		Map<String, String> employeeData = service.getEmployeeById(1);
		employeeData.forEach((key, value) -> System.out.println(key + ": " + value));
	}

}
