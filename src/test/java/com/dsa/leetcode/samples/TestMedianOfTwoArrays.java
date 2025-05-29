package com.dsa.leetcode.samples;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestMedianOfTwoArrays {

	private MedianOfTwoArrays solution;
	
	@BeforeEach
	void setUp() {
		solution = new MedianOfTwoArrays();
	}

    @Test
    void testExample1() {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        assertEquals(2.0, solution.findMedianOfSortedArrays(nums1, nums2));
    }

    @Test
    void testEvenTotalLength() {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        assertEquals(2.5, solution.findMedianOfSortedArrays(nums1, nums2));
    }

    @Test
    void testAllZeroes() {
        int[] nums1 = {0, 0};
        int[] nums2 = {0, 0};
        assertEquals(0.0, solution.findMedianOfSortedArrays(nums1, nums2));
    }

    @Test
    void testOneEmptyArray1() {
        int[] nums1 = {};
        int[] nums2 = {1};
        assertEquals(1.0, solution.findMedianOfSortedArrays(nums1, nums2));
    }

    @Test
    void testOneEmptyArray2() {
        int[] nums1 = {2};
        int[] nums2 = {};
        assertEquals(2.0, solution.findMedianOfSortedArrays(nums1, nums2));
    }

    @Test
    void testBothSingleElement() {
        int[] nums1 = {1};
        int[] nums2 = {2};
        assertEquals(1.5, solution.findMedianOfSortedArrays(nums1, nums2));
    }

    @Test
    void testLargeArrays() {
        int[] nums1 = {1, 3, 8, 9, 15};
        int[] nums2 = {7, 11, 18, 19, 21, 25};
        assertEquals(11.0, solution.findMedianOfSortedArrays(nums1, nums2));
    }

    @Test
    void testNegativeNumbers() {
        int[] nums1 = {-5, -3, -1};
        int[] nums2 = {-2, 0, 2};
        assertEquals(-1.5, solution.findMedianOfSortedArrays(nums1, nums2));
    }

    @Test
    void testSingleElementEach() {
        int[] nums1 = {1000};
        int[] nums2 = {2000};
        assertEquals(1500.0, solution.findMedianOfSortedArrays(nums1, nums2));
    }

    @Test
    void testAllElementsSame() {
        int[] nums1 = {2, 2, 2};
        int[] nums2 = {2, 2};
        assertEquals(2.0, solution.findMedianOfSortedArrays(nums1, nums2));
    }

}
