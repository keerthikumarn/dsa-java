package com.dsa.leetcode.samples;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestPartitionEqualSubsetSum {

	private PartitionEqualSubsetSum solution;

	@BeforeEach
	void setUp() {
		solution = new PartitionEqualSubsetSum();
	}

	@Test
	public void testExample1() {
		int[] nums = { 1, 5, 11, 5 };
		assertTrue(solution.canPartition(nums));
	}

	@Test
	public void testExample2() {
		int[] nums = { 1, 2, 3, 5 };
		assertFalse(solution.canPartition(nums));
	}

	@Test
	public void testSingleElement() {
		int[] nums = { 2 };
		assertFalse(solution.canPartition(nums));
	}

	@Test
	public void testAllSameElements() {
		int[] nums = { 2, 2, 2, 2 };
		assertTrue(solution.canPartition(nums));
	}

	@Test
	public void testLargeInput() {
		int[] nums = new int[100];
		for (int i = 0; i < 100; i++) {
			nums[i] = 1;
		}
		assertTrue(solution.canPartition(nums));
	}

}
