package com.lld.design.restaurantmanagement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class TestServiceChargeDecorator {

	private BillService mockBillService;
	private ServiceChargeDecorator serviceChargeDecorator;

	@BeforeEach
	void setUp() {
		mockBillService = Mockito.mock(BillService.class);
		Mockito.when(mockBillService.computeTotal()).thenReturn(100.0);
		Mockito.when(mockBillService.getDescription()).thenReturn("Base Bill");
		serviceChargeDecorator = new ServiceChargeDecorator(mockBillService, 10.0);
	}

	@Test
	void computeTotalShouldIncludeServiceCharge() {
		double total = serviceChargeDecorator.computeTotal();
		assertEquals(110.0, total);
	}

	@Test
	void computeTotalShouldHandleZeroServiceCharge() {
		serviceChargeDecorator = new ServiceChargeDecorator(mockBillService, 0.0);
		double total = serviceChargeDecorator.computeTotal();
		assertEquals(100.0, total);
	}

	@Test
	void computeTotalShouldHandleNegativeServiceCharge() {
		serviceChargeDecorator = new ServiceChargeDecorator(mockBillService, -10.0);
		double total = serviceChargeDecorator.computeTotal();
		assertEquals(90.0, total);
	}

	@Test
	void getDescriptionShouldIncludeServiceChargePercentage() {
		String description = serviceChargeDecorator.getDescription();
		assertEquals("Base Bill | Includes Service Charge: 10.0%", description);
	}

	@Test
	void getDescriptionShouldHandleZeroServiceCharge() {
		serviceChargeDecorator = new ServiceChargeDecorator(mockBillService, 0.0);
		String description = serviceChargeDecorator.getDescription();
		assertEquals("Base Bill | Includes Service Charge: 0.0%", description);
	}

}
