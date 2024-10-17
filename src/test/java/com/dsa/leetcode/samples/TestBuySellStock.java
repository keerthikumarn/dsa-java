package com.dsa.leetcode.samples;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestBuySellStock {

	private final BuySellStocks stocks = new BuySellStocks();

	@Test
	public void testForMaximumProfit() {
		assertEquals(7, stocks.maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));
		assertEquals(4, stocks.maxProfit(new int[] { 1, 2, 3, 4, 5 }));
	}

}
