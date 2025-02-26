package com.designpatterns.adapter;

public class AdapterPatternDemo {

	public static void main(String[] args) {
		// old charger
		BarrelCharger barrelCharger = new BarrelCharger();

		// new charger
		USBTypeCCharger adapterCharger = new AdapterCharger(barrelCharger);
		System.out.println("Client plugs in USB-C charger:");
		adapterCharger.chargWithUSB();
	}

}
