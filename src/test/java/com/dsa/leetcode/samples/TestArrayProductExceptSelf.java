package com.dsa.leetcode.samples;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestArrayProductExceptSelf {

	private ArrayProductExceptSelf arrayProductExceptSelf;

	@BeforeEach
	void setUp() {
		arrayProductExceptSelf = new ArrayProductExceptSelf();
	}

	@Test
	public void testBasicInput() {
		int[] input = { 1, 2, 4, 6 };
		int[] expected = { 48, 24, 12, 8 };
		assertArrayEquals(expected, arrayProductExceptSelf.productExceptSelf(input));
	}

	@Test
	public void testSingleElement() {
		int[] input = { 5 };
		int[] expected = { 1 }; // Conventionally, return 1 for single element
		assertArrayEquals(expected, arrayProductExceptSelf.productExceptSelf(input));
	}

	@Test
	public void testWithZero() {
		int[] input = { 1, 2, 0, 4 };
		int[] expected = { 0, 0, 8, 0 }; // Only one zero in array
		assertArrayEquals(expected, arrayProductExceptSelf.productExceptSelf(input));
	}

	@Test
	public void testWithTwoZeros() {
		int[] input = { 0, 2, 0, 4 };
		int[] expected = { 0, 0, 0, 0 }; // More than one zero leads to all zeros
		assertArrayEquals(expected, arrayProductExceptSelf.productExceptSelf(input));
	}

	@Test
	public void testWithNegatives() {
		int[] input = { -1, 2, -3, 4 };
		int[] expected = { -24, 12, -8, 6 };
		assertArrayEquals(expected, arrayProductExceptSelf.productExceptSelf(input));
	}

	@Test
	public void testAllOnes() {
		int[] input = { 1, 1, 1, 1 };
		int[] expected = { 1, 1, 1, 1 };
		assertArrayEquals(expected, arrayProductExceptSelf.productExceptSelf(input));
	}

	@Test
	public void testEmptyArray() {
		int[] input = {};
		int[] expected = {};
		assertArrayEquals(expected, arrayProductExceptSelf.productExceptSelf(input));
	}

}
