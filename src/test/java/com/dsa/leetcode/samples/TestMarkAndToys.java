package com.dsa.leetcode.samples;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.dsa.graph.demo.MarkAndToys;

class TestMarkAndToys {

	private MarkAndToys markAndToys;

	@BeforeEach
	void setUp() throws Exception {
		markAndToys = new MarkAndToys();
	}

	@Test
	void returnsMaximumToysWhenBudgetIsSufficient() {
		int[] prices = { 1, 12, 5, 111, 200, 1000, 10 };
		int result = markAndToys.maximumToys(prices, 50);
		assertEquals(4, result);
	}

	@Test
	void returnsZeroWhenBudgetIsZero() {
		int[] prices = { 1, 12, 5, 111, 200, 1000, 10 };
		int result = markAndToys.maximumToys(prices, 0);
		assertEquals(0, result);
	}

	@Test
	void returnsZeroWhenPricesArrayIsEmpty() {
		int[] prices = {};
		int result = markAndToys.maximumToys(prices, 50);
		assertEquals(0, result);
	}

	@Test
	void returnsZeroWhenAllToysAreTooExpensive() {
		int[] prices = { 100, 200, 300 };
		int result = markAndToys.maximumToys(prices, 50);
		assertEquals(0, result);
	}

	@Test
	void returnsAllToysWhenBudgetIsMoreThanTotalPrices() {
		int[] prices = { 1, 2, 3, 4 };
		int result = markAndToys.maximumToys(prices, 20);
		assertEquals(4, result);
	}

	@Test
	void handlesSingleToyWithinBudget() {
		int[] prices = { 10 };
		int result = markAndToys.maximumToys(prices, 15);
		assertEquals(1, result);
	}

	@Test
	void handlesSingleToyExceedingBudget() {
		int[] prices = { 10 };
		int result = markAndToys.maximumToys(prices, 5);
		assertEquals(0, result);
	}

}
