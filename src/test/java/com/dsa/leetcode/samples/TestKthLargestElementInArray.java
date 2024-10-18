package com.dsa.leetcode.samples;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

class TestKthLargestElementInArray {

	private final KthLargestElementInArray obj = new KthLargestElementInArray();

	@Test
	public void testKthLargestElementInArrayShouldPass() {
		assertEquals(5, obj.findKthLargest(new int[] { 3, 2, 1, 5, 6, 4 }, 2));
		assertEquals(4, obj.findKthLargest(new int[] { 3, 2, 3, 1, 2, 4, 5, 5, 6 }, 4));
	}
	
	@Test
	public void testKthLargestElementInArrayShouldFail() {
		assertNotEquals(5, obj.findKthLargest(new int[] { 3, 2, 1, 4 }, 2));
	}

}
