package com.dsa.leetcode.samples;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestPlusOne {

	private PlusOne plusOne;

	@BeforeEach
	void setUp() throws Exception {
		plusOne = new PlusOne();
	}

	@Test
	void plusOneSingleDigit() {
		int[] digits = { 5 };
		assertArrayEquals(new int[] { 6 }, plusOne.plusOne(digits));
	}

	@Test
	void plusOneMultipleDigitsNoCarry() {
		int[] digits = { 1, 2, 3 };
		assertArrayEquals(new int[] { 1, 2, 4 }, plusOne.plusOne(digits));
	}

	@Test
	void plusOneMultipleDigitsWithCarry() {
		int[] digits = { 1, 2, 9 };
		assertArrayEquals(new int[] { 1, 3, 0 }, plusOne.plusOne(digits));
	}

	@Test
	void plusOneAllNines() {
		int[] digits = { 9, 9, 9 };
		assertArrayEquals(new int[] { 1, 0, 0, 0 }, plusOne.plusOne(digits));
	}

	@Test
	void plusOneEmptyArray() {
		int[] digits = {};
		assertArrayEquals(new int[] { 1 }, plusOne.plusOne(digits));
	}

	@Test
	void plusOneLeadingZeros() {
		int[] digits = { 0, 0, 1 };
		assertArrayEquals(new int[] { 0, 0, 2 }, plusOne.plusOne(digits));
	}

	@Test
	void plusOneSingleZero() {
		int[] digits = { 0 };
		assertArrayEquals(new int[] { 1 }, plusOne.plusOne(digits));
	}

}
