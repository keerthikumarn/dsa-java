package com.dsa.leetcode.samples;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestBinarySearchDemo {

	private BinarySearchDemo binarySearch;

	@BeforeEach
	public void setUp() {
		binarySearch = new BinarySearchDemo();
	}

	@Test
	public void testFoundInMiddle() {
		int[] nums = { -1, 0, 3, 5, 9, 12 };
		int target = 9;
		assertEquals(4, binarySearch.search(nums, target));
	}

	@Test
	public void testNotFound() {
		int[] nums = { -1, 0, 3, 5, 9, 12 };
		int target = 2;
		assertEquals(-1, binarySearch.search(nums, target));
	}

	@Test
	public void testFoundAtStart() {
		int[] nums = { 1, 2, 3, 4, 5 };
		int target = 1;
		assertEquals(0, binarySearch.search(nums, target));
	}

	@Test
	public void testFoundAtEnd() {
		int[] nums = { 1, 2, 3, 4, 5 };
		int target = 5;
		assertEquals(4, binarySearch.search(nums, target));
	}

	@Test
	public void testEmptyArray() {
		int[] nums = {};
		int target = 1;
		assertEquals(-1, binarySearch.search(nums, target));
	}

	@Test
	public void testSingleElementFound() {
		int[] nums = { 10 };
		int target = 10;
		assertEquals(0, binarySearch.search(nums, target));
	}

	@Test
	public void testSingleElementNotFound() {
		int[] nums = { 10 };
		int target = 5;
		assertEquals(-1, binarySearch.search(nums, target));
	}

}
