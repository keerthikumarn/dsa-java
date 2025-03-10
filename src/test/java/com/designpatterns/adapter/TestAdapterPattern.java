package com.designpatterns.adapter;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestAdapterPattern {

	private BarrelCharger barrelCharger;
	private AdapterCharger adapterCharger;

	@BeforeEach
	void setup() {
		barrelCharger = mock(BarrelCharger.class);
		adapterCharger = new AdapterCharger(barrelCharger);
	}

	@Test
	void chargWithUSBConvertsRequestToBarrelPort() {
		adapterCharger.chargWithUSB();
		verify(barrelCharger, times(1)).chargeWithBarrelPort();
	}

	@Test
	void chargWithUSBHandlesNullBarrelCharger() {
		AdapterCharger adapterChargerWithNull = new AdapterCharger(null);
		assertThrows(NullPointerException.class, adapterChargerWithNull::chargWithUSB);
	}

}
