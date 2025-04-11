package com.dsa.leetcode.samples;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestMissingNumber {

	private MissingNumber obj;
	
	@BeforeEach
	void setUp() {
		obj = new MissingNumber();
	}

	@Test
    void testMissingFromMiddle() {
        int[] nums = {0, 1, 3};
        assertEquals(2, obj.missingNumber(nums));
    }

    @Test
    void testMissingIsZero() {
        int[] nums = {1, 2, 3};
        assertEquals(0, obj.missingNumber(nums));
    }

    @Test
    void testMissingIsLast() {
        int[] nums = {0, 1, 2};
        assertEquals(3, obj.missingNumber(nums));
    }

    @Test
    void testTwoElements() {
        int[] nums = {0, 2};
        assertEquals(1, obj.missingNumber(nums));
    }

    @Test
    void testSingleElementMissingZero() {
        int[] nums = {1};
        assertEquals(0, obj.missingNumber(nums));
    }

    @Test
    void testSingleElementMissingOne() {
        int[] nums = {0};
        assertEquals(1, obj.missingNumber(nums));
    }

    @Test
    void testEmptyArray() {
        int[] nums = {};
        assertEquals(0, obj.missingNumber(nums));
    }
}
