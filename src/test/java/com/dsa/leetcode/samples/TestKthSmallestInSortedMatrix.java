package com.dsa.leetcode.samples;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestKthSmallestInSortedMatrix {

	private KthSmallestInSortedMatrix solution;

	@BeforeEach
	void setUp() {
		solution = new KthSmallestInSortedMatrix();
	}

	@Test
	void testExampleMatrix() {
		int[][] matrix = { { 1, 5, 9 }, { 10, 11, 13 }, { 12, 13, 15 } };
		assertEquals(13, solution.kthSmallest(matrix, 8)); // 8th smallest is 13
	}

	@Test
	void testKIsOne() {
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		assertEquals(1, solution.kthSmallest(matrix, 1));
	}

	@Test
	void testKIsLast() {
		int[][] matrix = { { 1, 2 }, { 3, 4 } };
		assertEquals(4, solution.kthSmallest(matrix, 4));
	}

	@Test
	void testDuplicateValues() {
		int[][] matrix = { { 1, 2 }, { 2, 3 } };
		assertEquals(2, solution.kthSmallest(matrix, 2)); // 2nd smallest is 2
	}

	@Test
	void testSingleElementMatrix() {
		int[][] matrix = { { 42 } };
		assertEquals(42, solution.kthSmallest(matrix, 1));
	}

	@Test
	void testLargerMatrix() {
		int[][] matrix = { { 1, 2, 3, 4 }, { 2, 3, 4, 5 }, { 3, 4, 5, 6 }, { 4, 5, 6, 7 } };
		assertEquals(5, solution.kthSmallest(matrix, 10)); // Manually confirmed
	}
}
