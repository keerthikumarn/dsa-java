package com.dsa.leetcode.samples;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestJumpGame {

	private JumpGame jumpGame = null;

	@BeforeEach
	void setUp() {
		jumpGame = new JumpGame();
	}

	@Test
	public void testCanJumpReachable() {
		int[] nums = { 2, 3, 1, 1, 4 };
		assertTrue(jumpGame.canJump(nums), "Should be able to reach the end");
	}

	@Test
	public void testCanJumpSingleElement() {
		int[] nums = { 0 };
		assertTrue(jumpGame.canJump(nums), "Single element (0) should return true");
	}

	@Test
	public void testCanJumpUnreachable() {
		int[] nums = { 3, 2, 1, 0, 4 };
		assertFalse(jumpGame.canJump(nums), "Cannot reach the last index");
	}

	@Test
	public void testCanJumpAllZeros() {
		int[] nums = { 0, 0, 0 };
		assertFalse(jumpGame.canJump(nums), "All zeros except first will return false");
	}

	@Test
	public void testCanJumpLargeInitialJump() {
		int[] nums = { 5, 0, 0, 0, 0, 1 };
		assertTrue(jumpGame.canJump(nums), "Initial large jump can skip zeros");
	}

	@Test
	public void testJumpMultipleJumps() {
		int[] nums = { 2, 3, 1, 1, 4 };
		assertEquals(2, jumpGame.jump(nums), "Should require 2 jumps");
	}

	@Test
	public void testJumpSingleElement() {
		int[] nums = { 0 };
		assertEquals(0, jumpGame.jump(nums), "Single element requires 0 jumps");
	}

	@Test
	public void testJumpDescendingJumpLengths() {
		int[] nums = { 3, 4, 3, 2, 5, 4, 3 };
		assertEquals(3, jumpGame.jump(nums), "Should require 2 jumps");
	}

	@Test
	public void testJumpLongListDecreasing() {
		int[] nums = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 1, 0 };
		assertEquals(2, jumpGame.jump(nums), "Should require 1 jump with large initial value");
	}

	@Test
	public void testJumpZeroStart() {
		int[] nums = { 0, 1, 2 };
		assertEquals(0, jumpGame.jump(nums), "Zero at start means cannot jump");
	}

}
