package com.dsa.leetcode.samples;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestLastStoneWeight {

	private LastStoneWeight lastStoneWeight;

	@BeforeEach
	void setUp() {
		lastStoneWeight = new LastStoneWeight();
	}
	
    @Test
    public void testStandardCase() {
        int[] stones = {2, 3, 6, 2, 4};
        assertEquals(1, lastStoneWeight.lastStoneWeight(stones));
    }

    @Test
    public void testAllSameWeights() {
        int[] stones = {5, 5, 5, 5};
        assertEquals(0, lastStoneWeight.lastStoneWeight(stones));
    }

    @Test
    public void testOneStoneLeft() {
        int[] stones = {7, 4, 3, 1};
        // Step-by-step reduction results in 1 stone of weight 1
        assertEquals(1, lastStoneWeight.lastStoneWeight(stones));
    }

    @Test
    public void testSingleStone() {
        int[] stones = {10};
        assertEquals(10, lastStoneWeight.lastStoneWeight(stones));
    }

    @Test
    public void testTwoDifferentStones() {
        int[] stones = {7, 3};
        assertEquals(4, lastStoneWeight.lastStoneWeight(stones));
    }

    @Test
    public void testTwoSameStones() {
        int[] stones = {4, 4};
        assertEquals(0, lastStoneWeight.lastStoneWeight(stones));
    }

    @Test
    public void testEmptyInput() {
        int[] stones = {};
        assertEquals(0, lastStoneWeight.lastStoneWeight(stones));
    }

    @Test
    public void testAllZeros() {
        int[] stones = {0, 0, 0};
        assertEquals(0, lastStoneWeight.lastStoneWeight(stones));
    }

}
