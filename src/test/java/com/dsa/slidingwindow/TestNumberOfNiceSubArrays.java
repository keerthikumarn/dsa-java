package com.dsa.slidingwindow;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.dsa.slidingiwindow.NumberOfNiceSubArrays;

class TestNumberOfNiceSubArrays {

	private NumberOfNiceSubArrays obj;

	@BeforeEach
	void setUp() {
		obj = new NumberOfNiceSubArrays();
	}

	@Test
	void testBasicCase() {
		assertEquals(2, obj.numberOfSubarrays(new int[] { 1, 1, 2, 1, 1 }, 3));
	}

	@Test
	void testNoOddNumbers() {
		assertEquals(0, obj.numberOfSubarrays(new int[] { 2, 4, 6 }, 1));
	}

	@Test
	void testMixedNumbers() {
		assertEquals(16, obj.numberOfSubarrays(new int[] { 2, 2, 2, 1, 2, 2, 1, 2, 2, 2 }, 2));
	}

	@Test
	void testSingleElementOdd() {
		assertEquals(1, obj.numberOfSubarrays(new int[] { 1 }, 1));
	}

	@Test
	void testSingleElementEven() {
		assertEquals(0, obj.numberOfSubarrays(new int[] { 2 }, 1));
	}

	@Test
	void testEmptyArray() {
		assertEquals(0, obj.numberOfSubarrays(new int[] {}, 1));
	}

}
