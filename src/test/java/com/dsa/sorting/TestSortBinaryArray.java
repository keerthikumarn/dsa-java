package com.dsa.sorting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestSortBinaryArray {

	private SortBinaryArray sorter;
	
	@BeforeEach
	void setUp() {
		sorter = new SortBinaryArray();
	}
	
	@Test
    void testSortedArray() {
        int[] arr = {0, 1, 0, 1, 1, 0, 0};
        sorter.sortBinaryArray(arr);
        assertArrayEquals(new int[]{0, 0, 0, 0, 1, 1, 1}, arr);
    }

    @Test
    void testAlreadySortedArray() {
        int[] arr = {0, 0, 0, 1, 1, 1};
        sorter.sortBinaryArray(arr);
        assertArrayEquals(new int[]{0, 0, 0, 1, 1, 1}, arr);
    }

    @Test
    void testAllZeros() {
        int[] arr = {0, 0, 0, 0};
        sorter.sortBinaryArray(arr);
        assertArrayEquals(new int[]{0, 0, 0, 0}, arr);
    }

    @Test
    void testAllOnes() {
        int[] arr = {1, 1, 1, 1};
        sorter.sortBinaryArray(arr);
        assertArrayEquals(new int[]{1, 1, 1, 1}, arr);
    }

    @Test
    void testEmptyArray() {
        int[] arr = {};
        sorter.sortBinaryArray(arr);
        assertArrayEquals(new int[]{}, arr);
    }

}
