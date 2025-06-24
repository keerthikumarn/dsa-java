package com.dsa.leetcode.samples;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestCoinChange {

	private CoinChange solution;

	@BeforeEach
	void setUp() {
		solution = new CoinChange();
	}

	@Test
	public void testExample1() {
		int[] coins = { 1, 2, 5 };
		int amount = 11;
		assertEquals(3, solution.coinChange(coins, amount)); // 5 + 5 + 1
	}

	@Test
	public void testExample2() {
		int[] coins = { 2 };
		int amount = 3;
		assertEquals(-1, solution.coinChange(coins, amount)); // Can't make 3 with only 2s
	}

	@Test
	public void testExample3() {
		int[] coins = { 1 };
		int amount = 0;
		assertEquals(0, solution.coinChange(coins, amount)); // No coins needed
	}

	@Test
	public void testSingleCoin() {
		int[] coins = { 5 };
		int amount = 10;
		assertEquals(2, solution.coinChange(coins, amount)); // 5 + 5
	}

	@Test
	public void testLargeAmount() {
		int[] coins = { 1, 2, 5 };
		int amount = 100;
		assertEquals(20, solution.coinChange(coins, amount)); // Best is 20 x 5
	}

}
