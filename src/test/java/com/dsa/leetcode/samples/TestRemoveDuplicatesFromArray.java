package com.dsa.leetcode.samples;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestRemoveDuplicatesFromArray {

	private RemoveDuplicatesFromArray duplicateRemover;

	@BeforeEach
	void setUp() {
		duplicateRemover = new RemoveDuplicatesFromArray();
	}

	@Test
	void testRemoveDuplicatesWithDuplicates() {
		int[] nums = { 1, 1, 2, 2, 3, 3, 4 };
		int expectedLength = 4;
		int resultLength = duplicateRemover.removeDuplicates(nums);
		assertEquals(expectedLength, resultLength);
		int[] expectedNums = { 1, 2, 3, 4 };
		for (int i = 0; i < expectedLength; i++) {
			assertEquals(expectedNums[i], nums[i]);
		}
	}

	@Test
	void testRemoveDuplicatesNoDuplicates() {
		int[] nums = { 1, 2, 3, 4, 5 };
		int expectedLength = 5;
		int resultLength = duplicateRemover.removeDuplicates(nums);
		assertEquals(expectedLength, resultLength);
		int[] expectedNums = { 1, 2, 3, 4, 5 };
		for (int i = 0; i < expectedLength; i++) {
			assertEquals(expectedNums[i], nums[i]);
		}
	}

	@Test
	void testRemoveDuplicatesEmptyArray() {
		int[] nums = {};
		int expectedLength = 0;
		int resultLength = duplicateRemover.removeDuplicates(nums);
		assertEquals(expectedLength, resultLength);
	}

	@Test
	void testRemoveDuplicatesSingleElementArray() {
		int[] nums = { 1 };
		int expectedLength = 1;
		int resultLength = duplicateRemover.removeDuplicates(nums);
		assertEquals(expectedLength, resultLength);
		assertEquals(1, nums[0]);
	}

}
