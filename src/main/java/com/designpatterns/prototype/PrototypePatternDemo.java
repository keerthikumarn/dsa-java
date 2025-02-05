package com.designpatterns.prototype;

import java.util.List;

public class PrototypePatternDemo {

	public static void main(String[] args) throws CloneNotSupportedException {
		Vehicle vehicleA = new Vehicle();
	    vehicleA.insertData();
	    
	    Vehicle vehicleB = (Vehicle) vehicleA.clone();
	    List<String> list = vehicleB.getVehicleList();
	    list.add("Honda new Amaze");
	    
	    System.out.println(vehicleA.getVehicleList());
	    System.out.println(list);
	    
	    vehicleB.getVehicleList().remove("Audi A4");
	    System.out.println(list);
	    System.out.println(vehicleA.getVehicleList());
	}

}
