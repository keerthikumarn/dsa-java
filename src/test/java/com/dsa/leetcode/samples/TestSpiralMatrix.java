package com.dsa.leetcode.samples;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestSpiralMatrix {

	private SpiralMatrix solution;

	@BeforeEach
	void setUp() {
		solution = new SpiralMatrix();
	}

	@Test
	public void testSpiralOrder1() {
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		assertEquals(List.of(1, 2, 3, 6, 9, 8, 7, 4, 5), solution.spiralOrder(matrix));
	}

	@Test
	public void testSpiralOrder2() {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		assertEquals(List.of(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7), solution.spiralOrder(matrix));
	}

	@Test
	public void testSingleElement() {
		int[][] matrix = { { 1 } };
		assertEquals(List.of(1), solution.spiralOrder(matrix));
	}

	@Test
	public void testEmptyMatrix() {
		int[][] matrix = {};
		assertEquals(List.of(), solution.spiralOrder(matrix));
	}
}
