package com.dsa.leetcode.samples;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestSetMatrixZeroes {

	private SetMatrixZeroes smz;

	@BeforeEach
	void setUp() {
		smz = new SetMatrixZeroes();
	}

	private void assertMatrixEquals(int[][] expected, int[][] actual) {
		assertEquals(expected.length, actual.length, "Row count mismatch");
		for (int i = 0; i < expected.length; i++) {
			assertArrayEquals(expected[i], actual[i], "Mismatch at row " + i);
		}
	}

	@Test
	public void testExample1() {
		int[][] matrix = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
		int[][] expected = { { 1, 0, 1 }, { 0, 0, 0 }, { 1, 0, 1 } };
		smz.setZeroes(matrix);
		assertMatrixEquals(expected, matrix);
	}

	@Test
	public void testNoZero() {
		int[][] matrix = { { 1, 2 }, { 3, 4 } };
		int[][] expected = { { 1, 2 }, { 3, 4 } };
		smz.setZeroes(matrix);
		assertMatrixEquals(expected, matrix);
	}

	@Test
	public void testAllZero() {
		int[][] matrix = { { 0, 0 }, { 0, 0 } };
		int[][] expected = { { 0, 0 }, { 0, 0 } };
		smz.setZeroes(matrix);
		assertMatrixEquals(expected, matrix);
	}

	@Test
	public void testSingleElementZero() {
		int[][] matrix = { { 0 } };
		int[][] expected = { { 0 } };
		smz.setZeroes(matrix);
		assertMatrixEquals(expected, matrix);
	}

	@Test
	public void testSingleElementNonZero() {
		int[][] matrix = { { 1 } };
		int[][] expected = { { 1 } };
		smz.setZeroes(matrix);
		assertMatrixEquals(expected, matrix);
	}

}
