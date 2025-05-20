package com.dsa.leetcode.samples;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestKthSmallestElementInArray {

	private KthSmallestElementInArray finder = null;
	
	@BeforeEach
	void setUp() {
		finder = new KthSmallestElementInArray();
	}

	// ----------- Tests for kthSmallest (using Arrays.sort) -----------

	@Test
	public void testKthSmallest_Sorting_Basic() {
		Integer[] arr = { 12, 3, 5, 7, 19 };
		assertEquals(7, finder.kthSmallest(arr, 3));
	}

	@Test
	public void testKthSmallest_Sorting_KEquals1() {
		Integer[] arr = { 4, 2, 6, 1, 9 };
		assertEquals(1, finder.kthSmallest(arr, 1));
	}

	@Test
	public void testKthSmallest_Sorting_LastElement() {
		Integer[] arr = { 8, 6, 7, 5, 9 };
		assertEquals(9, finder.kthSmallest(arr, 5));
	}

	// ----------- Tests for kthSmallestWithPQ (using PriorityQueue) -----------

	@Test
	public void testKthSmallest_PQ_Basic() {
		Integer[] arr = { 12, 3, 5, 7, 19 };
		assertEquals(7, finder.kthSmallestWithPQ(arr, 3));
	}

	@Test
	public void testKthSmallest_PQ_KEquals1() {
		Integer[] arr = { 4, 2, 6, 1, 9 };
		assertEquals(1, finder.kthSmallestWithPQ(arr, 1));
	}

	@Test
	public void testKthSmallest_PQ_LastElement() {
		Integer[] arr = { 8, 6, 7, 5, 9 };
		assertEquals(9, finder.kthSmallestWithPQ(arr, 5));
	}

	// ----------- Edge Cases -----------

	@Test
	public void testKthSmallest_Duplicates() {
		Integer[] arr = { 4, 2, 4, 1, 4 };
		assertEquals(4, finder.kthSmallest(arr, 3));
		assertEquals(4, finder.kthSmallestWithPQ(arr, 3));
	}

	@Test
	public void testKthSmallest_SingleElement() {
		Integer[] arr = { 10 };
		assertEquals(10, finder.kthSmallest(arr, 1));
		assertEquals(10, finder.kthSmallestWithPQ(arr, 1));
	}

	@Test
	public void testKthSmallest_InvalidK() {
		Integer[] arr = { 1, 2, 3 };
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> finder.kthSmallest(arr, 0));
		assertThrows(NullPointerException.class, () -> finder.kthSmallestWithPQ(null, 2)); // Optional: handle null case
																							// explicitly in your code
	}

}
