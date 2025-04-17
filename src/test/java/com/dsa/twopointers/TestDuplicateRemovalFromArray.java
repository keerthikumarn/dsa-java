package com.dsa.twopointers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestDuplicateRemovalFromArray {

	private DuplicateRemovalFromArray array;

	@BeforeEach
	void setUp() throws Exception {
		array = new DuplicateRemovalFromArray();
	}

	@Test
	public void testRemoveDuplicatesNullArray() {
		int[] input = null;
		int newLength = array.removeDuplicates(input);
		assertEquals(-1, newLength);
	}

	@Test
	public void testRemoveDuplicatesNormalCase() {
		int[] input = { 1, 1, 2, 2, 3, 4, 4, 5 };
		int newLength = array.removeDuplicates(input);
		assertEquals(5, newLength);
		int[] expected = { 1, 2, 3, 4, 5 };
		for (int i = 0; i < newLength; i++) {
			assertEquals(expected[i], input[i]);
		}
	}

	@Test
	public void testRemoveDuplicatesAllUnique() {
		int[] input = { 1, 2, 3, 4, 5 };
		int newLength = array.removeDuplicates(input);
		assertEquals(5, newLength);
		for (int i = 0; i < newLength; i++) {
			assertEquals(i + 1, input[i]);
		}
	}

	@Test
	public void testRemoveDuplicatesAllSame() {
		int[] input = { 7, 7, 7, 7 };
		int newLength = array.removeDuplicates(input);
		assertEquals(1, newLength);
		assertEquals(7, input[0]);
	}

	@Test
	public void testRemoveDuplicatesEmptyArray() {
		int[] input = {};
		int newLength = array.removeDuplicates(input);
		assertEquals(-1, newLength);
	}

}
