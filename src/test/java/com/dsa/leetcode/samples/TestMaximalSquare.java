package com.dsa.leetcode.samples;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestMaximalSquare {
	
	private MaximalSquare solver;
	
	@BeforeEach
	void setUp() {
		solver = new MaximalSquare();
	}

	@Test
	void testMaximalSquareCase1() {
		char[][] matrix = { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' }, { '1', '1', '1', '1', '1' },
				{ '1', '0', '0', '1', '0' } };
		assertEquals(4, solver.maximalSquare(matrix));
	}

	@Test
	void testMaximalSquareAllZeros() {
		char[][] matrix = { { '0', '0', '0' }, { '0', '0', '0' }, { '0', '0', '0' } };
		assertEquals(0, solver.maximalSquare(matrix));
	}

	@Test
	void testMaximalSquareAllOnes() {
		char[][] matrix = { { '1', '1', '1' }, { '1', '1', '1' }, { '1', '1', '1' } };
		assertEquals(9, solver.maximalSquare(matrix));
	}

	@Test
	void testMaximalSquareSingleRow() {
		char[][] matrix = { { '1', '1', '1', '1' } };
		assertEquals(1, solver.maximalSquare(matrix));
	}

	@Test
	void testMaximalSquareSingleColumn() {
		char[][] matrix = { { '1' }, { '1' }, { '1' }, { '1' } };
		assertEquals(1, solver.maximalSquare(matrix));
	}

}
