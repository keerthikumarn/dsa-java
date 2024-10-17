package com.dsa.leetcode.samples;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestClimbStairs {

	private final ClimbStairs climbStairs = new ClimbStairs();

	@Test
	void testClimbStairs() {
		assertEquals(2, climbStairs.climbStairs(2));
		assertEquals(3, climbStairs.climbStairs(3));
		assertEquals(8, climbStairs.climbStairs(5));
	}

}
