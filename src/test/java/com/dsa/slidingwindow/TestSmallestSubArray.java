package com.dsa.slidingwindow;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.dsa.slidingiwindow.SmallestSubArray;

class TestSmallestSubArray {

	private SmallestSubArray subArray;

	@BeforeEach
	public void setUp() {
		subArray = new SmallestSubArray();
	}

	@Test
	public void testSimpleCase() {
		int[] arr = { 1, 4, 45, 6, 10, 19 };
		int x = 51;
		assertEquals(3, subArray.smallestSubArrayWithSum(arr, x));
	}

	@Test
	public void testWholeArrayNeeded() {
		int[] arr = { 1, 10, 5, 2, 7 };
		int x = 24;
		assertEquals(5, subArray.smallestSubArrayWithSum(arr, x));
	}

	@Test
	public void testSingleElementGreaterThanX() {
		int[] arr = { 1, 4, 6, 10, 15 };
		int x = 5;
		assertEquals(6, subArray.smallestSubArrayWithSum(arr, x));
	}

	@Test
	public void testNoSubarrayGreaterThanX() {
		int[] arr = { 1, 1, 1, 1 };
		int x = 10;
		// Method returns len + 1 if no subarray found
		assertEquals(5, subArray.smallestSubArrayWithSum(arr, x));
	}

	@Test
	public void testExactMatch() {
		int[] arr = { 2, 3, 1, 2, 4, 3 };
		int x = 7;
		assertEquals(3, subArray.smallestSubArrayWithSum(arr, x)); // [4, 3] is smallest
	}

	@Test
	public void testEmptyArray() {
		int[] arr = {};
		int x = 5;
		assertEquals(1, subArray.smallestSubArrayWithSum(arr, x)); // len + 1 = 0 + 1 = 1
	}

	@Test
	public void testSingleElementArrayLessThanX() {
		int[] arr = { 2 };
		int x = 3;
		assertEquals(2, subArray.smallestSubArrayWithSum(arr, x)); // no valid subarray
	}

	@Test
	public void testSingleElementArrayGreaterThanX() {
		int[] arr = { 10 };
		int x = 5;
		assertEquals(10, subArray.smallestSubArrayWithSum(arr, x));
	}

}