package com.dsa.slidingwindow;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.dsa.slidingiwindow.MinimumSizeSubArray;

class TestMinimumSizeSubArray {

	private MinimumSizeSubArray obj;
	
	@BeforeEach
	void setUp() {
		obj = new MinimumSizeSubArray();
	}
	
	@Test
    void testBasicCase() {
        assertEquals(2, obj.minSum(new int[]{2, 3, 1, 2, 4, 3}, 7));
    }

    @Test
    void testExactSum() {
        assertEquals(1, obj.minSum(new int[]{1, 2, 3, 4, 5}, 5));
    }

    @Test
    void testNoValidSubarray() {
        assertEquals(0, obj.minSum(new int[]{1, 1, 1, 1}, 10));
    }

    @Test
    void testSingleElementValid() {
        assertEquals(1, obj.minSum(new int[]{10, 2, 3}, 10));
    }

    @Test
    void testSingleElementInvalid() {
        assertEquals(0, obj.minSum(new int[]{1, 2, 3}, 10));
    }

    @Test
    void testEmptyArray() {
        assertEquals(0, obj.minSum(new int[]{}, 5));
    }

}
