package com.dsa.leetcode.samples;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestFirstMissingPositive {

	private FirstMissingPositive solution;

	@BeforeEach
	void setUp() {
		solution = new FirstMissingPositive();
	}

	@Test
	public void testExample1() {
		assertEquals(2, solution.firstMissingPositive(new int[] { 1, 1 }));
	}

	@Test
	public void testExample2() {
		assertEquals(3, solution.firstMissingPositive(new int[] { 1, 2, 0 }));
	}

	@Test
	public void testExample3() {
		FirstMissingPositive solver = new FirstMissingPositive();
		assertEquals(2, solver.firstMissingPositive(new int[] { 3, 4, -1, 1 }));
	}

	@Test
	public void testExample4() {
		FirstMissingPositive solver = new FirstMissingPositive();
		assertEquals(1, solver.firstMissingPositive(new int[] { 7, 8, 9, 11, 12 }));
	}

	@Test
	public void testEmptyArray() {
		FirstMissingPositive solver = new FirstMissingPositive();
		assertEquals(1, solver.firstMissingPositive(new int[] {}));
	}

}
