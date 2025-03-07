package com.dsa.leetcode.samples;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestPeakElementInArray {
	
	private PeakElementInArray peakElementInArray;
	
	@BeforeEach
	void setUp() {
		peakElementInArray = new PeakElementInArray();
	}
	
	@Test
    void findFirstPeakElementInMiddle() {
        int[] nums = {1, 2, 3, 1};
        assertEquals(2, peakElementInArray.findFirstPeakElement(nums));
    }

    @Test
    void findFirstPeakElementAtEnd() {
        int[] nums = {1, 2, 1, 3, 5, 5, 4};
        assertEquals(1, peakElementInArray.findFirstPeakElement(nums));
    }

    @Test
    void findFirstPeakElementSingleElement() {
        int[] nums = {1};
        assertEquals(0, peakElementInArray.findFirstPeakElement(nums));
    }

    @Test
    void findFirstPeakElementAllSame() {
        int[] nums = {2, 2, 2, 2};
        assertEquals(3, peakElementInArray.findFirstPeakElement(nums));
    }

    @Test
    void findFirstPeakElementEmptyArray() {
        int[] nums = {};
        assertEquals(-1, peakElementInArray.findFirstPeakElement(nums));
    }

    @Test
    void findFirstPeakElementNegativeNumbers() {
        int[] nums = {-3, -2, -1, -2, -3};
        assertEquals(2, peakElementInArray.findFirstPeakElement(nums));
    }
}
