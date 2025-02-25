package com.dsa.leetcode.samples;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestViralAdvertising {

	private ViralAdvertising va;

	@BeforeEach
	void setUp() {
		va = new ViralAdvertising();
	}

	@Test
	void viralAdvertisingSingleDay() {
		assertEquals(2, va.viralAdvertising(1));
	}

	@Test
	void viralAdvertisingMultipleDays() {
		assertEquals(9, va.viralAdvertising(3));
	}

	@Test
	void viralAdvertisingFiveDays() {
		assertEquals(24, va.viralAdvertising(5));
	}

	@Test
	void viralAdvertisingZeroDays() {
		assertEquals(0, va.viralAdvertising(0));
	}

	@Test
	void viralAdvertisingLargeNumberOfDays() {
		assertEquals(189, va.viralAdvertising(10));
	}

}
