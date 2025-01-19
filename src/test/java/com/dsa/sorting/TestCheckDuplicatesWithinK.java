package com.dsa.sorting;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestCheckDuplicatesWithinK {

	private final CheckDuplicatesWithinK checker = new CheckDuplicatesWithinK();

	@Test
	void testNoDuplicates() {
		int[] arr = { 1, 2, 3, 4, 5 };
		int k = 3;
		assertFalse(checker.checkDuplicatesWithinK(arr, k),
				"Should return false when there are no duplicates within k distance.");
	}

	@Test
	void testDuplicatesWithinK() {
		int[] arr = { 1, 2, 3, 1 };
		int k = 3;
		assertTrue(checker.checkDuplicatesWithinK(arr, k), "Should return true for duplicates within k distance.");
	}

	@Test
	void testDuplicatesOutsideK() {
		int[] arr = { 1, 2, 3, 1 };
		int k = 2;
		assertFalse(checker.checkDuplicatesWithinK(arr, k), "Should return false for duplicates outside k distance.");
	}

	@Test
	void testEmptyArray() {
		int[] arr = {};
		int k = 1;
		assertFalse(checker.checkDuplicatesWithinK(arr, k), "Should return false for an empty array.");
	}

	@Test
	void testSingleElementArray() {
		int[] arr = { 1 };
		int k = 1;
		assertFalse(checker.checkDuplicatesWithinK(arr, k), "Should return false for an array with a single element.");
	}

	@Test
	void testLargeK() {
		int[] arr = { 1, 2, 3, 4, 1 };
		int k = 10;
		assertTrue(checker.checkDuplicatesWithinK(arr, k),
				"Should return true when k is larger than the array length and duplicates exist.");
	}

	@Test
	void testKEqualsZero() {
		int[] arr = { 1, 2, 3, 1 };
		int k = 0;
		assertFalse(checker.checkDuplicatesWithinK(arr, k), "Should return false when k is zero.");
	}

	@Test
	void testAllElementsSame() {
		int[] arr = { 1, 1, 1, 1 };
		int k = 1;
		assertTrue(checker.checkDuplicatesWithinK(arr, k),
				"Should return true when all elements are the same and k > 0.");
	}
}
