package com.dsa.leetcode.samples;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestHouseRobbery2 {

	private HouseRobbery2 robber;

	@BeforeEach
	void setUp() {
		robber = new HouseRobbery2();
	}

	@Test
	public void testExample1() {
		int[] nums = { 2, 3, 2 };
		assertEquals(3, robber.rob(nums)); // Rob house 1 (3), skip 0 and 2
	}

	@Test
	public void testExample2() {
		int[] nums = { 1, 2, 3, 1 };
		assertEquals(4, robber.rob(nums)); // Rob 1 + 3
	}

	@Test
	public void testAllSame() {
		int[] nums = { 1, 1, 1, 1 };
		assertEquals(2, robber.rob(nums)); // Rob 0 + 2 or 1 + 3
	}

	@Test
	public void testSingleHouse() {
		assertEquals(5, robber.rob(new int[] { 5 }));
	}

	@Test
	public void testTwoHouses() {
		assertEquals(9, robber.rob(new int[] { 9, 1 }));
	}

	@Test
	public void testLargeValues() {
		int[] nums = { 100, 1, 1, 100 };
		assertEquals(101, robber.rob(nums));
	}

	@Test
	public void testEmpty() {
		assertEquals(0, robber.rob(new int[] {}));
	}

}
