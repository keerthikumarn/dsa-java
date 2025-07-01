package com.dsa.leetcode.samples;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestMaxStock {

	private MaxStock maxStock;

	@BeforeEach
	void setUp() throws Exception {
		maxStock = new MaxStock();
	}

	@Test
	public void testIncreasingPrices() {
		List<Integer> prices = Arrays.asList(1, 2, 3, 4);
		long expected = 6; // Buy on day 0, 1, 2 and sell all on day 3
		assertEquals(expected, maxStock.stockmax(prices));
	}

	@Test
	public void testDecreasingPrices() {
		List<Integer> prices = Arrays.asList(5, 4, 3, 2, 1);
		long expected = 0; // No profitable selling point
		assertEquals(expected, maxStock.stockmax(prices));
	}

	@Test
	public void testPeakAtEnd() {
		List<Integer> prices = Arrays.asList(1, 2, 100);
		long expected = 197; // Buy on day 0,1; Sell both on day 2
		assertEquals(expected, maxStock.stockmax(prices));
	}

	@Test
	public void testSingleDay() {
		List<Integer> prices = Collections.singletonList(10);
		long expected = 0; // Cannot sell
		assertEquals(expected, maxStock.stockmax(prices));
	}

	@Test
	public void testMixedPrices() {
		List<Integer> prices = Arrays.asList(3, 5, 1, 7, 4, 9);
		long expected = 25; // Buy on day 0, 2, 4; sell on day 1, 3, 5
		assertEquals(expected, maxStock.stockmax(prices));
	}

	@Test
	public void testEmptyList() {
		List<Integer> prices = Collections.emptyList();
		long expected = 0;
		assertEquals(expected, maxStock.stockmax(prices));
	}

}
