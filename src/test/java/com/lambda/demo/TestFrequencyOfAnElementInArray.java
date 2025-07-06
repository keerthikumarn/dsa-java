package com.lambda.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestFrequencyOfAnElementInArray {

	private FrequencyOfAnElementInArray frequencyCounter;
	
	@BeforeEach
	public void setUp() {
		frequencyCounter = new FrequencyOfAnElementInArray();
	}
	
	@Test
    void testFrequency_elementExistsMultipleTimes() {
        int[] nums = {1, 2, 2, 3, 2, 4};
        int target = 2;
        int expected = 3;
        int result = frequencyCounter.countFrequency(nums, target);
        assertEquals(expected, result);
    }

    @Test
    void testFrequencyElementExistsOnce() {
        int[] nums = {1, 2, 3, 4};
        int target = 3;
        int expected = 1;
        int result = frequencyCounter.countFrequency(nums, target);
        assertEquals(expected, result);
    }

    @Test
    void testFrequencyElementNotPresent() {
        int[] nums = {1, 2, 3, 4};
        int target = 5;
        int result = frequencyCounter.countFrequency(nums, target);
        assertEquals(0, result);
    }

    @Test
    void testFrequencyAllSameElements() {
        int[] nums = {7, 7, 7, 7};
        int target = 7;
        int result = frequencyCounter.countFrequency(nums, target);
        assertEquals(4, result);
    }

    @Test
    void testFrequencyEmptyArray() {
        int[] nums = {};
        int target = 1;
        int result = frequencyCounter.countFrequency(nums, target);
        assertEquals(0, result);
    }

    @Test
    void testFrequencyWithNegativeNumbers() {
        int[] nums = {-1, -2, -1, -3};
        int target = -1;
        int result = frequencyCounter.countFrequency(nums, target);
        assertEquals(2, result);
    }

    @Test
    void testFrequencyWithLargeNumbers() {
        int[] nums = {Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE};
        int target = Integer.MAX_VALUE;
        int result = frequencyCounter.countFrequency(nums, target);
        assertEquals(2, result);
    }

}
