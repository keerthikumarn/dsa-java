package com.lld.design.restaurantmanagement;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TestTaxDecorator {

	@Test
	@DisplayName("computeTotal should return the total amount including tax")
	void computeTotalReturnsTotalWithTax() {
		BillService baseBill = new BillService() {
			@Override
			public double computeTotal() {
				return 100.0;
			}

			@Override
			public String getDescription() {
				return "Base Bill";
			}
		};
		TaxDecorator taxDecorator = new TaxDecorator(baseBill, 0.1); // 10% tax
		double total = taxDecorator.computeTotal();
		assertEquals(110.0, total, 0.01);
	}

	@Test
	@DisplayName("getDescription should append tax details to the base description")
	void getDescriptionAppendsTaxDetails() {
		BillService baseBill = new BillService() {
			@Override
			public double computeTotal() {
				return 100.0;
			}

			@Override
			public String getDescription() {
				return "Base Bill";
			}
		};
		TaxDecorator taxDecorator = new TaxDecorator(baseBill, 0.15); // 15% tax
		String description = taxDecorator.getDescription();
		assertEquals("Base Bill, Tax @15.0%", description);
	}

	@Test
	@DisplayName("getDescription should return base description when tax rate is zero")
	void getDescriptionReturnsBaseDescriptionWhenTaxRateIsZero() {
		BillService baseBill = new BillService() {
			@Override
			public double computeTotal() {
				return 200.0;
			}

			@Override
			public String getDescription() {
				return "Base Bill";
			}
		};
		TaxDecorator taxDecorator = new TaxDecorator(baseBill, 0.0); // 0% tax
		String description = taxDecorator.getDescription();
		assertEquals("Base Bill, Tax @0.0%", description);
	}
}
