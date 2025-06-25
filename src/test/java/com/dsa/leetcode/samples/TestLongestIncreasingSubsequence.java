package com.dsa.leetcode.samples;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestLongestIncreasingSubsequence {

	private LongestIncreasingSubsequence lis;

	@BeforeEach
	void setUp() {
		lis = new LongestIncreasingSubsequence();
	}

	@Test
    public void testExample1() {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        assertEquals(4, lis.lengthOfLIS(nums)); // LIS is [2, 3, 7, 101]
    }

    @Test
    public void testAllIncreasing() {
        int[] nums = {1, 2, 3, 4, 5};
        assertEquals(5, lis.lengthOfLIS(nums));
    }

    @Test
    public void testAllDecreasing() {
        int[] nums = {5, 4, 3, 2, 1};
        assertEquals(1, lis.lengthOfLIS(nums));
    }

    @Test
    public void testSingleElement() {
        int[] nums = {7};
        assertEquals(1, lis.lengthOfLIS(nums));
    }

    @Test
    public void testEmptyArray() {
        int[] nums = {};
        assertEquals(0, lis.lengthOfLIS(nums));
    }

    @Test
    public void testDuplicateElements() {
        int[] nums = {2, 2, 2, 2, 2};
        assertEquals(1, lis.lengthOfLIS(nums));
    }

    @Test
    public void testComplexCase() {
        int[] nums = {0, 1, 0, 3, 2, 3};
        assertEquals(4, lis.lengthOfLIS(nums)); // LIS could be [0, 1, 2, 3]
    }
}
