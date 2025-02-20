package com.dsa.leetcode.samples;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestFindUniqueElementInAnArray {

	private FindUniqueElementInAnArray obj;

	@BeforeEach
	void setUp() {
		obj = new FindUniqueElementInAnArray();
	}

	@Test
	void returnsUniqueElementInArrayWithOneUnique() {
		int[] arr = { 2, 2, 1 };
		assertEquals(1, obj.findUniqueElement(arr));
	}

	@Test
	void returnsUniqueElementInArrayWithMultipleElements() {
		int[] arr = { 3, 1, 2, 1, 2 };
		assertEquals(4, obj.findUniqueElement(arr));
	}

	@Test
	void returnsUniqueElementInArrayWithNegativeNumbers() {
		int[] arr = { -1, -1, -2 };
		assertEquals(-2, obj.findUniqueElement(arr));
	}

	@Test
	void returnsUniqueElementInArrayWithAllElementsSame() {
		int[] arr = { 3, 3, 3 };
		assertEquals(3, obj.findUniqueElement(arr));
	}

	@Test
	void returnsZeroForEmptyArray() {
		int[] arr = {};
		assertEquals(0, obj.findUniqueElement(arr));
	}

}
