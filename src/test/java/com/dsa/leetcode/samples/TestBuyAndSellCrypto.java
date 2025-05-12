package com.dsa.leetcode.samples;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestBuyAndSellCrypto {

	private BuyAndSellCrypto buyAndSell;

	@BeforeEach
	void setUp() throws Exception {
		buyAndSell = new BuyAndSellCrypto();
	}

	@Test
	public void testIncreasingPrices() {
		int[] prices = { 1, 2, 3, 4, 5 };
		assertEquals(4, buyAndSell.maxProfit(prices)); // Buy at 1, sell at 5
	}

	@Test
	public void testDecreasingPrices() {
		int[] prices = { 5, 4, 3, 2, 1 };
		assertEquals(0, buyAndSell.maxProfit(prices)); // No profit possible
	}

	@Test
	public void testMixedPrices() {
		int[] prices = { 7, 1, 5, 3, 6, 4 };
		assertEquals(5, buyAndSell.maxProfit(prices)); // Buy at 1, sell at 6
	}

	@Test
	public void testSingleDay() {
		int[] prices = { 5 };
		assertEquals(0, buyAndSell.maxProfit(prices)); // Not enough data to buy/sell
	}

	@Test
	public void testTwoDaysProfit() {
		int[] prices = { 2, 10 };
		assertEquals(8, buyAndSell.maxProfit(prices)); // Buy at 2, sell at 10
	}

	@Test
	public void testTwoDaysLoss() {
		int[] prices = { 10, 2 };
		assertEquals(0, buyAndSell.maxProfit(prices)); // Loss scenario, no transaction
	}

	@Test
	public void testSamePrices() {
		int[] prices = { 3, 3, 3, 3 };
		assertEquals(0, buyAndSell.maxProfit(prices)); // No opportunity for profit
	}

	@Test
	public void testProfitAtEnd() {
		int[] prices = { 9, 7, 1, 3, 6, 4 };
		assertEquals(5, buyAndSell.maxProfit(prices)); // Buy at 1, sell at 6
	}

	@Test
	public void testEmptyArray() {
		int[] prices = {};
		assertEquals(0, buyAndSell.maxProfit(prices)); // No data
	}

}
