package com.dsa.leetcode.samples;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestFirstAndLastPositionElementArray {

	private FirstAndLastPositionElementArray obj;

	@BeforeEach
	void setUp() throws Exception {
		obj = new FirstAndLastPositionElementArray();
	}

	@Test
	public void testTargetPresentMultipleTimes() {
		int[] nums = { 5, 7, 7, 8, 8, 10 };
		int[] result = obj.searchRangeLogN(nums, 8);
		assertArrayEquals(new int[] { 3, 4 }, result);
	}

	@Test
	public void testTargetPresentOnce() {
		int[] nums = { 5, 7, 7, 8, 8, 10 };
		int[] result = obj.searchRangeLogN(nums, 10);
		assertArrayEquals(new int[] { 5, 5 }, result);
	}

	@Test
	public void testTargetNotPresent() {
		int[] nums = { 5, 7, 7, 8, 8, 10 };
		int[] result = obj.searchRangeLogN(nums, 6);
		assertArrayEquals(new int[] { -1, -1 }, result);
	}

	@Test
	public void testEmptyArray() {
		int[] nums = {};
		int[] result = obj.searchRangeLogN(nums, 8);
		assertArrayEquals(new int[] { -1, -1 }, result);
	}

	@Test
	public void testSingleElementMatch() {
		int[] nums = { 8 };
		int[] result = obj.searchRangeLogN(nums, 8);
		assertArrayEquals(new int[] { 0, 0 }, result);
	}

	@Test
	public void testSingleElementNoMatch() {
		int[] nums = { 5 };
		int[] result = obj.searchRangeLogN(nums, 8);
		assertArrayEquals(new int[] { -1, -1 }, result);
	}

	@Test
	public void testAllElementsAreTarget() {
		int[] nums = { 2, 2, 2, 2, 2 };
		int[] result = obj.searchRangeLogN(nums, 2);
		assertArrayEquals(new int[] { 0, 4 }, result);
	}

	@Test
	public void testTargetAtEdges() {
		int[] nums = { 2, 3, 4, 5, 6, 7, 8 };
		assertArrayEquals(new int[] { 0, 0 }, obj.searchRangeLogN(nums, 2));
		assertArrayEquals(new int[] { 6, 6 }, obj.searchRangeLogN(nums, 8));
	}

}
