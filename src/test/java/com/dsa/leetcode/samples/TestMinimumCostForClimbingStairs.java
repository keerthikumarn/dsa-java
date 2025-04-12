package com.dsa.leetcode.samples;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestMinimumCostForClimbingStairs {

	private MinimumCostForClimbingStairs minCost;

	@BeforeEach
	void setUp() {
		minCost = new MinimumCostForClimbingStairs();
	}

	@Test
	void testEmptyArray() {
		int[] cost = {};
		assertEquals(0, minCost.minCostClimbingStairs(cost));
	}

	@Test
	void testSingleStep() {
		int[] cost = { 10 };
		assertEquals(10, minCost.minCostClimbingStairs(cost));
	}

	@Test
	void testSimpleCase() {
		int[] cost = { 10, 15, 20 };
		assertEquals(15, minCost.minCostClimbingStairs(cost));
	}

	@Test
	void testAnotherSimpleCase() {
		int[] cost = { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 };
		assertEquals(6, minCost.minCostClimbingStairs(cost));
	}

	@Test
	void testTwoSteps() {
		int[] cost = { 5, 10 };
		assertEquals(5, minCost.minCostClimbingStairs(cost));
	}

	@Test
	void testAllZeroCost() {
		int[] cost = { 0, 0, 0, 0 };
		assertEquals(0, minCost.minCostClimbingStairs(cost));
	}

	@Test
	void testIncreasingCosts() {
		int[] cost = { 1, 2, 3, 4, 5 };
		assertEquals(6, minCost.minCostClimbingStairs(cost));
	}

	@Test
	void testLargeInput() {
		int[] cost = new int[1000];
		for (int i = 0; i < cost.length; i++) {
			cost[i] = 1;
		}
		assertEquals(500, minCost.minCostClimbingStairs(cost));
	}
}
