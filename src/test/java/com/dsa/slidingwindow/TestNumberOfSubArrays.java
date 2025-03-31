package com.dsa.slidingwindow;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.dsa.slidingiwindow.NumberOfSubArrays;

class TestNumberOfSubArrays {

	private NumberOfSubArrays numberOfSubArrays;

	@BeforeEach
	void setUp() {
		numberOfSubArrays = new NumberOfSubArrays();
	}

	@Test
	public void testNumOfSubarrays() {
		// Test case 1: General case
		assertEquals(3, numberOfSubArrays.numOfSubarrays(new int[] { 2, 2, 2, 2, 5, 5, 5, 8 }, 3, 4));

		// Test case 2: All elements are below the threshold
		assertEquals(0, numberOfSubArrays.numOfSubarrays(new int[] { 1, 1, 1, 1, 1 }, 2, 3));

		// Test case 3: All elements are above the threshold
		assertEquals(4, numberOfSubArrays.numOfSubarrays(new int[] { 5, 5, 5, 5, 5 }, 2, 4));

		// Test case 4: Single element subarrays
		assertEquals(3, numberOfSubArrays.numOfSubarrays(new int[] { 1, 2, 3, 4, 5 }, 1, 3));

		// Test case 5: Minimum input size
		assertEquals(1, numberOfSubArrays.numOfSubarrays(new int[] { 4 }, 1, 4));
		assertEquals(0, numberOfSubArrays.numOfSubarrays(new int[] { 3 }, 1, 4));

		// Test case 6: Large k value (covering almost the entire array)
		assertEquals(1, numberOfSubArrays.numOfSubarrays(new int[] { 1, 2, 3, 4, 5 }, 5, 3));

		// Test case 7: k larger than array length (should handle gracefully)
		assertEquals(0, numberOfSubArrays.numOfSubarrays(new int[] { 1, 2, 3 }, 4, 2));
	}
}
