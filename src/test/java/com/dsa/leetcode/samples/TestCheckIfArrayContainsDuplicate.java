package com.dsa.leetcode.samples;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCheckIfArrayContainsDuplicate {

	private final CheckIfArrayContainsDuplicate duplicateCheck = new CheckIfArrayContainsDuplicate();

	@Test
	public void testCheckIfArrayContainsDuplicateTrue() {
		int[] nums = { 1, 2, 3, 3 };
		boolean result = duplicateCheck.hasDuplicate(nums);
		assertEquals(true, result);
	}

	@Test
	public void testCheckIfArrayContainsDuplicateFalse() {
		int[] nums = { 1, 2, 3, 4 };
		boolean result = duplicateCheck.hasDuplicate(nums);
		assertEquals(false, result);
	}
}
