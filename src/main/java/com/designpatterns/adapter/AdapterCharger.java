package com.designpatterns.adapter;

public class AdapterCharger implements USBTypeCCharger {

	private BarrelCharger barrelCharger;

	public AdapterCharger(BarrelCharger barrelCharger) {
		this.barrelCharger = barrelCharger;
	}

	@Override
	public void chargWithUSB() {
		System.out.println("Adapter converts USB-C request to Barrel Connector.");
		barrelCharger.chargeWithBarrelPort();
	}

}
